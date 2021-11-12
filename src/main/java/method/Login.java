package method;

import javafx.scene.transform.Scale;
import org.json.simple.parser.ParseException;
import repository.UserRepository;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    private static String ipUsername;
    private static String ipPassword;

    public static boolean loginUser() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap username: ");
         ipUsername = scanner.nextLine();
        System.out.print("Nhap password: ");
        ipPassword=scanner.nextLine();
        for (int i = 0; i < UserRepository.userList.size() ; i++) {
            if(ipPassword.equals(UserRepository.userList.get(i).getPassword())
                    && ipUsername.equals(UserRepository.userList.get(i).getUsername())){
                return true;
            }
        }
        return false;
    }

    public static boolean checkAdmin(){
        return ipUsername.equals("2") && ipPassword.equals("2");
    }

}
