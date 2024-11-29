package com.mudasir.hospitalmanagementsystem.service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Scanner;
import java.util.Random;
public class Login {
    public static void createFile(){
        try {
            File myFile = new File("resources/users.csv");
            if (myFile.createNewFile()) {
              System.out.println("File created: " + myFile.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    private static long patientNumber;
    private static String username;
    private static String password;
    private static String storedUsername="Mudasir";
    private static String storedPassword="Mudasir";
    private static String recoverykey;
    public static void setStoredUsername(String username) {
        Login.storedUsername = username;
    }
    public static String getStoredUsername() {
        return storedUsername;
    }
    public static String getRecoverykey() {
        return recoverykey;
    }
    public static void setRecoverykey(String recoverykey) {
        Login.recoverykey = recoverykey;
    }
    public static String getStoredPassword() {
        return storedPassword;
    }
    public static void setStoredPassword(String storedPassword) {
        Login.storedPassword = storedPassword;
    }
    public static long getPatientNumber() {
        return patientNumber;
    }
    private static boolean loggedIn = false;
    private static int choice;
    public static void writeFile(){
       try {
      FileWriter myWriter = new FileWriter("resources/users.csv");
      myWriter.write(patientNumber + "," + storedUsername + "," + storedPassword + "," + recoverykey + "\n");
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    public static void register(){
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\t  Username: ");
        storedUsername = scanner.nextLine();
        System.out.print("\t\t\t\t\t\t\t  Password: ");
        storedPassword = scanner.nextLine();
        System.out.print("\t\t\t\t\t\t\t  Recovery key : ");
        recoverykey= scanner.nextLine();
        long acNumber= rand.nextLong(100000000);
        patientNumber=acNumber;
        System.out.println("\n\n\t\t\t\t\t\t\t Successful Signup.");
        scanner.close();
        writeFile();
        login();
    }
    public static boolean readFile(String inputUsername, String inputPassword) {
        try {
            File file = new File("resources/users.csv");
            Scanner scanner = new Scanner(file);
    
            while (scanner.hasNextLine()) {
                String[] userData = scanner.nextLine().split(",");
                String fileUsername = userData[0];
                String filePassword = userData[1];
                if (fileUsername.equals(inputUsername) && filePassword.equals(inputPassword)) {
                    System.out.println("Login successful!");
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
            System.out.println("Invalid username or password.");
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
            e.printStackTrace();
        }
        return false;
    }
    public static void login(){
        Scanner scanner=new Scanner(System.in);
        while (loggedIn==false) {
            System.out.print("\n\n\t\t\t\t\t\t Username: ");
            username= scanner.nextLine();
            System.out.print("\n\n\t\t\t\t\t\t Password: ");
            password = scanner.nextLine();
            readFile(storedUsername, password);
            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                loggedIn = true;
                System.out.println("Login successful!");
                Menu.displayMenu();
            }
            else if (username.equals(storedUsername) && !password.equals(storedPassword)) {
                System.out.println("\n\n\t\t\t\t\tIncorrect password.");
                System.out.println("\n\n\t\t\tPress Y to change password, R to Register, and N to Retry login.");
                char pchange = scanner.nextLine().charAt(0);
                if (pchange == 'R' || pchange == 'r') {
                    register();
                }
                else if (pchange == 'Y' || pchange == 'y') {
                    while (true) {
                        System.out.println("\n\n\t\t\t\t\t Enter login credentials.\n\n");
                        System.out.print("\n\n\t\t\t\t\tEnter your Username: ");
                        String newUsername= scanner.nextLine();
                        if (newUsername.equals(storedUsername)) {
                            System.out.println("Enter your Recovery key :");
                            String newRecovery = scanner.nextLine();
                            if (newRecovery.equals(recoverykey)) {
                                System.out.print("\n\n\t\t\t\t\tEnter new password: ");
                                storedPassword = scanner.nextLine();
                                break;
                            }else{
                                System.out.println("\n\n\t\t\tPress Y to retry, R to Register, and L to login.");
                                 pchange = scanner.nextLine().charAt(0);
                                if (pchange == 'R' || pchange == 'r') {
                                    register();
                                }
                                else if (pchange == 'L' || pchange == 'l') {
                                    login();
                                }
                            }
                        } else
                        {
                            System.out.println("\n\n\t\t\t\t\tNo match for user.");
                            System.out.println("\n\n\t\t\t\t\tPress Y to retry and N to Retry login.");
                            pchange = scanner.nextLine().charAt(0);
                            if (pchange == 'N' || pchange == 'n') {
                                break;
                            }
                        }
                    }
                }                    }
            else if (!username.equals(storedUsername) && password.equals(storedPassword))
            {                        System.out.println("\n\n\t\t\t\t\tIncorrect Username.");
            } else
            {                        System.out.println("\n\n\t\t\t\t\tUnregistered user.");
                System.out.println("\n\n\t\t\t\t\tTo retry press 1.");
                System.out.println("\n\n\t\t\t\t\tTo go back to Register press 2.");
                choice = scanner.nextInt();
                if (choice == 2) {
                    register();
                    loggedIn = false;
                    break;
                }
            }
        }
        AccountType.AccountType();
    }
    public static void loginPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t\t\t   Welcome to Shifa Khana \n\n");
        System.out.println("\n\n\n\t\t\t\t\t\t\t\t1. Login");
        System.out.println("\t\t\t\t\t\t\t\t2. Register");
        System.out.println("\t\t\t\t\t\t\t\t3. Exit");
        System.out.println("\t\t\t\t\t\t\t      Choose an option.");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
             login()  ;
        break;
        case 2:
            register();
            break;
        case 3:
            break;
        default:
            System.out.println("\n\n\t\t\t\t\tInvalid choice. Please choose 1 or 2 or 3.");
            loginPage();
            break;        }
        }

}