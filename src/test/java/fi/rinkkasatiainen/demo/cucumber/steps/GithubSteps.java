package fi.rinkkasatiainen.demo.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fi.rinkkasatiainen.demo.screenplay.questions.TheRepositories;
import fi.rinkkasatiainen.demo.screenplay.tasks.ListRepositories;
import fi.rinkkasatiainen.demo.screenplay.tasks.OpenBrowser;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import org.openqa.selenium.firefox.FirefoxDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.hasItem;


public class GithubSteps {
    @Given("^that (.*) has created a repository '(.*)'$")
    public void thatAkiHasCreatedARepositoryCodefreezeFi(String actorName, String repositoryName) throws Throwable {
        Cast cast = new Cast();
        cast.actorNamed(actorName, BrowseTheWeb.with( new FirefoxDriver() ));
        setTheStage(cast);
        theActorCalled(actorName).wasAbleTo( OpenBrowser.onPage("github.com/" + actorName));
    }

    @When("^he lists all the repositories$")
    public void heListsAllTheRepositories() throws Throwable {
        theActorInTheSpotlight().attemptsTo( ListRepositories.belongingToThemselves() );
    }

    @Then("^(.*) repository is shown in the repository lists$")
    public void codefreezeFiRepositoryIsShownInTheRepositoryLists(String repositoryName) throws Throwable {
        theActorInTheSpotlight().should(seeThat( TheRepositories.displayed(), hasItem( repositoryName) ));
    }
}
