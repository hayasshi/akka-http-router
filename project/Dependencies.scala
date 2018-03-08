import sbt._

object Dependencies {

  object Versions {
    // same version as akka-http
    val crossScalaVersions = Seq("2.11.11", "2.12.4")
    val scalaVersion       = crossScalaVersions.last
    val akkaHttpVersion    = "10.0.11"
  }

  lazy val akkaHttp        = "com.typesafe.akka" %% "akka-http" % Versions.akkaHttpVersion
  lazy val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttpVersion

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"

}
