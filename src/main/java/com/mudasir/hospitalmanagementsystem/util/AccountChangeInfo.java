package com.mudasir.hospitalmanagementsystem.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class AccountChangeInfo {
    public static void readFile(String cnic,String role,int index,String newValue) {
        try {
            switch (role) {
                case "Patient":
                    File file1 = new File("resources/patients.csv");
                    Scanner scanner1 = new Scanner(file1);
                    modifyValue(scanner1, cnic, index, newValue);
                    scanner1.close();            
                    break;
                case "Doctor":    
                    File file2 = new File("resources/doctors.csv");
                    Scanner scanner2 = new Scanner(file2);
                    modifyValue(scanner2, cnic, index, newValue);
                    scanner2.close();
                    break;
                case "Admin":
                    File file3 = new File("resources/admins.csv");
                    Scanner scanner3 = new Scanner(file3);
                    modifyValue(scanner3, cnic, index, newValue);
                    scanner3.close();
                    break;
                default:
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
            e.printStackTrace();
        }
    }
    static Boolean modifyValue(Scanner scanner,String cnic,int index,String newValue){
        while (scanner.hasNextLine()) {
            String[] userData = scanner.nextLine().split(",");
            String fileCnic = userData[0];
            if (fileCnic.equals(cnic)) {
                userData[index]=newValue;
                return true;
        }
    }
    return false;
}
}
