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

    public boolean checkExistStory(int ipId, String ipname, String ipcategory,String ipauthor ) throws IOException, ParseException {
        for (int i = 0; i <storyList.size() ; i++) {
            int id = storyList.get(i).getId();
            String name = storyList.get(i).getName();
            String category = storyList.get(i).getCategory();
            String author= storyList.get(i).getAuthor();
            if(id == ipId ||(name.equals(ipname) && category.equals(ipcategory) && author.equals(ipauthor))){
                return true;
            }
        }
        return false;
    }

    public void addStory() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin truyen: ");
        System.out.print("id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("category: ");
        String category = scanner.nextLine();
        System.out.print("path: ");
        String path = scanner.nextLine();
        System.out.print("author: ");
        String author = scanner.nextLine();
        if (checkExistStory(id,name,category,author)) {
            System.out.println("Truyen da ton tai");
        }else {
            Story newStory = new Story(id, name, category, path, author);
            storyList.add(newStory);
            String jsonUser = JacksonParser.INSTANCE.toJson(storyList);
            Write.writeJsonFile(jsonUser, "data/storydata.json");
        }

    }

}