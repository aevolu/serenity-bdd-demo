package fi.rinkkasatiainen.demo.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.ClickOnBy;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ListRepositories implements Task {

    public <T extends Actor> void performAs(T theActor) {
            theActor.attemptsTo(
                    new ClickOnBy( By.xpath( "//a[@href='/rinkkasatiainen?tab=repositories']"))
            );
    }

    public static <T extends Performable> ListRepositories belongingToThemselves() {
        return instrumented(ListRepositories.class );
    }

    public ListRepositories() {
    }
}
