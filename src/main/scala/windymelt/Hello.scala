package windymelt

import akka.actor.ActorSystem
import akka.stream._
import akka.stream.alpakka.xml.EndElement
import akka.stream.alpakka.xml.StartElement
import akka.stream.alpakka.xml.TextEvent
import akka.stream.alpakka.xml.scaladsl.XmlParsing
import akka.stream.scaladsl._
import akka.util.ByteString

import java.nio.file.Paths
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration.Duration
import scala.concurrent.duration._
import scala.util.matching.Regex

object Hello extends App with NameExtractor with HiraganaKatakanaConversion {
  import scala.language.postfixOps

  implicit val system: ActorSystem = ActorSystem("JaRhythm")

  val pattern = args(0)
  val file = Paths.get("jawiki-latest-abstract.xml")
  val source = FileIO.fromPath(file)

  var ddMap: collection.mutable.Map[String, Seq[String]] =
    collection.mutable.Map().withDefaultValue(Seq.empty)

  val foreach: Future[IOResult] = FileIO
    .fromPath(file)
    .map(ByteString(_))
    // .throttle(10, 1 second)
    .via(XmlParsing.parser)
    .statefulMapConcat(() => {
      // state
      val textBuffer = StringBuilder.newBuilder
      // aggregation function
      parseEvent =>
        parseEvent match {
          case s: StartElement =>
            textBuffer.clear()
            Seq.empty
          case s: EndElement if s.localName == "abstract" =>
            val text = textBuffer.toString
            Seq(text)
          case t: TextEvent =>
            textBuffer.append(t.text)
            Seq.empty
          case _ =>
            Seq.empty
        }
    })
    .map(extractName)
    .map {
      case Some((Some(name), Some(punct))) =>
        val ddpunct = DotDashMap.dotDashParse(punct)
        // println(s"$ddpunct => $name")
        if (ddpunct == pattern) {
          println(s"$name")
        }
        ddMap(ddpunct) = ddMap(ddpunct) :+ name
      case otherwise => ()
    }
    .to(Sink.ignore)
    .run()

  Await.result(foreach, Duration.Inf)

  println(ddMap.get(pattern))
}

trait NameExtractor {
  self: HiraganaKatakanaConversion =>
  val re: Regex = """([^（]+)(（([^）、]+)(、.*)?）)?[とで]?は、?""".r
  def extractName(s: String) = {
    // println(s)
    (for {
      m <- re.findAllMatchIn(s)
    } yield {
      val name = Option(m.group(1))
      val punct = Option(m.group(3)).map(toHiragana)
      (name, punct)
    }).toSeq.headOption
  }
}
