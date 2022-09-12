package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class WriteJson {

    public static void main(String[] args) throws IOException {
        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", 100);

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");
        obj.put("messages", list);

        try (FileWriter file = new FileWriter("json_dir/new_data.json")) {
            file.write(obj.toJSONString());
        }
    }
}
