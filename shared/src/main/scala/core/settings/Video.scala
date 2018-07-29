package core.settings

import com.typesafe.config.Config

private[settings] object Video {

  private[settings] def checkValid(video: Config): Unit = {
    require(video.getInt("width") >= 0)
    require(video.getInt("height") >= 0)
  }
}
