package com.mudasir.hospitalmanagementsystem.service;
import java.util.Scanner;
public class Account {
    public static void displayAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password to display account information:");
        for (int attempts = 3; attempts > 0; attempts--) {
            String password = scanner.nextLine();
            if (password.equals(Login.getStoredPassword())) {
                System.out.println("\n--- Account Details ---");
                System.out.println("Name: " + Login.getStoredUsername());
                System.out.println("Father's Name: " + Login.getStoredFatherName());
                System.out.println("CNIC: " + Login.getStoredCnic());
                System.out.println("City: " + Login.getStoredCity());
                System.out.println("Role: " + Login.getStoredAccType());
                System.out.println("Recovery Key: " + Login.getStoredRecoveryKey());
                System.out.println("-------------------------");
                System.out.println("Press C to change details, or any other key to go back.");
                String choice = scanner.nextLine().toUpperCase();
                if (choice.equals("C")) {
                    changeInfo();
                } else {
                    Menu.displayMenu();
                }
                scanner.close();
                return;
            } else {
                System.out.println("Incorrect password. Attempts remaining: " + (attempts - 1));
            }
            scanner.close();
        }
        System.out.println("Too many failed attempts. Returning to menu.");
        Menu.displayMenu();
    }
    public static void changeInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Change Account Details ---");
        System.out.println("1. Name: " + Login.getStoredUsername());
        System.out.println("2. Father's Name: " + Login.getStoredFatherName());
        System.out.println("3. City: " + Login.getStoredCity());
        System.out.println("4. Password");
        System.out.println("5. Recovery Key");
        System.out.print("Choose a field to update (1-5): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the new value: ");
            String newValue = scanner.nextLine();
            scanner.close();
            switch (choice) {
                case 1:
                    Login.setStoredUsername(newValue);
                    break;
                case 2:
                    Login.setStoredFatherName(newValue);
                    break;
                case 3:
                    Login.setStoredCity(newValue);
                    break;
                case 4:
                    Login.setStoredPassword(newValue);
                    break;
                case 5:
                    Login.setStoredRecovery(newValue);
                    break;
                default:
                    System.out.println("Invalid choice. Returning to menu.");
                    Menu.displayMenu();
                    return;
            }
            if (updateUserDetailsInFile()) {
                System.out.println("Details updated successfully!");
            } else {
                System.out.println("Failed to update details. Please try again.");
            }
            Menu.displayMenu();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Returning to menu.");
            Menu.displayMenu();
        }
    }
    private static boolean updateUserDetailsInFile() {
        String roleFile = Login.getRoleFilePath(Login.getStoredAccType());
        return Login.updateUserDetailsInFile(roleFile);
    }
}
