package steps;

import cucumber.api.java8.En;
import model.DataMassParser;
import models.User;
import net.serenitybdd.screenplay.actions.Open;
import tasks.web.ClickRegister;
import tasks.web.FillMandatoryData;
import tasks.web.FillOptionalData;
import tasks.web.FinalizeRegistration;
import static model.CastOfActors.actor;


public class CommonSteps implements En {

    static User user;

    public CommonSteps() {

        Given("open url - Interzoid", () -> {
            actor().attemptsTo(
                    Open.browserOn().thePageNamed("interzoid.url")
            );
        });

        And("click register", () -> {
            actor().attemptsTo(
                    ClickRegister.click()
            );
        });

        And("fill in the required data with {string}", (String name) -> {
            CommonSteps.user = User.withName(name);
            actor().attemptsTo(
                    FillMandatoryData.fill(CommonSteps.user)
            );
            DataMassParser.saveObjectWithName(name, CommonSteps.user);
        });
        And("fill in the optional data", () -> {
            actor().attemptsTo(
                    FillOptionalData.fill(CommonSteps.user)
            );
        });

        And("finish registration", () -> {
            actor().attemptsTo(
                    FinalizeRegistration.click()
            );
        });

    }
}
