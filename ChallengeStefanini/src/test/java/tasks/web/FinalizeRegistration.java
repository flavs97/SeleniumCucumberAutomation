package tasks.web;

import elements.InterzoidElements;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class FinalizeRegistration implements Task, IsSilent {


    public static FinalizeRegistration click(){
        return instrumented(FinalizeRegistration.class);
    }
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(InterzoidElements.CHECKBOX_RECAPTCHA)
        );
        actor.attemptsTo(
                Click.on(InterzoidElements.CHECKBOX_TERMS)
        );
        actor.attemptsTo(
                Click.on(InterzoidElements.BTN_REGISTER)
        );
    }
}

