import sbtrelease.ReleaseStateTransformations._
import sbtrelease._
import Utils._

val updateReadme = { state: State =>
  val extracted  = Project.extract(state)
  val v          = extracted get version
  val org        = extracted get organization
  val n          = extracted get name
  val readme     = "README.md"
  val readmeFile = file(readme)
  val newReadme = Predef
    .augmentString(IO.read(readmeFile))
    .lines
    .map { line =>
      val matchReleaseOrSnapshot = line.contains("SNAPSHOT") == v.contains("SNAPSHOT")
      if (line.startsWith("libraryDependencies") && matchReleaseOrSnapshot) {
        s"""libraryDependencies += "$org" %% "$n" % "$v""""
      } else line
    }
    .mkString("", "\n", "\n")
  IO.write(readmeFile, newReadme)
  val git = new Git(extracted get baseDirectory)
  git.add(readme) ! state.log.toScalaProcessLogger
  git.commit("update " + readme, sign = false, signOff = false) ! state.log.toScalaProcessLogger
  git.cmd("diff", "HEAD^") ! state.log.toScalaProcessLogger
  state
}

releaseCrossBuild := true
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  // For non cross-build projects, use releaseStepCommand("publishSigned")
  releaseStepCommandAndRemaining("+publishSigned"),
  setNextVersion,
  commitNextVersion,
  updateReadme,
  releaseStepCommand("sonatypeReleaseAll"),
  pushChanges
)
