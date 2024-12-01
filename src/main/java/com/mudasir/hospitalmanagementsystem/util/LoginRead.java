package com.mudasir.hospitalmanagementsystem.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginRead {
    public static void readFile(String inputUsername, String inputPassword) {
        try {
            File file = new File("resources/users.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] userData = scanner.nextLine().split(",");
                String fileUsername = userData[1];
                String filePassword = userData[2];
                if (fileUsername.equals(inputUsername) && filePassword.equals(inputPassword)) {
                    storedUsername=fileUsername;
                    storedPassword=filePassword;
                    System.out.println(storedUsername);
                    System.out.println(storedPassword);
                }
            }
            scanner.close();
            System.out.println("Invalid username or password.");
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
            e.printStackTrace();
        }
    }
}
