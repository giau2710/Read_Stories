package method;

import javafx.scene.transform.Scale;
import org.json.simple.parser.ParseException;
import repository.UserRepository;

import java.io.IOException;
import java.util.Scanner;

public class Login {
    private static String iPUsername;
    private static String iPPassword;

    public static boolean loginUser() throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap username: ");
         iPUsername = scanner.nextLine();
        System.out.print("Nhap password: ");
        iPPassword=scanner.nextLine();
        for (int i = 0; i < UserRepository.userList.size() ; i++) {
            if(iPPassword.equals(UserRepository.userList.get(i).getPassword())
                    && iPUsername.equals(UserRepository.userList.get(i).getUsername())){
                return true;
            }
        }
        return false;
    }

    public static boolean checkAdmin(){
        return iPUsername.equals("2") && iPPassword.equals("2");
    }

}
