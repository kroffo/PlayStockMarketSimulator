
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[services.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: services.User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import services.User

Seq[Any](format.raw/*1.23*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(user.getName())/*5.22*/ {_display_(Seq[Any](format.raw/*5.24*/("""

"""),format.raw/*7.1*/("""<html>
  <head><title>Company Query Page</title></head>
  <body>
    <button OnClick="list()">List</button>
    <button OnClick="query()">Query</button>
    <button OnClick="login()">Log in</button>
    <button OnClick="signup()">Sign Up</button>
    <div id="responseField"></div>
    <script>	
      function list() """),format.raw/*16.23*/("""{"""),format.raw/*16.24*/("""
        """),format.raw/*17.9*/("""var xmlHttp = new XMLHttpRequest();
        var url = location.origin + "/companies?list=true";
        xmlHttp.open( "GET", url, false ); // false for synchronous request
        xmlHttp.send( null );
        var res = xmlHttp.responseText;
        document.getElementById("responseField").innerHTML = res;
      """),format.raw/*23.7*/("""}"""),format.raw/*23.8*/("""
      
      """),format.raw/*25.7*/("""function query() """),format.raw/*25.24*/("""{"""),format.raw/*25.25*/("""
        """),format.raw/*26.9*/("""var name = prompt("Enter the name of the company you wish to learn about:");
        if(name != null) """),format.raw/*27.26*/("""{"""),format.raw/*27.27*/("""
          """),format.raw/*28.11*/("""var xmlHttp = new XMLHttpRequest();
          var url = location.origin + "/companies?name=" + name;
          xmlHttp.open( "GET", url, false ); // false for synchronous request
          xmlHttp.send( null );
          var res = xmlHttp.responseText;
          document.getElementById("responseField").innerHTML = res;
        """),format.raw/*34.9*/("""}"""),format.raw/*34.10*/("""
      """),format.raw/*35.7*/("""}"""),format.raw/*35.8*/("""
      
      """),format.raw/*37.7*/("""function login() """),format.raw/*37.24*/("""{"""),format.raw/*37.25*/("""
        """),format.raw/*38.9*/("""var name = prompt("Enter a name:");
        if(name != null) """),format.raw/*39.26*/("""{"""),format.raw/*39.27*/("""
          """),format.raw/*40.11*/("""var pass = prompt("Enter a password");
          if(pass != null) """),format.raw/*41.28*/("""{"""),format.raw/*41.29*/("""
            """),format.raw/*42.13*/("""var url = location.origin + "/login?name=" + name + "&pass=" + pass;
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open( "GET", url, false ); // false for synchronous request
            xmlHttp.send( null );
            var response = xmlHttp.responseText;
            console.log(response);
            var json = JSON.parse(response);
            if(json.login_status) """),format.raw/*49.35*/("""{"""),format.raw/*49.36*/("""
              """),format.raw/*50.15*/("""window.location.replace(location.origin + "/dashboard");
            """),format.raw/*51.13*/("""}"""),format.raw/*51.14*/(""" """),format.raw/*51.15*/("""else """),format.raw/*51.20*/("""{"""),format.raw/*51.21*/("""
              """),format.raw/*52.15*/("""console.log(json.error);
              alert("Login failed.");
            """),format.raw/*54.13*/("""}"""),format.raw/*54.14*/("""
          """),format.raw/*55.11*/("""}"""),format.raw/*55.12*/("""
        """),format.raw/*56.9*/("""}"""),format.raw/*56.10*/("""
      """),format.raw/*57.7*/("""}"""),format.raw/*57.8*/("""
      
      """),format.raw/*59.7*/("""function signup() """),format.raw/*59.25*/("""{"""),format.raw/*59.26*/("""
        """),format.raw/*60.9*/("""var name = prompt("Enter a name:");
        if(name != null) """),format.raw/*61.26*/("""{"""),format.raw/*61.27*/("""
          """),format.raw/*62.11*/("""var pass = prompt("Enter a password");
            if(pass != null) """),format.raw/*63.30*/("""{"""),format.raw/*63.31*/("""
            """),format.raw/*64.13*/("""var url = location.origin + "/signup?name=" + name + "&pass=" + pass;
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open( "GET", url, false ); // false for synchronous request
            xmlHttp.send( null );
            var status = JSON.parse(xmlHttp.responseText).login_status;
            if(status) """),format.raw/*69.24*/("""{"""),format.raw/*69.25*/("""
              """),format.raw/*70.15*/("""window.location.replace(location.origin + "/dashboard");
            """),format.raw/*71.13*/("""}"""),format.raw/*71.14*/(""" """),format.raw/*71.15*/("""else """),format.raw/*71.20*/("""{"""),format.raw/*71.21*/("""
              """),format.raw/*72.15*/("""alert("Username taken.");
            """),format.raw/*73.13*/("""}"""),format.raw/*73.14*/("""
            
          """),format.raw/*75.11*/("""}"""),format.raw/*75.12*/("""
        """),format.raw/*76.9*/("""}"""),format.raw/*76.10*/("""
      """),format.raw/*77.7*/("""}"""),format.raw/*77.8*/("""
    """),format.raw/*78.5*/("""</script>
  </body>
</html>


""")))}),format.raw/*83.2*/("""
"""))
      }
    }
  }

  def render(user:services.User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((services.User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


}

/**/
object login extends login_Scope0.login
              /*
                  -- GENERATED --
                  DATE: Thu Mar 23 11:46:03 EDT 2017
                  SOURCE: /Users/stephendicerce/csc435/PlayStockMarketSimulator/app/views/login.scala.html
                  HASH: 83a16d71c20793cc218dcb44c6199157cf64b85d
                  MATRIX: 752->1|888->22|916->46|943->48|971->68|1010->70|1038->72|1384->390|1413->391|1449->400|1790->714|1818->715|1859->729|1904->746|1933->747|1969->756|2099->858|2128->859|2167->870|2523->1199|2552->1200|2586->1207|2614->1208|2655->1222|2700->1239|2729->1240|2765->1249|2854->1310|2883->1311|2922->1322|3016->1388|3045->1389|3086->1402|3508->1796|3537->1797|3580->1812|3677->1881|3706->1882|3735->1883|3768->1888|3797->1889|3840->1904|3943->1979|3972->1980|4011->1991|4040->1992|4076->2001|4105->2002|4139->2009|4167->2010|4208->2024|4254->2042|4283->2043|4319->2052|4408->2113|4437->2114|4476->2125|4572->2193|4601->2194|4642->2207|4997->2534|5026->2535|5069->2550|5166->2619|5195->2620|5224->2621|5257->2626|5286->2627|5329->2642|5395->2680|5424->2681|5476->2705|5505->2706|5541->2715|5570->2716|5604->2723|5632->2724|5664->2729|5725->2760
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|37->7|46->16|46->16|47->17|53->23|53->23|55->25|55->25|55->25|56->26|57->27|57->27|58->28|64->34|64->34|65->35|65->35|67->37|67->37|67->37|68->38|69->39|69->39|70->40|71->41|71->41|72->42|79->49|79->49|80->50|81->51|81->51|81->51|81->51|81->51|82->52|84->54|84->54|85->55|85->55|86->56|86->56|87->57|87->57|89->59|89->59|89->59|90->60|91->61|91->61|92->62|93->63|93->63|94->64|99->69|99->69|100->70|101->71|101->71|101->71|101->71|101->71|102->72|103->73|103->73|105->75|105->75|106->76|106->76|107->77|107->77|108->78|113->83
                  -- GENERATED --
              */
          