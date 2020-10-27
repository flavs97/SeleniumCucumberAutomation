package tasks.web;

import elements.InterzoidElements;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickRegister implements Task, IsSilent {



    public static ClickRegister click(){
        return instrumented(ClickRegister.class);
    }
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the((InterzoidElements.ASSERT_HOME), isVisible()).forNoMoreThan(60).seconds(),
                Click.on(InterzoidElements.BTN_REGISTER_HOME)
        );

    }
}
