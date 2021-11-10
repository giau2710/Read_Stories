package view;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception{
        int choose = 0 ;
        Scanner scanner = new Scanner(System.in);

        do {
            ViewMenu.showMenu();



                try {
                    choose=scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("ban nhap sai vui long nhap lai");
                }


        }while (choose!=0);
        System.out.println("thoat");
    }
}
