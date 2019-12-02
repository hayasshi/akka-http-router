import sbt._

object Dependencies {

  object Versions {
    val crossScalaVersions = Seq("2.13.1", "2.12.10", "2.11.12")
    val scalaVersion       = crossScalaVersions.head
    val akkaVersion        = "2.5.26"
    val akkaHttpVersion    = "10.1.10"
  }

  lazy val akkaStream        = "com.typesafe.akka" %% "akka-stream" % Versions.akkaVersion
  lazy val akkaStreamTestKit = "com.typesafe.akka" %% "akka-stream-testkit" % Versions.akkaVersion
  lazy val akkaHttp          = "com.typesafe.akka" %% "akka-http" % Versions.akkaHttpVersion
  lazy val akkaHttpTestKit   = "com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttpVersion

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.1.0"

}
