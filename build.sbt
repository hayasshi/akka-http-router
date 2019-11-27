import Dependencies._
import xerial.sbt.Sonatype._

lazy val root = (project in file(".")).
  settings(
    organization := "com.github.hayasshi",
    name         := "akka-http-router",

    scalaVersion       := Versions.scalaVersion,
    crossScalaVersions := Versions.crossScalaVersions,

    scalacOptions ++= {
      Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions", "-language:higherKinds", "-Xlint")
    },

    libraryDependencies ++= Seq(
      akkaStream % Provided,
      akkaHttp % Provided,
      scalaTest % Test,
      akkaStreamTestKit % Test,
      akkaHttpTestKit % Test
    ),

    // for sbt-sonatype settings
    sonatypeProfileName := organization.value,
    publishMavenStyle := true,
    publishTo := sonatypePublishToBundle.value,

    // for sbt-sonatype pomExtra settings
    licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    sonatypeProjectHosting := Some(GitHubHosting("hayasshi", "akka-http-router", "Daisuke Hayashi", "daisuke0884@gmail.com")),

    credentials += Credentials(
      "Sonatype Nexus Repository Manager",
      "oss.sonatype.org",
      sys.env.getOrElse("SONATYPE_USER", ""),
      sys.env.getOrElse("SONATYPE_PASSWORD", "")
    )
  )
