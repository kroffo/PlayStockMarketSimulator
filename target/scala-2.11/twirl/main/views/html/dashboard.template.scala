
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object dashboard_Scope0 {
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

class dashboard extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/main("Welcome to Play")/*3.25*/ {_display_(Seq[Any](format.raw/*3.27*/("""

"""),format.raw/*5.1*/("""<html>
  <head><title>Company Query Page</title></head>
  <body>
    <button OnClick="list()">List</button>
    <button OnClick="query()">Query</button>
    <button OnClick="login()">Log in</button>
    <button OnClick="signup()">Sign Up</button>
    <div id="responseField"></div>
    <script>	
      function list() """),format.raw/*14.23*/("""{"""),format.raw/*14.24*/("""
        """),format.raw/*15.9*/("""var xmlHttp = new XMLHttpRequest();
        var url = location.origin + "/StockMarketSimulator/companies?list=true";
        xmlHttp.open( "GET", url, false ); // false for synchronous request
        xmlHttp.send( null );
        var res = xmlHttp.responseText;
        document.getElementById("responseField").innerHTML = res;
      """),format.raw/*21.7*/("""}"""),format.raw/*21.8*/("""
      
      """),format.raw/*23.7*/("""function query() """),format.raw/*23.24*/("""{"""),format.raw/*23.25*/("""
        """),format.raw/*24.9*/("""var name = prompt("Enter the name of the company you wish to learn about:");
        if(name != null) """),format.raw/*25.26*/("""{"""),format.raw/*25.27*/("""
          """),format.raw/*26.11*/("""var xmlHttp = new XMLHttpRequest();
          var url = location.origin + "/StockMarketSimulator/companies?name=" + name;
          xmlHttp.open( "GET", url, false ); // false for synchronous request
          xmlHttp.send( null );
          var res = xmlHttp.responseText;
          document.getElementById("responseField").innerHTML = res;
        """),format.raw/*32.9*/("""}"""),format.raw/*32.10*/("""
      """),format.raw/*33.7*/("""}"""),format.raw/*33.8*/("""
      
      """),format.raw/*35.7*/("""function login() """),format.raw/*35.24*/("""{"""),format.raw/*35.25*/("""
        """),format.raw/*36.9*/("""var name = prompt("Enter a name:");
        if(name != null) """),format.raw/*37.26*/("""{"""),format.raw/*37.27*/("""
          """),format.raw/*38.11*/("""var pass = prompt("Enter a password");
          if(pass != null) """),format.raw/*39.28*/("""{"""),format.raw/*39.29*/("""
            """),format.raw/*40.13*/("""var url = location.origin + "/StockMarketSimulator/login?name=" + name + "&pass=" + pass;
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open( "GET", url, false ); // false for synchronous request
            xmlHttp.send( null );
            var response = xmlHttp.responseText;
            console.log(response);
            var json = JSON.parse(response);
            if(json.login_status) """),format.raw/*47.35*/("""{"""),format.raw/*47.36*/("""
              """),format.raw/*48.15*/("""window.location.replace(location.origin + "/StockMarketSimulator/dashboard");
            """),format.raw/*49.13*/("""}"""),format.raw/*49.14*/(""" """),format.raw/*49.15*/("""else """),format.raw/*49.20*/("""{"""),format.raw/*49.21*/("""
              """),format.raw/*50.15*/("""console.log(json.error);
              alert("Login failed.");
            """),format.raw/*52.13*/("""}"""),format.raw/*52.14*/("""
          """),format.raw/*53.11*/("""}"""),format.raw/*53.12*/("""
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/("""
      """),format.raw/*55.7*/("""}"""),format.raw/*55.8*/("""
      
      """),format.raw/*57.7*/("""function signup() """),format.raw/*57.25*/("""{"""),format.raw/*57.26*/("""
        """),format.raw/*58.9*/("""var name = prompt("Enter a name:");
        if(name != null) """),format.raw/*59.26*/("""{"""),format.raw/*59.27*/("""
          """),format.raw/*60.11*/("""var pass = prompt("Enter a password");
            if(pass != null) """),format.raw/*61.30*/("""{"""),format.raw/*61.31*/("""
            """),format.raw/*62.13*/("""var url = location.origin + "/StockMarketSimulator/signup?name=" + name + "&pass=" + pass;
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open( "GET", url, false ); // false for synchronous request
            xmlHttp.send( null );
            var status = JSON.parse(xmlHttp.responseText).login_status;
            if(status) """),format.raw/*67.24*/("""{"""),format.raw/*67.25*/("""
              """),format.raw/*68.15*/("""window.location.replace(location.origin + "/StockMarketSimulator/dashboard");
            """),format.raw/*69.13*/("""}"""),format.raw/*69.14*/(""" """),format.raw/*69.15*/("""else """),format.raw/*69.20*/("""{"""),format.raw/*69.21*/("""
              """),format.raw/*70.15*/("""alert("Username taken.");
            """),format.raw/*71.13*/("""}"""),format.raw/*71.14*/("""
            
          """),format.raw/*73.11*/("""}"""),format.raw/*73.12*/("""
        """),format.raw/*74.9*/("""}"""),format.raw/*74.10*/("""
      """),format.raw/*75.7*/("""}"""),format.raw/*75.8*/("""
    """),format.raw/*76.5*/("""</script>
  </body>
</html>


""")))}),format.raw/*81.2*/("""
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
object dashboard extends dashboard_Scope0.dashboard
              /*
                  -- GENERATED --
                  DATE: Thu Mar 23 11:46:03 EDT 2017
                  SOURCE: /Users/stephendicerce/csc435/PlayStockMarketSimulator/app/views/dashboard.scala.html
                  HASH: 363274e2dd0ba060febb15219c0106db2bf70299
                  MATRIX: 835->3|866->26|905->28|933->30|1279->348|1308->349|1344->358|1706->693|1734->694|1775->708|1820->725|1849->726|1885->735|2015->837|2044->838|2083->849|2460->1199|2489->1200|2523->1207|2551->1208|2592->1222|2637->1239|2666->1240|2702->1249|2791->1310|2820->1311|2859->1322|2953->1388|2982->1389|3023->1402|3466->1817|3495->1818|3538->1833|3656->1923|3685->1924|3714->1925|3747->1930|3776->1931|3819->1946|3922->2021|3951->2022|3990->2033|4019->2034|4055->2043|4084->2044|4118->2051|4146->2052|4187->2066|4233->2084|4262->2085|4298->2094|4387->2155|4416->2156|4455->2167|4551->2235|4580->2236|4621->2249|4997->2597|5026->2598|5069->2613|5187->2703|5216->2704|5245->2705|5278->2710|5307->2711|5350->2726|5416->2764|5445->2765|5497->2789|5526->2790|5562->2799|5591->2800|5625->2807|5653->2808|5685->2813|5746->2844
                  LINES: 32->3|32->3|32->3|34->5|43->14|43->14|44->15|50->21|50->21|52->23|52->23|52->23|53->24|54->25|54->25|55->26|61->32|61->32|62->33|62->33|64->35|64->35|64->35|65->36|66->37|66->37|67->38|68->39|68->39|69->40|76->47|76->47|77->48|78->49|78->49|78->49|78->49|78->49|79->50|81->52|81->52|82->53|82->53|83->54|83->54|84->55|84->55|86->57|86->57|86->57|87->58|88->59|88->59|89->60|90->61|90->61|91->62|96->67|96->67|97->68|98->69|98->69|98->69|98->69|98->69|99->70|100->71|100->71|102->73|102->73|103->74|103->74|104->75|104->75|105->76|110->81
                  -- GENERATED --
              */
          