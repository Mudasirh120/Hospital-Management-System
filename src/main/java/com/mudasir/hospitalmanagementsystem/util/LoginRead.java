package com.mudasir.hospitalmanagementsystem.util;
import com.mudasir.hospitalmanagementsystem.service.Login;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LoginRead {
    static Boolean searchFileLogin(Scanner scanner,String cnic){
        while (scanner.hasNextLine()) {
            String[] userData = scanner.nextLine().split(",");
            String fileCnic = userData[0];
            if (fileCnic.equals(cnic)) {
                Login.setStoredCnic(userData[0]);
                Login.setStoredUsername(userData[1]);
                Login.setStoredFatherName(userData[2]);
                Login.setStoredCity(userData[3]);
                Login.setStoredAccType(userData[4]);
                Login.setStoredRecovery(userData[5]);
                Login.setStoredPassword(userData[6]);
                return true;
        }
    }
    return false;
}
    static Boolean searchFileRegister(Scanner scanner,String cnic){
        while (scanner.hasNextLine()) {
            String[] userData = scanner.nextLine().split(",");
            String fileCnic = userData[0];
            if (fileCnic.equals(cnic)) {
                return true;
        }
    }
    return false;
}
public static boolean UserExist(String cnic) {
    try {
        File file1 = new File("resources/patients.csv");
        File file2 = new File("resources/doctors.csv");
        File file3 = new File("resources/admins.csv");
        Scanner scanner1 = new Scanner(file1);
        Scanner scanner2 = new Scanner(file2);
        Scanner scanner3 = new Scanner(file3);
        if(searchFileRegister(scanner1, cnic) ||
        searchFileRegister(scanner2, cnic) ||
        searchFileRegister(scanner3, cnic)){
            return true;
        }
        scanner1.close();
        scanner2.close();
        scanner3.close();
    } catch (FileNotFoundException e) {
        System.out.println("User file not found.");
        e.printStackTrace();
    }
    return false;
}
    public static boolean readFile(String cnic) {
        try {
            File file1 = new File("resources/patients.csv");
            File file2 = new File("resources/doctors.csv");
            File file3 = new File("resources/admins.csv");
            Scanner scanner1 = new Scanner(file1);
            Scanner scanner2 = new Scanner(file2);
            Scanner scanner3 = new Scanner(file3);
            if(!searchFileLogin(scanner1, cnic)||
            searchFileLogin(scanner2, cnic)||
            searchFileLogin(scanner3, cnic)){
                return false;
            }
            scanner1.close();
            scanner2.close();
            scanner3.close();
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
            e.printStackTrace();
        }
        return false;
    }
}
