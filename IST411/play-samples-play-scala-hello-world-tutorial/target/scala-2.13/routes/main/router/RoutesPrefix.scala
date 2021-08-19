// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/godli/OneDrive/classes/IST411/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Wed Aug 12 10:33:03 EDT 2020


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
