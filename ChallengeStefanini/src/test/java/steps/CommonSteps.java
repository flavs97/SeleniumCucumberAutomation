package steps;

import cucumber.api.java8.En;
import net.serenitybdd.screenplay.actions.Open;
import tasks.api.GetWeather;

import static model.CastOfActors.actor;


public class CommonSteps implements En {


   static String license;
    public CommonSteps() {

        Given("open url - Demo Store", () -> {
            actor().attemptsTo(
                    Open.browserOn().thePageNamed("interzoid.url")
            );
        });

        And("search for product {string}", (String product) -> {

        });

        And("click on product", () -> {

        });

        And("add to cart", () -> {

        });

        And("go to cart", () -> {

        });

        And("Valid product and price", () -> {

        });

        And("proceed to checkout", () -> {

        });

        And("fill in additional information", () -> {

        });

        And("select and fill payment methods", () -> {

        });

        And("accept the terms and click on the captcha", () -> {

        });

        And("Finalize order", () -> {

        });

        And("Valid if purchase completed successfully", () -> {

        });


        And("have the License Key - {string}", (String key) -> {
            CommonSteps.license = key;

                });


        And("get weather with {string} {string}", (String city, String state) -> {
            actor().attemptsTo(
                    GetWeather.retrieve(city, state, license)
            );
        });

    }
}
