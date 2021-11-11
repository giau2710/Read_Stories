package method;


import model.Story;
import org.json.simple.parser.ParseException;
import repository.StoryRepository;
import view.StoryView;
import view.ViewMenu;

import java.io.IOException;
import java.util.Scanner;

import static method.UserMenthod.readStory;
import static method.UserMenthod.storyRepository;

public class AdminMethod {

    public static void showFuntion() throws IOException, ParseException {
        StoryView storyRepository = new StoryView();
        System.out.print("Chon chuc nang: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:

                storyRepository.addStory();
                System.out.println("---------------------------");
                System.out.println("Nhap 1 de them truyen tiep ");
                System.out.println("Nhap 2 de quay lai         ");
                System.out.println("---------------------------");
                int choice2 = scanner.nextInt();
                while (choice2 == 1) {
                    storyRepository.addStory();
                    System.out.println("---------------------------");
                    System.out.println("Nhap 1 de them truyen tiep ");
                    System.out.println("Nhap 2 de quay lai         ");
                    System.out.println("---------------------------");

                    choice2 = scanner.nextInt();
                }
                ViewMenu.showMenuAdmin();
                break;
            case 2:
                storyRepository.view();
                readStory();
                System.out.println("---------------------------");
                System.out.println("Nhap 1 de doc truyen tiep ");
                System.out.println("Nhap 2 de quay lai         ");
                System.out.println("---------------------------");
                 choice2 = scanner.nextInt();
                while (choice2 == 1){
                    readStory();
                    System.out.println("---------------------------");
                    System.out.println("Nhap 1 de doc truyen tiep ");
                    System.out.println("Nhap 2 de quay lai         ");
                    System.out.println("---------------------------");
                    choice2 = scanner.nextInt();
                }
                ViewMenu.showMenuAdmin();
            case 3:
                editStory();
                break;
            case 4:
                deleteStory();
                break;
            default:
                break;
        }
    }
    public static void deleteStory(){
        StoryRepository storyRepository = new StoryRepository();
        System.out.print("Nhap id truyen can xoa: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        storyRepository.delete(id);
    }
    public static void editStory(){
        Scanner scanner = new Scanner(System.in);
        StoryRepository storyRepository = new StoryRepository();
        System.out.print("Nhap id truyen can sua: ");
        int id = scanner.nextInt();
        storyRepository.edit(id);
    }

}
