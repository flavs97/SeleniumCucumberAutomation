package model;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class DataMassParser {

    public static <T> T getObjectWithName(String name,Class<T> classType) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String userJson = new JsonParser().parse(new FileReader(new File("./src/test/resources/datamass/"+classType.getSimpleName()+".json"))).getAsJsonObject().get(name).toString();
            return (T) mapper.readValue(userJson,classType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (T) classType;
    }

    public static <T> T saveObjectWithName(String name, T obj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonParser parser = new JsonParser();
            JsonObject userJson = parser.parse(new FileReader(new File("./src/test/resources/datamass/"+obj.getClass().getSimpleName()+".json"))).getAsJsonObject();
            JsonObject objJson = parser.parse(mapper.writeValueAsString(obj)).getAsJsonObject();
            userJson.remove(name);
            userJson.add(name,objJson);
            try(Writer writer = new FileWriter("./src/test/resources/datamass/"+obj.getClass().getSimpleName()+".json")){
                new GsonBuilder().setPrettyPrinting().create().toJson(userJson,writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }




}
