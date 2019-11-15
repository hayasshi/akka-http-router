import Dependencies._

lazy val root = (project in file(".")).
  settings(
    organization := "com.github.hayasshi",
    name         := "akka-http-router",

    scalaVersion       := Versions.scalaVersion,
    crossScalaVersions := Versions.crossScalaVersions,

    scalacOptions ++= {
      Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions", "-language:higherKinds", "-Xfuture", "-Xlint")
    },

    libraryDependencies ++= Seq(
      akkaStream % Provided,
      akkaHttp % Provided,
      scalaTest % Test,
      akkaStreamTestKit % Test,
      akkaHttpTestKit % Test
    ),

    pomExtra in Global := {
      <url>https://github.com/hayasshi/akka-http-router</url>
      <licenses>
        <license>
          <name>Apache 2</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git:github.com/hayasshi/akka-http-router</connection>
        <developerConnection>scm:git:git@github.com:hayasshi/akka-http-router</developerConnection>
        <url>github.com/hayasshi/akka-http-router</url>
      </scm>
      <developers>
        <developer>
          <id>hayasshi</id>
          <name>Daisuke Hayashi</name>
          <url>https://github.com/hayasshi</url>
        </developer>
      </developers>
    },

    publishTo := sonatypePublishTo.value,
    publishMavenStyle := true,

    credentials += Credentials(
      "Sonatype Nexus Repository Manager",
      "oss.sonatype.org",
      sys.env.getOrElse("SONATYPE_USER", ""),
      sys.env.getOrElse("SONATYPE_PASSWORD", "")
    )
  )
