import sbt.Keys.{libraryDependencies, logLevel, resolvers, scalacOptions, version}

lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.12.6",
  scalacOptions ++= Seq("-deprecation", "-feature"/*, "-Ypartial-unification"*/),
  logBuffered in Test := false,
  logLevel := Level.Warn,
  libraryDependencies ++= Seq(
    "org.scalactic" %% "scalactic" % "3.0.5",
    "org.scalatest" %% "scalatest" % "3.0.5" % "test",
    "com.typesafe" % "config" % "1.3.3",
    "com.github.ktakagaki.breeze" %% "breeze" % "0.15.1"
//    "org.scalanlp" %% "breeze" % "0.15.1",
//    "org.scalanlp" %% "breeze-natives" % "0.15.1",
//    "org.scalanlp" %% "breeze-viz" % "0.15.1"
    /*,
    "org.typelevel" %% "cats-core" % "1.2.0"*/
  ),
  resolvers ++= Seq(
    Opts.resolver.sonatypeSnapshots,
    "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/",
    "Artima Maven Repository" at "http://repo.artima.com/releases"
//    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
//    "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
  )
)

lazy val shared = project
  .settings(
    commonSettings,
    name := "open-tetris-shared"
  )

lazy val desktop = project
  .settings(
    commonSettings,
    name := "open-tetris-desktop",
    libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.144-R12",
    libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.4",
    // Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
    fork := true,
    scalacOptions ++= Seq("-unchecked", "-Xcheckinit", "-encoding", "utf8")
  ).dependsOn(shared)
