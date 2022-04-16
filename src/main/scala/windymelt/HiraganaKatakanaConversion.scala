package windymelt

trait HiraganaKatakanaConversion {
  def toHiragana(s: String): String = s.map(toHiragana)
  def toHiragana(c: Char) = c match {
    case 'ア'       => 'あ'
    case 'イ'       => 'い'
    case 'ウ'       => 'う'
    case 'エ'       => 'え'
    case 'オ'       => 'お'
    case 'カ'       => 'か'
    case 'キ'       => 'き'
    case 'ク'       => 'く'
    case 'ケ'       => 'け'
    case 'コ'       => 'こ'
    case 'サ'       => 'さ'
    case 'シ'       => 'し'
    case 'ス'       => 'す'
    case 'セ'       => 'せ'
    case 'ソ'       => 'そ'
    case 'タ'       => 'た'
    case 'チ'       => 'ち'
    case 'ツ'       => 'つ'
    case 'テ'       => 'て'
    case 'ト'       => 'と'
    case 'ナ'       => 'な'
    case 'ニ'       => 'に'
    case 'ヌ'       => 'ぬ'
    case 'ネ'       => 'ね'
    case 'ノ'       => 'の'
    case 'ハ'       => 'は'
    case 'ヒ'       => 'ひ'
    case 'フ'       => 'ふ'
    case 'ヘ'       => 'へ'
    case 'ホ'       => 'ほ'
    case 'マ'       => 'ま'
    case 'ミ'       => 'み'
    case 'ム'       => 'む'
    case 'メ'       => 'め'
    case 'モ'       => 'も'
    case 'ヤ'       => 'や'
    case 'ユ'       => 'ゆ'
    case 'ヨ'       => 'よ'
    case 'ラ'       => 'ら'
    case 'リ'       => 'り'
    case 'ル'       => 'る'
    case 'レ'       => 'れ'
    case 'ロ'       => 'ろ'
    case 'ワ'       => 'わ'
    case 'ヲ'       => 'を'
    case 'ン'       => 'ん'
    case 'ガ'       => 'が'
    case 'ギ'       => 'ぎ'
    case 'グ'       => 'ぐ'
    case 'ゲ'       => 'げ'
    case 'ゴ'       => 'ご'
    case 'ザ'       => 'ざ'
    case 'ジ'       => 'じ'
    case 'ズ'       => 'ず'
    case 'ゼ'       => 'ぜ'
    case 'ゾ'       => 'ぞ'
    case 'ダ'       => 'だ'
    case 'ヂ'       => 'ぢ'
    case 'ヅ'       => 'づ'
    case 'デ'       => 'で'
    case 'ド'       => 'ど'
    case 'バ'       => 'ば'
    case 'ビ'       => 'び'
    case 'ブ'       => 'ぶ'
    case 'ベ'       => 'べ'
    case 'ボ'       => 'ぼ'
    case 'パ'       => 'ぱ'
    case 'ピ'       => 'ぴ'
    case 'プ'       => 'ぷ'
    case 'ペ'       => 'ぺ'
    case 'ポ'       => 'ぽ'
    case 'ァ'       => 'ぁ'
    case 'ィ'       => 'ぃ'
    case 'ゥ'       => 'ぅ'
    case 'ェ'       => 'ぇ'
    case 'ォ'       => 'ぉ'
    case 'ャ'       => 'ゃ'
    case 'ュ'       => 'ゅ'
    case 'ョ'       => 'ょ'
    case 'ッ'       => 'っ'
    case 'ヮ'       => 'ゎ'
    case 'ー'       => 'ー'
    case otherwise => otherwise
  }
}
