package repository;

import model.Story;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.json.simple.parser.ParseException;
import services.JacksonParser;
import services.Read;
import services.Write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoryRepository {

    public static List<Story> storyList = new ArrayList<>();

    public static void importStoryToList() throws IOException, ParseException {
        Read.readJsonStory(storyList, "data/storydata.json");
    }

//   public void checkExistUser() throws IOException, ParseException {
//     StoryRepository.importStoryToList();
//       for (int i = 0; i < storyList.size(); i++) {
//
//       }
//   }
    public void addStory() throws IOException, ParseException {
        StoryRepository.importStoryToList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin truyen: ");
        System.out.print("id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("categery: ");
        String categery = scanner.nextLine();
        System.out.print("path: ");
        String path = scanner.nextLine();
        System.out.print("author: ");
        String author = scanner.nextLine();
        Story newStory = new Story(id, name, categery, path, author);
        storyList.add(newStory);
        String jsonUser = JacksonParser.INSTANCE.toJson(storyList);
        Write.writeJsonFile(jsonUser, "data/storydata.json");
    }

}
