package tasks.web;

import elements.GloboIdElements;
import helper.TimeWaits;
import models.Usuario;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static model.CastOfActors.actor;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class VerOfertas implements Task, IsSilent {


    Usuario usuario;
    String opcoes;
    Logger LOGGER = LoggerFactory.getLogger(MinhaConta.class);
    private PageObject DriverNew;

    VerOfertas(String select) {

        this.opcoes = select;
    }

    public static VerOfertas preencher(String select) {

        return instrumented(VerOfertas.class, select);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (opcoes) {
            case "Crossdown":
                TimeWaits.espera(3);
                actor().attemptsTo(
                        WaitUntil.the((GloboIdElements.BTN_ASSINAR_PLANO_RETENCAO_CROSSDOWN), isClickable()).forNoMoreThan(60).seconds(),
                        Click.on(GloboIdElements.BTN_ASSINAR_PLANO_RETENCAO_CROSSDOWN)
                );

                break;

            case "Downgrade":
                TimeWaits.espera(3);
                actor().attemptsTo(
                        WaitUntil.the((GloboIdElements.BTN_ASSINAR_PLANO_RETENCAO_DOWNGRADE), isClickable()).forNoMoreThan(60).seconds(),
                        Click.on(GloboIdElements.BTN_ASSINAR_PLANO_RETENCAO_DOWNGRADE)
                );

                break;

            case "Downgrade basico":
                TimeWaits.espera(3);
                actor().attemptsTo(
                        WaitUntil.the((GloboIdElements.BTN_ASSINAR_PLANO_RETENCAO_CROSSDOWN_BASICO), isClickable()).forNoMoreThan(60).seconds(),
                        Click.on(GloboIdElements.BTN_ASSINAR_PLANO_RETENCAO_CROSSDOWN_BASICO)
                );

                break;

            case "Crossgrade":
                TimeWaits.espera(3);
                actor().attemptsTo(
                        WaitUntil.the((GloboIdElements.BTN_ASSINAR_PLANO_CROSSGRADE), isClickable()).forNoMoreThan(60).seconds(),
                        Click.on(GloboIdElements.BTN_ASSINAR_PLANO_CROSSGRADE)
                );

                break;
        }
    }
}
