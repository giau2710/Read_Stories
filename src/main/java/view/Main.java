package view;

import org.json.simple.parser.ParseException;
import repository.StoryRepository;
import repository.UserRepository;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
  UserRepository userRepository = new UserRepository();
  StoryRepository storyRepository = new StoryRepository();
        int choose = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            ViewMenu.showMenuUser();
            try {
                choose = scanner.nextInt();
            } catch (InputMismatchException eI) {
                System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
            }
            switch (choose) {
                case 1:
                     userRepository.addUser();
                    break;
                case 2:
                   storyRepository.addStory();
                    break;
                case 3:
                    ListStoryView.view();
                    break;

            }
        } while (choose != 0);
        System.out.println("Da thoat chuong trinh");

    }
}
