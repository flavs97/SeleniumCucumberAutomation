package model;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class CastOfActors {


    public static Actor actor;

    public static Actor actor() {
        if(actor==null) {
            actor = OnStage.setTheStage(new OnlineCast()).shineSpotlightOn("Automacao");
            actor.can(CallAnApi.at(""));
        }
        return actor;
    }


}
