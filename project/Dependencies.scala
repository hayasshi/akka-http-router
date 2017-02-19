import sbt._

object Dependencies {
  val akkaHttpVersion = "10.0.3"

  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  lazy val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"
}
