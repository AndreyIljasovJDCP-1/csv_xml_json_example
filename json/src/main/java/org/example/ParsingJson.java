package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ParsingJson {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("json_dir/data.json"));
        JSONObject jsonObject = (JSONObject) obj;

        JSONObject adress = (JSONObject) jsonObject.get("address");
        String city = (String) adress.get("streetAddress");
        System.out.println(city);

        JSONArray phoneNumbers = (JSONArray) jsonObject.get("phoneNumbers");
        phoneNumbers
                .forEach(System.out::println);



    }
}
