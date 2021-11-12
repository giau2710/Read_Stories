package view;

import method.Login;
import org.json.simple.parser.ParseException;
import repository.UserRepository;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    public static void viewFirst() {
        ViewMenu.showMenu();
        int choose = -1;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                choose = scanner.nextInt();
                if (choose==0) {
                    System.out.println("Da thoat chuong trinh,cam on ban da su dung!");
                    System.exit(0);
                }
                switch (choose) {
                    case 1:
                        if (Login.loginUser()) {
                            if (Login.checkAdmin()) {
                                ViewMenu.showMenuAdmin();
                            } else {
                                ViewMenu.showMenuUser();
                            }
                        } else {
                            System.out.println("Tai khoan khong ton tai,vui long thu lai!");
                            ViewMenu.showMenu();
                        }
                        break;
                    case 2:
                        UserRepository userRepository = new UserRepository();
                        userRepository.addUser();
                        ViewMenu.showMenu();
                        break;
                    default:
                        System.out.println("Ban da nhap sai gia tri,xin vui long nhap lai!");
                        ViewMenu.showMenu();
                        break;
                }
            } catch (InputMismatchException | IOException | ParseException e) {
                System.out.println("Xin vui long nhap gia tri so!");
                ViewMenu.showMenu();
            }
        } while (choose != 0);
        System.out.println("Da thoat chuong trinh,cam on ban da su dung!");
    }
}
