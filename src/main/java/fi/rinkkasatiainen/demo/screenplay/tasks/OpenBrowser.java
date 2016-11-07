package fi.rinkkasatiainen.demo.screenplay.tasks;

import fi.rinkkasatiainen.demo.screenplay.user_interface.ApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenBrowser implements Task {
    private ApplicationHomePage applicationHomePage;
    private final String applicationHomePageUrl;

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the( applicationHomePage )
        );
    }

    public static Task onPage(String page){
        return instrumented( OpenBrowser.class, page);
    }

    public OpenBrowser(String applicationHomePageUrl) {
        this.applicationHomePageUrl = applicationHomePageUrl;
    }
}
