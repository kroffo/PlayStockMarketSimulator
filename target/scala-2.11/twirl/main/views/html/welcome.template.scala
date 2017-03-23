
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object welcome_Scope0 {
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

class welcome extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, style: String = "java"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.43*/("""

"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

    """),format.raw/*5.5*/("""<link rel="stylesheet" media="screen" href="/@documentation/resources/style/main.css">

    <section id="top">
        <div class="wrapper">
            <h1><a href="https://playframework.com/documentation/"""),_display_(/*9.67*/version),format.raw/*9.74*/("""/Home">"""),_display_(/*9.82*/message),format.raw/*9.89*/("""</a></h1>
        </div>
    </section>

    <div id="content" class="wrapper doc">
        <article>

            <h1>Welcome to Play</h1>

            <p>
                Congratulations, you’ve just created a new Play application. This page will help you with the next few steps.
            </p>

            <blockquote>
                <p>
                    You’re using Play """),_display_(/*24.40*/version),format.raw/*24.47*/("""
                """),format.raw/*25.17*/("""</p>
            </blockquote>

            <h2>Why do you see this page?</h2>

            <p>
                The <code>conf/routes</code> file defines a route that tells Play to invoke the <code>HomeController.index</code> action
                whenever a browser requests the <code>/</code> URI using the GET method:
            </p>

            <pre><code># Home page
GET     /               controllers.HomeController.index</code></pre>


            <p>
                Play has invoked the <code>controllers.HomeController.index</code> method:
            </p>

            <pre><code>public static Result index() """),format.raw/*43.53*/("""{"""),format.raw/*43.54*/("""
    """),format.raw/*44.5*/("""return ok(index.render("Your new application is ready."));
"""),format.raw/*45.1*/("""}"""),format.raw/*45.2*/("""</code></pre>

            <p>
                An action method handles the incoming HTTP request, and returns the HTTP result to send back to the web client.
                Here we send a <code>200 OK</code> response, using a template to fill its content.
            </p>

            <p>
                The template is defined in the <code>app/views/index.scala.html</code> file and compiled as a standard Java class.
            </p>

            <pre><code>@(message: String)

  @main("Welcome to Play") """),format.raw/*58.29*/("""{"""),format.raw/*58.30*/("""

  """),format.raw/*60.3*/("""@play20.welcome(message, style = "Java")

"""),format.raw/*62.1*/("""}"""),format.raw/*62.2*/("""</code></pre>

            <p>
                The first line of the template defines the function signature. Here it just takes a single <code>String</code> parameter.
                Then this template calls another function defined in <code>app/views/main.scala.html</code> which displays the HTML layout, and another
                function that displays this welcome message. You can freely add any HTML fragment mixed with Scala code in this file.
            </p>

            <blockquote>
                <p>
                    <strong>Note</strong> that Scala is fully compatible with Java, so if you don’t know Scala don’t panic, a Scala statement is very similar to a Java one.
                </p>
            </blockquote>

            <p>You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*76.94*/version),format.raw/*76.101*/("""/ScalaTemplates">Twirl</a>, the template language used by Play, and how Play handles <a href="https://www.playframework.com/documentation/"""),_display_(/*76.240*/version),format.raw/*76.247*/("""/JavaActions">actions</a>.</p>

            <h2>Async Controller</h2>

            Now that you've seen how Play renders a page, take a look at <code>AsyncController.java</code>, which shows how to do asynchronous programming when handling a request.  The code is almost exactly the same as <code>HomeController.java</code>, but instead of returning <code>Result</code>, the action returns <code>CompletionStage&lt;Result&gt;</code> to Play.  When the execution completes, Play can use a thread to render the result without blocking the thread in the mean time.

            <p>
                <a href=""""),_display_(/*83.27*/routes/*83.33*/.AsyncController.message),format.raw/*83.57*/("""">Click here for the AsyncController action!</a>
            </p>

            <p>
                You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*87.95*/version),format.raw/*87.102*/("""/JavaAsync">asynchronous actions</a> in the documentation.
            </p>

            <h2>Count Controller</h2>

            <p>
                Both the HomeController and AsyncController are very simple, and typically controllers present the results of the interaction of several services.  As an example, see the <code>CountController</code>, which shows how to inject a component into a controller and use the component when handling requests.  The count controller increments every time you click on it, so keep clicking to see the numbers go up.
            </p>

            <p>
                <a href=""""),_display_(/*97.27*/routes/*97.33*/.CountController.count),format.raw/*97.55*/("""">Click here for the CountController action!</a>
            </p>

            <p>
                You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*101.95*/version),format.raw/*101.102*/("""/JavaDependencyInjection">dependency injection</a> in the documentation.
            </p>

            <h2>Need more info on the console?</h2>

            <p>
                For more information on the various commands you can run on Play, i.e. running tests and packaging applications for production, see <a href="https://playframework.com/documentation/"""),_display_(/*107.199*/version),format.raw/*107.206*/("""/PlayConsole">Using the Play console</a>.
            </p>

            <h2>Need to set up an IDE?</h2>

            <p>
                You can start hacking your application right now using any text editor. Any changes will be automatically reloaded at each page refresh,
                including modifications made to Scala source files.
            </p>

            <p>
                If you want to set-up your application in <strong>IntelliJ IDEA</strong> or any other Java IDE, check the
                <a href="https://www.playframework.com/documentation/"""),_display_(/*119.71*/version),format.raw/*119.78*/("""/IDE">Setting up your preferred IDE</a> page.
            </p>

            <h2>Need more documentation?</h2>

            <p>
                Play documentation is available at <a href="https://www.playframework.com/documentation/"""),_display_(/*125.106*/version),format.raw/*125.113*/("""">https://www.playframework.com/documentation</a>.
            </p>

            <p>
                Play comes with lots of example templates showcasing various bits of Play functionality at <a href="https://www.playframework.com/download#examples">https://www.playframework.com/download#examples</a>.
            </p>

            <h2>Need more help?</h2>

            <p>
                Play questions are asked and answered on Stackoverflow using the "playframework" tag: <a href="https://stackoverflow.com/questions/tagged/playframework">https://stackoverflow.com/questions/tagged/playframework</a>
            </p>

            <p>
                The <a href="http://groups.google.com/group/play-framework">Play Google Group</a> is where Play users come to seek help,
                announce projects, and discuss issues and new features. If you don’t have a Google account, you can still join the mailing
                list by sending an e-mail to
                <strong>play-framework+subscribe@googlegroups.com</strong>.
            </p>

            <p>
                Gitter is a real time chat channel, like IRC. The <a href="https://gitter.im/playframework/playframework">playframework/playframework</a>  channel is used by Play users to discuss the ins and outs of writing great Play applications.
            </p>

        </article>

        <aside>
            <h3>Browse</h3>
            <ul>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*154.71*/version),format.raw/*154.78*/("""">Documentation</a></li>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*155.71*/version),format.raw/*155.78*/("""/api/"""),_display_(/*155.84*/style),format.raw/*155.89*/("""/index.html">Browse the """),_display_(/*155.114*/{style.capitalize}),format.raw/*155.132*/(""" """),format.raw/*155.133*/("""API</a></li>
            </ul>
            <h3>Start here</h3>
            <ul>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*159.71*/version),format.raw/*159.78*/("""/PlayConsole">Using the Play console</a></li>
                <li><a href="https://playframework.com/documentation/"""),_display_(/*160.71*/version),format.raw/*160.78*/("""/IDE">Setting up your preferred IDE</a></li>
                <li><a href="https://playframework.com/download#examples">Example Projects</a>
            </ul>
            <h3>Help here</h3>
            <ul>
                <li><a href="https://stackoverflow.com/questions/tagged/playframework">Stack Overflow</a></li>
                <li><a href="http://groups.google.com/group/play-framework">Mailing List</a></li>
                <li><a href="https://gitter.im/playframework/playframework">Gitter Channel</a></li>
            </ul>

        </aside>

    </div>
""")))}))
      }
    }
  }

  def render(message:String,style:String): play.twirl.api.HtmlFormat.Appendable = apply(message,style)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,style) => apply(message,style)

  def ref: this.type = this

}


}

