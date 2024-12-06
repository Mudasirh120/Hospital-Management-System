package com.mudasir.hospitalmanagementsystem.service;
import com.mudasir.hospitalmanagementsystem.util.AccountType;
import com.mudasir.hospitalmanagementsystem.util.LoginRead;
import com.mudasir.hospitalmanagementsystem.util.RegisterWrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Login {
    private static String username;
    private static String fatherName;
    private static String cnic;
    private static String password;
    private static String city;
    private static String recoverykey;
    private static String accountType;
    private static String storedUsername;
    private static String storedFatherName;
    private static String storedCnic;
    private static String storedPassword;
    private static String storedCity;
    private static String storedRecoveryKey;
    private static String storedAccountType;
    public static String getStoredFatherName() {
        return storedFatherName;
    }
    public static String getStoredCnic() {
        return storedCnic;
    }
    public static String getStoredCity() {
        return storedCity;
    }
    public static String getStoredAccType() {
        return storedAccountType;
    }
    public static String getStoredRecoveryKey() {
        return storedRecoveryKey;
    }
    public static String getStoredUsername() {
        return storedUsername;
    }
    public static String getStoredPassword() {
        return storedPassword;
    }
    public static void setStoredUsername(String storedUsername) {
        Login.storedUsername = storedUsername;
    }
    public static void setStoredAccType(String accType) {
        Login.storedAccountType = accType;
    }
    public static void setStoredCity(String nCity) {
        Login.storedCity = nCity;
    }
    public static void setStoredCnic(String nCnic) {
        Login.storedCnic = nCnic;
    }
    public static void setStoredFatherName(String nFather) {
        Login.storedFatherName = nFather;
    }
    public static void setStoredPassword(String storedPassword){
        Login.storedPassword = storedPassword;
    }
    public static void setStoredRecovery(String storedRecovery){
        Login.storedRecoveryKey = storedRecovery;
    }
    public static void setAccType(String role){
        accountType=role;
    }
    public static String getUserName(){
        return username;
    }
    public static String getFatherName(){
        return fatherName;
    }
    public static String getCnic(){
        return cnic;
    }
    public static String getRecoveryKey(){
        return recoverykey;
    }
    public static String getCity(){
        return city;
    }
    public static String getAccountType(){
        return accountType;
    }
    public static String getPassword(){
        return password;
    }
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----- Registration -----");    
        System.out.print("Enter Username: ");
        username = scanner.nextLine().trim();
        while (username.isEmpty()) {
            System.out.print("Username cannot be empty. Enter again: ");
            username = scanner.nextLine().trim();
        }
        System.out.print("Enter Father's Name: ");
        fatherName = scanner.nextLine().trim();
        while (fatherName.isEmpty()) {
            System.out.print("Father's Name cannot be empty. Enter again: ");
            fatherName = scanner.nextLine().trim();
        }
        System.out.print("Enter CNIC (13 digits): ");
        cnic = scanner.nextLine().trim();
        while (!cnic.matches("\\d{13}")) {
            System.out.print("Invalid CNIC. Enter a valid 13-digit CNIC: ");
            cnic = scanner.nextLine().trim();
        }
        System.out.print("Enter City: ");
        city = scanner.nextLine().trim();
        while (city.isEmpty()) {
            System.out.print("City cannot be empty. Enter again: ");
            city = scanner.nextLine().trim();
        }
        System.out.print("Enter Password (minimum 6 characters): ");
        password = scanner.nextLine().trim();
        while (password.length() < 6) {
            System.out.print("Password must be at least 6 characters. Enter again: ");
            password = scanner.nextLine().trim();
        }
        System.out.print("Enter Recovery Key (for password reset): ");
        recoverykey = scanner.nextLine().trim();
        while (recoverykey.isEmpty()) {
            System.out.print("Recovery Key cannot be empty. Enter again: ");
            recoverykey = scanner.nextLine().trim();
        }
        AccountType.Role();
        if (LoginRead.UserExist(cnic)) {
            System.out.println("A user with this CNIC already exists. Please try logging in.");
            loginPage();
            scanner.close();
            return;
        }
        RegisterWrite.writeFile(accountType);
        System.out.println("Registration successful! You can now log in.");
        loginPage();
        scanner.close();
    }        
    public static void resetPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Password Recovery -----");
        System.out.print("Enter your Recovery Key: ");
        String enteredRecoveryKey = scanner.nextLine();
        if (enteredRecoveryKey.equals(storedRecoveryKey)) {
            System.out.print("Enter a new Password: ");
            String newPassword = scanner.nextLine();
            while (newPassword.length() < 6) {
                System.out.print("Password must be at least 6 characters. Enter again: ");
                newPassword = scanner.nextLine();
            }
            setStoredPassword(newPassword);
            if (updatePasswordInFile(cnic, newPassword)) {
                System.out.println("Password updated successfully!");
            } else {
                System.out.println("Failed to update password in file.");
            }
            login();
        } else {
            System.out.println("Incorrect recovery key. Returning to main menu.");
            loginPage();
        }
        scanner.close();
    }    
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----- Login -----");
        System.out.print("Enter your CNIC: ");
        cnic = scanner.nextLine();
        if (!LoginRead.readFile(cnic)) {
            System.out.println("Unregistered CNIC. Please register first.");
            register();
            scanner.close();
            return;
        }
        int attempts = 3; 
        while (attempts > 0) {
            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();
            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                System.out.println("Login successful!");
                Menu.displayMenu();
                scanner.close();
                return;
            } else {
                attempts--;
                System.out.println("Invalid username or password. Attempts remaining: " + attempts);
            }
        }
        System.out.println("Too many failed attempts.");
        System.out.println("Do you want to reset your password? (Y/N)");
        char resetChoice = scanner.nextLine().toUpperCase().charAt(0);
        if (resetChoice == 'Y') {
            resetPassword();
        } else {
            loginPage();
        }
        scanner.close();
    }        
    public static void loginPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n----- Welcome to Shifa Khana -----\n");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        try {
            int choice = Integer.parseInt(scanner.nextLine()); 
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Thank you for using Shifa Khana. Goodbye!");
                    scanner.close();
                    return; 
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                    loginPage(); 
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            loginPage();
        }
        scanner.close();
    }    
        private static boolean updatePasswordInFile(String cnic, String newPassword) {
    String filePath = getRoleFilePath(storedAccountType); 
    File inputFile = new File(filePath);
    File tempFile = new File(filePath + ".tmp"); 
    try (Scanner scanner = new Scanner(inputFile); FileWriter writer = new FileWriter(tempFile)) {
        boolean updated = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] userData = line.split(",");
            if (userData[0].equals(cnic)) { 
                userData[6] = newPassword; 
                updated = true;
            }
            writer.write(String.join(",", userData) + "\n");
        }
        if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
            System.out.println("Error replacing file with updated data.");
            return false;
        }
        return updated;
    } catch (IOException e) {
        System.out.println("File operation error: " + e.getMessage());
        return false;
    }
}
public static String getRoleFilePath(String role) {
    switch (role) {
        case "Patient":
            return "resources/patients.csv";
        case "Doctor":
            return "resources/doctors.csv";
        case "Admin":
            return "resources/admins.csv";
        default:
            throw new IllegalArgumentException("Invalid role: " + role);
    }
}
    public static boolean updateUserDetailsInFile(String roleFile) {
        try {
            FileWriter fileWriter = new FileWriter(roleFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Updated User Details");
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
