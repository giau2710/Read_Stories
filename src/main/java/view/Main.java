package view;

import method.Login;
import org.json.simple.parser.ParseException;

import repository.UserRepository;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        UserRepository.importUserToList();
        View.viewFirst();
    }

    }

