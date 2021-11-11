package repository;

import example.Example;
import model.User;
import org.json.simple.parser.ParseException;
import services.JacksonParser;
import services.Read;
import services.Write;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
    Example example = new Example();
    public static List<User> userList = new ArrayList<>();

    public static void importUserToList() throws IOException, ParseException {
        long fileSize = Files.size(Paths.get("data/user.json"));
        if (fileSize != 0) {
            Read.readJsonUser(userList, "data/user.json");
        }
    }

    public boolean checkExistUser(int ipId, String ipUserName, String ipEmail) throws IOException, ParseException {
        for (int i = 0; i < userList.size(); i++) {
            int id = userList.get(i).getId();
            String username = userList.get(i).getUsername();
            String email = userList.get(i).getEmail();
            if (id == ipId || username.equals(ipUserName) || email.equals(ipEmail)) {
                return true;
            }
        }
        return false;
    }

    public void addUser() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin nguoi dung: ");
        System.out.print("Nhap ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String fullname;
        do {
            System.out.print("Nhap ho va ten: ");
            fullname = scanner.nextLine();
            if (!example.isFullname(fullname)) {
                System.out.println("Xin vui long nhap dung ho va ten:");
            }
        } while (!example.isFullname(fullname));
        System.out.print("Nhap UserName: ");
        String username = scanner.nextLine();
        String password ;
        do {
            System.out.print("Nhap mat khau: ");
            password = scanner.nextLine();
            if (!example.isPassword(password)) {
                System.out.println("Mat khau yeu, xin vui long nhap lai");
            }
        } while (!example.isPassword(password));
        String email;
        do {
            System.out.print("Nhap dia chi email: ");
            email = scanner.nextLine();
            if (!example.isEmail(email)) {
                System.out.println("Khong ton tai dia chi email nay, hay nhap lai ");
            }
        } while (!example.isEmail(email));

        if (checkExistUser(id, username, email)) {
            System.out.println("Nguoi dung da ton tai");
        } else {
            System.out.println("Dang ki thanh cong, hay dang nhap de su dung!");
            User newUser = new User(id, fullname, username, password, email);
            userList.add(newUser);
            String jsonUser = JacksonParser.INSTANCE.toJson(userList);
            Write.writeJsonFile(jsonUser, "data/user.json");
        }

    }

}
