package fi.rinkkasatiainen.demo.screenplay.tasks;

import fi.rinkkasatiainen.demo.screenplay.user_interface.ApplicationHomePage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.OpenPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenBrowser implements Task {
    private ApplicationHomePage applicationHomePage;
    private final String applicationHomePageUrl;

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the( applicationHomePage ),

                OpenAtPage.onThePage( applicationHomePage, "actor.profile.page", PageObject.withParameters( actor.getName() ))
        );
    }

    public static Task onPage(String page){
        return instrumented( OpenBrowser.class, page);
    }

    public OpenBrowser(String applicationHomePageUrl) {
        this.applicationHomePageUrl = applicationHomePageUrl;
    }

    private static class OpenAtPage extends Open {

        public static Interaction onThePage(ApplicationHomePage applicationHomePage, String page, final String[] parameters) {
            return Foo.stuff(applicationHomePage, page, parameters);
        }
    }

    private  static class Foo implements Interaction{

        private final ApplicationHomePage applicationHomePage;
        private final String page;
        private final String[] parameters;

        private Foo(ApplicationHomePage applicationHomePage, String page, String[] parameters) {
            this.applicationHomePage = applicationHomePage;
            this.page = page;
            this.parameters = parameters;
        }

        public <T extends Actor> void performAs(T theActor) {
            applicationHomePage.setDriver(BrowseTheWeb.as(theActor).getDriver());
            applicationHomePage.open(page, parameters);

        }

        public static Foo stuff(ApplicationHomePage applicationHomePage, String page, String[] parameters) {
            return new Foo( applicationHomePage, page, parameters);
        }
    }
}
