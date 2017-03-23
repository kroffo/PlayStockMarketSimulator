
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/stephendicerce/csc435/PlayStockMarketSimulator/conf/routes
// @DATE:Thu Mar 23 16:11:27 EDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
