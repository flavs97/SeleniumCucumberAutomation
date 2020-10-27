package tasks.web;

import elements.InterzoidElements;
import models.User;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillMandatoryData implements Task, IsSilent {
    User user;

    FillMandatoryData(User user) {
        this.user = user;
        this.user.limparEmail();
        this.user.getEmail();
    }

    public static FillMandatoryData fill(User user) {

        return instrumented(FillMandatoryData.class, user);
    }

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(user.name).into(InterzoidElements.INPUT_FIRST_NAME),
                Enter.theValue(user.lastename).into(InterzoidElements.INPUT_LAST_NAME),
                Enter.theValue(user.getEmail()).into(InterzoidElements.INPUT_EMAIL),
                Enter.theValue(user.email).into(InterzoidElements.INPUT_CONFIR_EMAIL),
                Enter.theValue(user.password).into(InterzoidElements.INPUT_PASSWORD),
                Enter.theValue(user.password).into(InterzoidElements.INPUT_CONFIR_PASSWORD)
        );
    }

}
