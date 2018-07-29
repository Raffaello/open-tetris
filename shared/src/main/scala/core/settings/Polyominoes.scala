package core.settings

import com.typesafe.config.Config

private[settings] object Polyominoes {

  private[this] def checkType(polyType: String): Unit = {
    val types: Set[String] = Set("free", "one-side")
    require(types.contains(polyType))
  }

  def checkValid(poly: Config): Unit = {
    checkType(poly.getString("type"))
  }
}
