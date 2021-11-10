package method;

import org.json.simple.parser.ParseException;
import repository.StoryRepository;
import view.ListStoryView;
import view.ViewMenu;

import javax.swing.text.View;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserMenthod {


    public static void showFunciton() throws IOException, ParseException {
        System.out.println("Chon chuc nang: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                ListStoryView.view();
                readStory();
                System.out.println("Nhan 1 De Doc Truyen Tiep\n" +
                                   "Nhan 2 De Tro Lai");
                int choice2 = scanner.nextInt();
                while (choice2 == 1){
                    readStory();
                    System.out.println("Nhan 1 De Doc Truyen Tiep\n" +
                            "Nhan 2 De Tro Lai");
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
        for (int i = 0; i < StoryRepository.storyList.size(); i++) {
           if(idStory == StoryRepository.storyList.get(i).getId()){
               path=StoryRepository.storyList.get(i).getPath();
           };
        }
        readPdf( path);
    }
    public static void readPdf(String path){

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
