package runner;

import com.google.gson.JsonParser;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Set;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        tags = {"not @skip", "not @api", "@teste1"},
        plugin = {"pretty"},
        monochrome = true)

public class RunnerTest {

}
