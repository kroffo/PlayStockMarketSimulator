
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

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Welcome to Play")/*1.25*/ {_display_(Seq[Any](format.raw/*1.27*/("""

"""),format.raw/*3.1*/("""<html>
  <head><title>Company Query Page</title></head>
  <body>
    <button OnClick="list()">List</button>
    <button OnClick="query()">Query</button>
    <button OnClick="login()">Log in</button>
    <button OnClick="signup()">Sign Up</button>
    <div id="responseField"></div>
    <script>	
      function list() """),format.raw/*12.23*/("""{"""),format.raw/*12.24*/("""
        """),format.raw/*13.9*/("""var xmlHttp = new XMLHttpRequest();
        var url = location.origin + "/StockMarketSimulator/companies?list=true";
        xmlHttp.open( "GET", url, false ); // false for synchronous request
        xmlHttp.send( null );
        var res = xmlHttp.responseText;
        document.getElementById("responseField").innerHTML = res;
      """),format.raw/*19.7*/("""}"""),format.raw/*19.8*/("""
      
      """),format.raw/*21.7*/("""function query() """),format.raw/*21.24*/("""{"""),format.raw/*21.25*/("""
        """),format.raw/*22.9*/("""var name = prompt("Enter the name of the company you wish to learn about:");
        if(name != null) """),format.raw/*23.26*/("""{"""),format.raw/*23.27*/("""
          """),format.raw/*24.11*/("""var xmlHttp = new XMLHttpRequest();
          var url = location.origin + "/StockMarketSimulator/companies?name=" + name;
          xmlHttp.open( "GET", url, false ); // false for synchronous request
          xmlHttp.send( null );
          var res = xmlHttp.responseText;
          document.getElementById("responseField").innerHTML = res;
        """),format.raw/*30.9*/("""}"""),format.raw/*30.10*/("""
      """),format.raw/*31.7*/("""}"""),format.raw/*31.8*/("""
      
      """),format.raw/*33.7*/("""function login() """),format.raw/*33.24*/("""{"""),format.raw/*33.25*/("""
        """),format.raw/*34.9*/("""var name = prompt("Enter a name:");
        if(name != null) """),format.raw/*35.26*/("""{"""),format.raw/*35.27*/("""
          """),format.raw/*36.11*/("""var pass = prompt("Enter a password");
          if(pass != null) """),format.raw/*37.28*/("""{"""),format.raw/*37.29*/("""
            """),format.raw/*38.13*/("""var url = location.origin + "/StockMarketSimulator/login?name=" + name + "&pass=" + pass;
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open( "GET", url, false ); // false for synchronous request
            xmlHttp.send( null );
            var response = xmlHttp.responseText;
            console.log(response);
            var json = JSON.parse(response);
            if(json.login_status) """),format.raw/*45.35*/("""{"""),format.raw/*45.36*/("""
              """),format.raw/*46.15*/("""window.location.replace(location.origin + "/StockMarketSimulator/dashboard");
            """),format.raw/*47.13*/("""}"""),format.raw/*47.14*/(""" """),format.raw/*47.15*/("""else """),format.raw/*47.20*/("""{"""),format.raw/*47.21*/("""
              """),format.raw/*48.15*/("""console.log(json.error);
              alert("Login failed.");
            """),format.raw/*50.13*/("""}"""),format.raw/*50.14*/("""
          """),format.raw/*51.11*/("""}"""),format.raw/*51.12*/("""
        """),format.raw/*52.9*/("""}"""),format.raw/*52.10*/("""
      """),format.raw/*53.7*/("""}"""),format.raw/*53.8*/("""
      
      """),format.raw/*55.7*/("""function signup() """),format.raw/*55.25*/("""{"""),format.raw/*55.26*/("""
        """),format.raw/*56.9*/("""var name = prompt("Enter a name:");
        if(name != null) """),format.raw/*57.26*/("""{"""),format.raw/*57.27*/("""
          """),format.raw/*58.11*/("""var pass = prompt("Enter a password");
            if(pass != null) """),format.raw/*59.30*/("""{"""),format.raw/*59.31*/("""
            """),format.raw/*60.13*/("""var url = location.origin + "/StockMarketSimulator/signup?name=" + name + "&pass=" + pass;
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open( "GET", url, false ); // false for synchronous request
            xmlHttp.send( null );
            var status = JSON.parse(xmlHttp.responseText).login_status;
            if(status) """),format.raw/*65.24*/("""{"""),format.raw/*65.25*/("""
              """),format.raw/*66.15*/("""window.location.replace(location.origin + "/StockMarketSimulator/dashboard");
            """),format.raw/*67.13*/("""}"""),format.raw/*67.14*/(""" """),format.raw/*67.15*/("""else """),format.raw/*67.20*/("""{"""),format.raw/*67.21*/("""
              """),format.raw/*68.15*/("""alert("Username taken.");
            """),format.raw/*69.13*/("""}"""),format.raw/*69.14*/("""
            
          """),format.raw/*71.11*/("""}"""),format.raw/*71.12*/("""
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/("""
      """),format.raw/*73.7*/("""}"""),format.raw/*73.8*/("""
    """),format.raw/*74.5*/("""</script>
  </body>
</html>


""")))}),format.raw/*79.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object login extends login_Scope0.login
              /*
                  -- GENERATED --
                  DATE: Wed Mar 22 19:35:17 EDT 2017
                  SOURCE: /Users/kennethroffo/Documents/PlayStockMarketSimulator/app/views/login.scala.html
                  HASH: cf4ee952b2edacbc03557eb65dbf93e4417ef4b0
                  MATRIX: 827->1|858->24|897->26|925->28|1271->346|1300->347|1336->356|1698->691|1726->692|1767->706|1812->723|1841->724|1877->733|2007->835|2036->836|2075->847|2452->1197|2481->1198|2515->1205|2543->1206|2584->1220|2629->1237|2658->1238|2694->1247|2783->1308|2812->1309|2851->1320|2945->1386|2974->1387|3015->1400|3458->1815|3487->1816|3530->1831|3648->1921|3677->1922|3706->1923|3739->1928|3768->1929|3811->1944|3914->2019|3943->2020|3982->2031|4011->2032|4047->2041|4076->2042|4110->2049|4138->2050|4179->2064|4225->2082|4254->2083|4290->2092|4379->2153|4408->2154|4447->2165|4543->2233|4572->2234|4613->2247|4989->2595|5018->2596|5061->2611|5179->2701|5208->2702|5237->2703|5270->2708|5299->2709|5342->2724|5408->2762|5437->2763|5489->2787|5518->2788|5554->2797|5583->2798|5617->2805|5645->2806|5677->2811|5738->2842
                  LINES: 32->1|32->1|32->1|34->3|43->12|43->12|44->13|50->19|50->19|52->21|52->21|52->21|53->22|54->23|54->23|55->24|61->30|61->30|62->31|62->31|64->33|64->33|64->33|65->34|66->35|66->35|67->36|68->37|68->37|69->38|76->45|76->45|77->46|78->47|78->47|78->47|78->47|78->47|79->48|81->50|81->50|82->51|82->51|83->52|83->52|84->53|84->53|86->55|86->55|86->55|87->56|88->57|88->57|89->58|90->59|90->59|91->60|96->65|96->65|97->66|98->67|98->67|98->67|98->67|98->67|99->68|100->69|100->69|102->71|102->71|103->72|103->72|104->73|104->73|105->74|110->79
                  -- GENERATED --
              */
          