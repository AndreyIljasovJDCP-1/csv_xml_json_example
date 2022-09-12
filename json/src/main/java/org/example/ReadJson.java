package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static void main(String[] args) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader("fg/data.json"));
        } catch (IOException e) {
            System.out.println("Не найден файл.");
        }
        System.out.println("какая-то бизнес - логика");
    }
}