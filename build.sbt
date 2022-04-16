import Dependencies._

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "windymelt"
ThisBuild / organizationName := "windymelt"

val AkkaVersion = "2.6.14"

lazy val root = (project in file("."))
  .settings(
    name := "ja-rhythm",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "com.lightbend.akka" %% "akka-stream-alpakka-xml" % "3.0.4",
      "com.typesafe.akka" %% "akka-stream" % AkkaVersion
      // "com.atilika.kuromoji" % "kuromoji-ipadic" % "0.9.0"
    )
  )
