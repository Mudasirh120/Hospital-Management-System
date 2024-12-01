package com.mudasir.hospitalmanagementsystem.util;
import com.mudasir.hospitalmanagementsystem.service.Login;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LoginRead {
    static void searchFile(Scanner scanner,String cnic){
        while (scanner.hasNextLine()) {
            String[] userData = scanner.nextLine().split(",");
            String fileCnic = userData[0];
            if (fileCnic.equals(cnic)) {
                Login.setStoredUsername(userData[1]);
                Login.setStoredPassword(userData[6]);
                Login.setStoredRecovery(userData[5]);
                break;
        }
    }
}
    public static void readFile(String cnic) {
        try {
            File file1 = new File("resources/patients.csv");
            File file2 = new File("resources/doctors.csv");
            File file3 = new File("resources/admins.csv");
            Scanner scanner1 = new Scanner(file1);
            Scanner scanner2 = new Scanner(file2);
            Scanner scanner3 = new Scanner(file3);
            searchFile(scanner1, cnic);
            searchFile(scanner2, cnic);
            searchFile(scanner3, cnic);
            scanner1.close();
            scanner2.close();
            scanner3.close();
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
            e.printStackTrace();
        }
    }
}
