package view;

import method.UserMenthod;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ViewMenu {
    public static void showMenu(){
        System.out.println("|----Welcome to the reading library----|");
        System.out.println("| 1.Dang nhap                          |");
        System.out.println("| 2.Dang ki                            |");
        System.out.println("|                 0.Thoat chuong trinh |");
        System.out.println("|                 10.Quay lai          |");
        System.out.println("|--------------------------------------|");
        System.out.print("Chon chuc nang: ");
    }

    public static void showMenuUser() throws IOException, ParseException {
        System.out.println("|----Welcome to the reading library----|");
        System.out.println("| 1.Đoc truyen                         |");
        System.out.println("| 2.Doc truyen theo the loai           |");
        System.out.println("|                 0.Thoat chuong trinh |");
        System.out.println("|--------------------------------------|");
        UserMenthod.showFunciton();

    }
    public static void showMenuAdmin() throws IOException, ParseException {
        System.out.println("|---------------Menu Admin-------------|");
        System.out.println("| 1.Them truyen                        |");
        System.out.println("| 2.Xem danh sach truyen               |");
        System.out.println("| 3.Sua tryen                          |");
        System.out.println("| 4.Xoa truyen                         |");
        System.out.println("|                 0.Thoat chuong trinh |");
        System.out.println("|--------------------------------------|");
    }

}