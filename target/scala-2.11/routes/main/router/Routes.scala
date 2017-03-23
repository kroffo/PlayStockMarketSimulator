
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/stephendicerce/csc435/PlayStockMarketSimulator/conf/routes
// @DATE:Thu Mar 23 16:11:27 EDT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_4: controllers.HomeController,
  // @LINE:8
  CountController_3: controllers.CountController,
  // @LINE:10
  AsyncController_5: controllers.AsyncController,
  // @LINE:13
  Assets_7: controllers.Assets,
  // @LINE:15
  Companies_6: controllers.Companies,
  // @LINE:17
  CompanyQuery_0: controllers.CompanyQuery,
  // @LINE:20
  Users_2: controllers.Users,
  // @LINE:22
  UserQuery_1: controllers.UserQuery,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_4: controllers.HomeController,
    // @LINE:8
    CountController_3: controllers.CountController,
    // @LINE:10
    AsyncController_5: controllers.AsyncController,
    // @LINE:13
    Assets_7: controllers.Assets,
    // @LINE:15
    Companies_6: controllers.Companies,
    // @LINE:17
    CompanyQuery_0: controllers.CompanyQuery,
    // @LINE:20
    Users_2: controllers.Users,
    // @LINE:22
    UserQuery_1: controllers.UserQuery
  ) = this(errorHandler, HomeController_4, CountController_3, AsyncController_5, Assets_7, Companies_6, CompanyQuery_0, Users_2, UserQuery_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_4, CountController_3, AsyncController_5, Assets_7, Companies_6, CompanyQuery_0, Users_2, UserQuery_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """companies""", """controllers.Companies.getCompanies"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """companies/""" + "$" + """symbol<[^/]+>""", """controllers.CompanyQuery.getCompany(symbol:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.Users.getUsers(sortingMethod:String ?= null, companyName:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """name<[^/]+>""", """controllers.UserQuery.getUser(name:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_4.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_3.count,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      """ An example controller showing how to use dependency injection""",
      this.prefix + """count"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_5.message,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      """ An example controller showing how to write asynchronous code""",
      this.prefix + """message"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_7.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Companies_getCompanies4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("companies")))
  )
  private[this] lazy val controllers_Companies_getCompanies4_invoker = createInvoker(
    Companies_6.getCompanies,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Companies",
      "getCompanies",
      Nil,
      "GET",
      """""",
      this.prefix + """companies"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_CompanyQuery_getCompany5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("companies/"), DynamicPart("symbol", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CompanyQuery_getCompany5_invoker = createInvoker(
    CompanyQuery_0.getCompany(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CompanyQuery",
      "getCompany",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """companies/""" + "$" + """symbol<[^/]+>"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Users_getUsers6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_Users_getUsers6_invoker = createInvoker(
    Users_2.getUsers(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Users",
      "getUsers",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """users"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_UserQuery_getUser7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserQuery_getUser7_invoker = createInvoker(
    UserQuery_1.getUser(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserQuery",
      "getUser",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """users/""" + "$" + """name<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_4.index)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_3.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message2_route(params) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_5.message)
      }
  
    // @LINE:13
    case controllers_Assets_versioned3_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_7.versioned(path, file))
      }
  
    // @LINE:15
    case controllers_Companies_getCompanies4_route(params) =>
      call { 
        controllers_Companies_getCompanies4_invoker.call(Companies_6.getCompanies)
      }
  
    // @LINE:17
    case controllers_CompanyQuery_getCompany5_route(params) =>
      call(params.fromPath[String]("symbol", None)) { (symbol) =>
        controllers_CompanyQuery_getCompany5_invoker.call(CompanyQuery_0.getCompany(symbol))
      }
  
    // @LINE:20
    case controllers_Users_getUsers6_route(params) =>
      call(params.fromQuery[String]("sortingMethod", Some(null)), params.fromQuery[String]("companyName", Some(null))) { (sortingMethod, companyName) =>
        controllers_Users_getUsers6_invoker.call(Users_2.getUsers(sortingMethod, companyName))
      }
  
    // @LINE:22
    case controllers_UserQuery_getUser7_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_UserQuery_getUser7_invoker.call(UserQuery_1.getUser(name))
      }
  }
}
