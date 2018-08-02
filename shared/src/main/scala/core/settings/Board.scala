package core.settings

import com.typesafe.config.Config

private[settings] object Board {

  private[settings] def checkValid(board: Config) = {
    require(video.getInt("rows") >= 0)
    require(video.getInt("cols") >= 0)
  }
}