/**/
object welcome extends welcome_Scope0.welcome
              /*
                  -- GENERATED --
                  DATE: Tue Mar 21 16:36:02 EDT 2017
                  SOURCE: /Users/kennethroffo/Downloads/play-java/app/views/welcome.scala.html
                  HASH: c5d6302cf6e8bdd62fc2c0deea0427c5d7e43bb4
                  MATRIX: 756->1|892->42|920->45|967->84|1017->97|1049->103|1282->311|1309->318|1343->326|1370->333|1782->718|1810->725|1855->742|2507->1366|2536->1367|2568->1372|2654->1431|2682->1432|3221->1945|3250->1946|3281->1950|3350->1993|3378->1994|4237->2826|4266->2833|4433->2972|4462->2979|5094->3584|5109->3590|5154->3614|5358->3791|5387->3798|6029->4413|6044->4419|6087->4441|6292->4618|6322->4625|6709->4983|6739->4990|7335->5558|7364->5565|7625->5797|7655->5804|9171->7293|9200->7300|9323->7395|9352->7402|9386->7408|9413->7413|9467->7438|9508->7456|9539->7457|9717->7607|9746->7614|9890->7730|9919->7737
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|40->9|40->9|40->9|40->9|55->24|55->24|56->25|74->43|74->43|75->44|76->45|76->45|89->58|89->58|91->60|93->62|93->62|107->76|107->76|107->76|107->76|114->83|114->83|114->83|118->87|118->87|128->97|128->97|128->97|132->101|132->101|138->107|138->107|150->119|150->119|156->125|156->125|185->154|185->154|186->155|186->155|186->155|186->155|186->155|186->155|186->155|190->159|190->159|191->160|191->160
                  -- GENERATED --
              */
          