package view;

import model.Story;
import org.json.simple.parser.ParseException;
import repository.StoryRepository;
import repository.UserRepository;
import services.Read;

import java.io.IOException;
import java.util.List;

public class ListStoryView {
    public static void view() throws IOException, ParseException {
        StoryRepository.importStoryToList();
        List<Story> storyList = StoryRepository.storyList;
        System.out.println("\t\t\t\t\t\t-----------------------------------DANH SACH TRUYEN------------------------------");
        System.out.printf("\t\t\t\t\t\t %-5s %-35s %-30s %-20s\n", "ID", "Name Story","Category", "Author");
        for (int i = 0; i < storyList.size(); i++) {
            int id = storyList.get(i).getId();
            String nameStory = storyList.get(i).getName();
            String category = storyList.get(i).getCategory();
            String nameAuthor = storyList.get(i).getAuthor();
            System.out.printf("\t\t\t\t\t\t %-5s %-35s %-30s %-20s\n",id,nameStory,category,nameAuthor);
        }
    }
}
