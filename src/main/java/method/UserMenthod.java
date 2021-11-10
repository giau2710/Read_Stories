package method;

import model.Story;
import org.json.simple.parser.ParseException;
import repository.StoryRepository;
import repository.UserRepository;
import view.StoryView;
import view.ViewMenu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserMenthod {

    static StoryRepository storyRepository = new StoryRepository();
    static StoryView storyView = new StoryView();

    public static void showFunciton() throws IOException, ParseException {
        System.out.println("Chon chuc nang: ");
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                storyView.view();
                readStory();
                System.out.println("---------------------------");
                System.out.println("Nhap 1 de doc truyen tiep ");
                System.out.println("Nhap 2 de quay lai         ");
                System.out.println("---------------------------");
                int choice2 = scanner.nextInt();
                while (choice2 == 1) {
                    readStory();
                    System.out.println("---------------------------");
                    System.out.println("Nhap 1 de doc truyen tiep ");
                    System.out.println("Nhap 2 de quay lai         ");
                    System.out.println("---------------------------");
                    choice2 = scanner.nextInt();
                }
                ViewMenu.showMenuUser();
        }
    }

    public static void readStory() {
        System.out.println("Nhap ID Truyen: ");
        Scanner scanner = new Scanner(System.in);
        String path = null;
        int idStory = scanner.nextInt();
        System.out.println(idStory);
        Story story = storyRepository.getById(idStory);
        readPdf(story.getPath());
    }

    public static void readPdf(String path) {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(path);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.out.println("File khong doc duoc");
            }
        }
    }


}
