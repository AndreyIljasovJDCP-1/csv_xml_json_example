package org.example.objmapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleObjectMapper {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();

        map.put("name", "Макс");
        map.put("age", "26");
        map.put("addressBook", List.of("123123", "567566"));
        String s = mapper.writeValueAsString(map);

        try (FileWriter writer = new FileWriter("json_dir/example.json")) {
            writer.write(s);
        }

        writeUser();

        User user = readUser();

        System.out.println(user);
    }


    static void writeUser() throws IOException {
        User john = new User(
                1, "John", List.of("9898", "87646")
        );

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("json_dir/example2.json"), john);
    }

    static User readUser() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(new File("json_dir/example2.json"), User.class);

        return user;
    }
}


class User {
    private int id;
    private String name;
    private List<String> addressBook;

    public User() {
    }

    public User(int id, String name, List<String> addressBook) {
        this.id = id;
        this.name = name;
        this.addressBook = addressBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<String> addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressBook=" + addressBook +
                '}';
    }
}
