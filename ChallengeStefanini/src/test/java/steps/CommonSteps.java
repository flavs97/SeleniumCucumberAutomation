package steps;

import cucumber.api.java8.En;
import model.DataMassParser;
import models.User;
import net.serenitybdd.screenplay.actions.Open;
import tasks.api.GetWeather;
import tasks.web.FillMandatoryData;
import tasks.web.FillOptionalData;
import tasks.web.FinalizeRegistration;
import static model.CastOfActors.actor;


public class CommonSteps implements En {

   static User user;
   static String license;
    public CommonSteps() {

        Given("open url - Interzoid", () -> {
            actor().attemptsTo(
                    Open.browserOn().thePageNamed("interzoid.url")
            );
        });

        And("have the License Key - {string}", (String key) -> {
            CommonSteps.license = key;

                });


        And("get weather with {string} {string}", (String city, String state) -> {
            actor().attemptsTo(
                    GetWeather.retrieve(city, state, license)
            );
        });

        And("fill in the required data", () -> {
            CommonSteps.user = User.withName("User");
            actor().attemptsTo(
                    FillMandatoryData.fill(CommonSteps.user)
            );
            DataMassParser.saveObjectWithName("User", CommonSteps.user);
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
