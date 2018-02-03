name := "Scala Hello World Demo"

version := "0.1"

organization := "org.my"

scalaVersion := "2.12.4"

sbtVersion := "1.0.4"

libraryDependencies ++= Seq(
  "com.opencsv" % "opencsv" % "4.1",
  "org.ta4j" % "ta4j-core" % "0.11",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)