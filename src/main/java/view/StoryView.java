package view;

import model.Story;
import org.json.simple.parser.ParseException;
import repository.StoryRepository;
import repository.UserRepository;
import services.Read;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StoryView {
    StoryRepository storyRepository = new StoryRepository();

    public void view() {

        List<Story> storyList = storyRepository.getStories();
        System.out.println("\t\t\t\t\t\t-----------------------------------DANH SACH TRUYEN------------------------------");
        System.out.printf("\t\t\t\t\t\t %-5s %-35s %-30s %-20s\n", "ID", "Name Story", "Category", "Author");
        for (int i = 0; i < storyList.size(); i++) {
            int id = storyList.get(i).getId();
            String nameStory = storyList.get(i).getName();
            String category = storyList.get(i).getCategory();
            String nameAuthor = storyList.get(i).getAuthor();
            System.out.printf("\t\t\t\t\t\t %-5s %-35s %-30s %-20s\n", id, nameStory, category, nameAuthor);
        }
    }

    public void addStory() {
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
        Story newStory = new Story(id, name, category, path, author);
        if (storyRepository.exist(newStory)) {
            System.out.println("Truyen da ton tai");
        } else {
            storyRepository.add(newStory);
        }
    }
    public void deleteStory(){

    }
}
