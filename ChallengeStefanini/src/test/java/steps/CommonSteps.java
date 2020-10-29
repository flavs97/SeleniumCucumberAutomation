package steps;

import cucumber.api.java8.En;
import net.serenitybdd.screenplay.actions.Open;
import tasks.api.GetWeather;
import tasks.web.DemoCartAction;
import utils.WebDriverFactory;

import static model.CastOfActors.actor;


public class CommonSteps implements En {

   static String product;
   static String license;
    public CommonSteps() {

        Given("open url - Demo Store", () -> {
            WebDriverFactory.getDriver().get("http://demo.cs-cart.com");
        });

        And("search for product {string}", (String search) -> {
            CommonSteps.product = search;
            DemoCartAction.homePage();
            DemoCartAction.inputSearch(product);

        });

        And("click on product", () -> {
            DemoCartAction.clickResultSearch(product);
        });

        And("add to cart", () -> {
            DemoCartAction.clickAddCart();
        });

        And("go to cart", () -> {
            DemoCartAction.clickCart();
        });

        And("Valid product and price", () -> {
            DemoCartAction.validatProduct(product);
        });

        And("proceed to checkout", () -> {
            DemoCartAction.clickProceedCheckout();
        });

        And("fill in additional information", () -> {
            DemoCartAction.inputInformtion();
        });

        And("select and fill payment methods", () -> {
            DemoCartAction.selectPaymentMethods();
        });

        And("accept the terms and click on the captcha", () -> {
            DemoCartAction.checkTermsCaptcha();
        });

        And("Finalize order", () -> {
            DemoCartAction.clickPlaceOrder();
        });

        And("Valid if purchase completed successfully", () -> {
            DemoCartAction.validateOrder();
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
