name := "UnicornBotFirst"

version := "0.1"

scalaVersion := "2.11.7"

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "net.ceedubs" %% "ficus" % "1.1.2",
  "info.mukel" %% "telegrambot4s" % "1.0.1-SNAPSHOT"
)