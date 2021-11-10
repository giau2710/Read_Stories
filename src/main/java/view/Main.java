package view;

import method.Login;
import org.json.simple.parser.ParseException;

import repository.UserRepository;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        UserRepository userRepository = new UserRepository();
        StoryView storyView = new StoryView();
        UserRepository.importUserToList();
        ViewMenu.showMenu();
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
                        }
                break;
                case 2:
                    userRepository.addUser();
                    ViewMenu.showMenu();
                    break;
                default:
                    break;
            }
        } catch(InputMismatchException e){
            System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
            ViewMenu.showMenu();
        }
    } while(choose !=0);
        System.out.println("Da thoat chuong trinh");

}
}
