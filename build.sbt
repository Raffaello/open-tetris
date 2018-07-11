name := "open-tetris"

version := "0.1"

scalaVersion := "2.12.6"

scalacOptions ++= Seq("-deprecation","-feature")

logBuffered in Test := false
logLevel := Level.Warn


libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.144-R12"
libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.4"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

//resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
resolvers += Opts.resolver.sonatypeSnapshots
resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
