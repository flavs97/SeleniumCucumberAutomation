package tasks.api;

import com.google.gson.JsonArray;
import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static model.CastOfActors.actor;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetWeather implements Task, IsSilent {

    String paramcity;
    String paramstate;
    String paramlincense;
    String url = "https://www.interzoid.com/services/getweathercity";
    Logger LOGGER = LoggerFactory.getLogger(GetWeather.class);

    GetWeather(String city, String state, String key) {

        this.paramcity = city;
        this.paramstate = state;
        this.paramlincense = key;
    }
    public static GetWeather retrieve(String city, String state, String key){

        return instrumented(GetWeather.class, city, state, key);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(paramcity);
        System.out.println(paramlincense);
        System.out.println(paramstate);
      //  String getUrl = (url+"?license="+paramlincense+"&city="+paramcity+"&state="+paramstate);
        LOGGER.info("Searching for weather information");
        actor().attemptsTo(
                Get.resource(url).with(
                        request ->
                                request.given()
                                        .param("?license="+paramlincense)
                                        .param("&city="+paramcity)
                                        .param("&state="+paramstate)
                                .when()
                ));
        if(lastResponse().statusCode() == 200) {
            if(lastResponse().statusLine().equals("OK")) {
                LOGGER.info("Return is as expected");
                LOGGER.info(lastResponse().getBody().as(JsonArray.class).toString());
            }
            else {
                LOGGER.info("Return does not match expected");
            }
        }

        if(lastResponse().statusCode() == 404) {
            if(lastResponse().statusLine().equals("Not Found")) {
                LOGGER.info("Return is as expected");
                LOGGER.info(lastResponse().getBody().as(JsonArray.class).toString());
            }
            else {
                LOGGER.info("Return does not match expected");
            }
        }

        if(lastResponse().statusCode() == 400) {
            if(lastResponse().statusLine().equals("Bad Request")) {
                LOGGER.info("Return is as expected");
                LOGGER.info(lastResponse().getBody().as(JsonArray.class).toString());
            }
            else {
                LOGGER.info("Return does not match expected");
            }
        }
        else {
            LOGGER.info("Unexpected return");
            LOGGER.info(lastResponse().getBody().as(JsonArray.class).toString());
        }

    }

}
