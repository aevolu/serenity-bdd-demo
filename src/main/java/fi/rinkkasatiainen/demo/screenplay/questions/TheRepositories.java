package fi.rinkkasatiainen.demo.screenplay.questions;

import fi.rinkkasatiainen.demo.screenplay.user_interface.RepositoryList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TheRepositories {

    public static Question<List<String>> displayed() {
        return new DisplayedItems();
    }

    private static class DisplayedItems implements Question<List<String>>{

        public List<String> answeredBy(Actor actor) {
            return Text.of(RepositoryList.ITEMS ).viewedBy( theActorInTheSpotlight() ).asList();
        }
    }
}
