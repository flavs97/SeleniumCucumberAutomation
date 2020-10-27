package tasks.web;

import elements.InterzoidElements;
import models.User;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillOptionalData implements Task, IsSilent {
    User user;

    FillOptionalData(User user) {
        this.user = user;
    }

    public static FillOptionalData fill(User user) {

        return instrumented(FillOptionalData.class, user);
    }

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(user.title).into(InterzoidElements.INPUT_TITLE),
                Enter.theValue(user.company).into(InterzoidElements.INPUT_COMPANY),
                Enter.theValue(user.phone).into(InterzoidElements.INPUT_PHONE),
                Enter.theValue(user.address1).into(InterzoidElements.INPUT_ADDRESS1),
                Enter.theValue(user.address2).into(InterzoidElements.INPUT_ADDRESS2),
                Enter.theValue(user.city).into(InterzoidElements.INPUT_CITY),
                Enter.theValue(user.state).into(InterzoidElements.INPUT_STATE),
                Enter.theValue(user.postal).into(InterzoidElements.INPUT_POSTAL),
                Enter.theValue(user.country).into(InterzoidElements.INPUT_COUNTRY),
                Enter.theValue(user.referral).into(InterzoidElements.INPUT_REFERRAL),
                Enter.theValue(user.question).into(InterzoidElements.INPUT_QUESTION)
        );
    }
}
