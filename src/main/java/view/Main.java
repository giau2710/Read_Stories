package view;

import method.Login;
import org.json.simple.parser.ParseException;
import repository.StoryRepository;
import repository.UserRepository;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        UserRepository userRepository = new UserRepository();
        StoryRepository storyRepository = new StoryRepository();
        UserRepository.importUserToList();
        StoryRepository.importStoryToList();
        ViewMenu.showMenu();
//        if (Desktop.isDesktopSupported()) {
//            try {
//                File myFile = new File("H:\\Case_Study_Module2\\Read_Stories\\datastory\\chudongtuvacongchuatiendung.pdf");
//                Desktop.getDesktop().open(myFile);
//            } catch (IOException ex) {
//                // no application registered for PDFs
//            }
//        }
        int choose = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        if (Login.loginUser()) {
                            if (Login.checkAdmin()) {
                                ViewMenu.showMenuAdmin();
                            } else {
                                ViewMenu.showMenuUser();
                            }
                        } else{
                            System.out.println("Tai khoan khong ton tai,vui long thu lai!");
                            ViewMenu.showMenu();
                        };
                break;
                case 2:
                    userRepository.addUser();
                    ViewMenu.showMenu();

                    break;
                case 3:
                    storyRepository.addStory();
                    break;
                default:
                    break;
            }
        } catch(InputMismatchException e){
            System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
        }
    } while(choose !=0);
        System.out.println("Da thoat chuong trinh");

}
}
