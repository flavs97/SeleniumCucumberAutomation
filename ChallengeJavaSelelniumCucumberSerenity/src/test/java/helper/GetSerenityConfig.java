package helper;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class GetSerenityConfig {

    public static String named(String name) {
        EnvironmentVariables variables = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        String env = EnvironmentSpecificConfiguration.from(variables).getOptionalProperty(name)
                .orElse(variables.getProperty(name));
        if(env==null) {
            if(System.getProperties().containsKey(name)) {
                env = System.getProperty(name);
            } else if(System.getenv().containsKey(name)){
                env = System.getenv(name);
            }
         } else {

        }
        return env;
    }


}
