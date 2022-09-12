package org.example.test.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Person> people = mapper.readValue(new File("json_dir/test.json"), new TypeReference<List<Person>>() {
        });

        people.forEach(System.out::println);

    }
}
