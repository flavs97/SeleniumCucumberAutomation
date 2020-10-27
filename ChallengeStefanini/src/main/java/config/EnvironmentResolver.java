package config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import exceptions.NoSuchEnvironmentException;

import java.io.File;


public class EnvironmentResolver {

    private static Config env;
    private static String envType = "default";
    private static String envFileName = "env.conf";

    public static Config getEnv() {
        if(env==null){
            env = getSafeFileProp(envFileName);
            if(System.getProperties().containsKey("env")) {
                envType = System.getProperty("env");
            }
            env = env.withFallback(env.getConfig("environments."+envType)).withFallback(env.getConfig("environments.all"));
        }
        return env;
    }



    public static Config getConf(String path) {
        return getSafeFileProp(path);
    }

    public static String getNamedConfValue(String name, String path) throws NoSuchEnvironmentException {
        Config conf = getConf(path);
        String value = "";
        if(conf.hasPath(name)){
            value =  conf.getString(name);
        } else {
            throw new NoSuchEnvironmentException(name);
        }
        return value;
    }


    public static String getNamedEnvValue(String name) throws NoSuchEnvironmentException {
        getEnv();
        String value = "";
        if(env.hasPath(name)){
            value = env.resolve().getString(name);
        } else if(env.getConfig("environments").hasPath(name)){
            value = env.getConfig("environments").resolve().getString(name);
        } else if(env.getConfig("environments.all").hasPath(name)){
            value = env.getConfig("environments.all").resolve().getString(name);
        } else {
            throw new NoSuchEnvironmentException(name);
        }
        return value;
    }

    private static Config getSafeFileProp(String envFileName) {
        File configFile = new File(envFileName);
        Config preferences = null;
        if (configFile.exists()) {
            preferences = ConfigFactory.parseFile(configFile);
            return preferences;
        } else {
            preferences = ConfigFactory.load(configFile.getName());
            return preferences;
        }
    }

}
