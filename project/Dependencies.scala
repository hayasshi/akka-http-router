import sbt._

object Dependencies {

  object Versions {
    // same version as akka-http
    val crossScalaVersions = Seq("2.11.12", "2.12.6")
    val scalaVersion       = crossScalaVersions.head
    val akkaVersion        = "2.5.26"
    val akkaHttpVersion    = "10.1.4"
  }

  lazy val akkaStream      = "com.typesafe.akka" %% "akka-stream" % Versions.akkaVersion
  lazy val akkaHttp        = "com.typesafe.akka" %% "akka-http" % Versions.akkaHttpVersion
  lazy val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttpVersion

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

}
