package services;

import model.Story;
import model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public class Read {
    public static void readJsonUser(List<User> list, String pathFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(pathFile));
        JSONArray array = (JSONArray) obj;
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = (JSONObject) array.get(i);
            long id = (long) jsonObject.get("id");
            String fullName = (String) jsonObject.get("fullName");
            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");
            String email = (String) jsonObject.get("email");
            User newUser = new User((int) id, fullName, username,  password, email);
            list.add(newUser);
        }
    }
    public static void readJsonStory(List<Story> list, String pathFile) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(pathFile));
        JSONArray array = (JSONArray) obj;
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = (JSONObject) array.get(i);
            long id = (long) jsonObject.get("id");
            String name = (String) jsonObject.get("name");
            String category = (String) jsonObject.get("category");
            String path = (String) jsonObject.get("path");
            String author = (String) jsonObject.get("author");
            Story newStory = new Story((int) id, name, category, path, author);
            list.add(newStory);
        }
    }
}