
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/kennethroffo/Documents/PlayStockMarketSimulator/conf/routes
// @DATE:Thu Mar 23 15:46:02 EDT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:13
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseCountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CountController.count",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseCompanyQuery(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def getCompany: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompanyQuery.getCompany",
      """
        function(symbol0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "companies/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("symbol", encodeURIComponent(symbol0))})
        }
      """
    )
  
    // @LINE:23
    def deleteCompany: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompanyQuery.deleteCompany",
      """
        function(symbol0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "companies/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("symbol", encodeURIComponent(symbol0))})
        }
      """
    )
  
    // @LINE:21
    def updateCompany: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CompanyQuery.updateCompany",
      """
        function(symbol0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "companies/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("symbol", encodeURIComponent(symbol0))})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseCompanies(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def postCompany: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Companies.postCompany",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "companies"})
        }
      """
    )
  
    // @LINE:15
    def getCompanies: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Companies.getCompanies",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "companies"})
        }
      """
    )
  
  }


}
