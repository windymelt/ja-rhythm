## ja-rhythm

特定のパターンになる日本語を探すツール

## Usage

○をピリオドに、ーをハイフンに置換して問合わせます。例えば、`○ー○ー○ー○`のようなパターンの場合は、`.-.-.-.`を与えます。

```shell
$ sbt "run .-.-.-.-.-."
[info] welcome to sbt 1.6.2 (Ubuntu Java 11.0.14.1)
...
[info] running example.Hello .-.-.-.-.-.
定量PCR
PojkART
『KUTVニュース』
EARLY MORLEY BIRD
スーパーヒーロー映画
Some(List(定量PCR, PojkART, 『KUTVニュース』, EARLY MORLEY BIRD, スーパーヒーロー映画))
[success] Total time: 138 s (02:18), completed 2022/04/17 3:14:35
```

## Prerequisites

Wikipediaの要約データが必要です。

https://ja.wikipedia.org/wiki/Wikipedia:%E3%83%87%E3%83%BC%E3%82%BF%E3%83%99%E3%83%BC%E3%82%B9%E3%83%80%E3%82%A6%E3%83%B3%E3%83%AD%E3%83%BC%E3%83%89 から `https://dumps.wikimedia.org/jawiki/latest/jawiki-latest-abstract.xml.gz`
 をダウンロードしてプロジェクト直下に置いてください。

## Motivation

[◯ー◯ー◯◯ー◯ー◯ー](https://anond.hatelabo.jp/20210113213530) を知りたくて困ったため
