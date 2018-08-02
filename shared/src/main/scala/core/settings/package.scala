package core

import com.typesafe.config.{Config, ConfigFactory}

package object settings {

  private[this] val config: Config = ConfigFactory.load()

  config.checkValid(ConfigFactory.defaultReference())

  val core: Config = config.getConfig("core")
  val polyominoes: Config = core.getConfig("polyominoes")
  val board: Config = core.getConfig("board")
  val sounds: Config = core.getConfig("sounds")
  //  val fx: Config = sounds.getConfig("fx")
  //  val music: Config = sounds.getConfig("music")
  val video: Config = core.getConfig("video")
  val fonts: Config = core.getConfig("fonts")
  val gameplay: Config = core.getConfig("gameplay")


  Polyominoes.checkValid(polyominoes)
  Video.checkValid(video)
  Board.checkValid(board)
}
