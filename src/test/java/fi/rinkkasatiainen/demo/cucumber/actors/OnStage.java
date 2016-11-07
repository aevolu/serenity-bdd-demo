package fi.rinkkasatiainen.demo.cucumber.actors;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Stage;

import java.util.function.Supplier;


public class OnStage implements Supplier<Stage> {

    private static final ThreadLocal<Stage> stage = ThreadLocal.withInitial( new OnStage());

    public static Actor theActorCalled(String actorName){
        return theStage().shineSpotlightOn( actorName);
    }

    private static Stage theStage() {
        return stage.get();
    }


    @Override
    public Stage get() {
        return null;
    }
}
