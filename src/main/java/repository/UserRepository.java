package repository;

import model.User;
import org.json.simple.parser.ParseException;
import services.JacksonParser;
import services.Read;
import services.Write;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
    public static List<User>  userList = new ArrayList<>();

   public static void importUserToList() throws IOException, ParseException {
       long fileSize = Files.size(Paths.get("data/userdata.json"));
       if (fileSize != 0 ){
           Read.readJsonUser(userList,"data/userdata.json");
       }
   }
   public boolean checkExistUser(int ipId, String ipUserName, String ipEmail ) throws IOException, ParseException {
       for (int i = 0; i <userList.size() ; i++) {
           int id=userList.get(i).getId();
           String username =userList.get(i).getUsername();
           String email = userList.get(i).getEmail();
           if(id == ipId || username.equals(ipUserName) || email.equals(ipEmail)){
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
        System.out.print("Nhap Ho va Ten: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhap UserName: ");
        String username = scanner.nextLine();
        System.out.print("Nhap Password: ");
        String password = scanner.nextLine();
        System.out.print("Nhap Email: ");
        String email = scanner.nextLine();
        if (checkExistUser(id,username,email)){
            System.out.println("Nguoi dung da ton tai");
        } else {
            System.out.println("Dang ki thanh cong, hay dang nhap de su dung!");
            User newUser = new User(id,fullName,username,password,email);
            userList.add(newUser);
            String jsonUser = JacksonParser.INSTANCE.toJson(userList);
            Write.writeJsonFile(jsonUser,"data/userdata.json" );
        }

    }
}
