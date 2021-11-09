package repository;

import model.User;
import org.json.simple.parser.ParseException;
import services.JacksonParser;
import services.Read;
import services.Write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository {
    public static List<User>  userList = new ArrayList<>();

   public void importUserToList() throws IOException, ParseException {
       Read.readJsonUser(userList,"data/userdata.json");
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
        importUserToList();
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
        int password = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap Email: ");
        String email = scanner.nextLine();
        if (checkExistUser(id,username,email)){
            System.out.println("Nguoi dung da ton tai");
        } else {
            User newUser = new User(id,fullName,username,password,email);
            userList.add(newUser);
            String jsonUser = JacksonParser.INSTANCE.toJson(userList);
            Write.writeJsonFile(jsonUser,"data/userdata.json" );
        }

    }
}
