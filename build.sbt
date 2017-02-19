import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.github.hayasshi",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "akkahttp_easyrouter",
    scalacOptions ++= {
      Seq("-unchecked", "-deprecation", "-feature", "-language:implicitConversions", "-language:higherKinds", "-Xfuture", "-Xlint")
    },
    libraryDependencies ++= Seq(
      akkaHttp % Provided,
      akkaHttpTestKit % Test,
      scalaTest % Test
    )
  )
