logLevel := Level.Warn

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
//addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3")
addSbtPlugin("com.codacy" % "sbt-codacy-coverage" % "1.3.12")