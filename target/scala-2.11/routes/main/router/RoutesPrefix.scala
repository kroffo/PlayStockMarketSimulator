
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/kennethroffo/Documents/PlayStockMarketSimulator/conf/routes
// @DATE:Thu Mar 23 15:46:02 EDT 2017


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
