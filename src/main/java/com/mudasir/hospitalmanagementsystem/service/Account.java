package com.mudasir.hospitalmanagementsystem.service;
import java.util.Scanner;
class Account{
    public static double interest;
    public static double transcationlimit;
    public static void displayAccount(){
        Scanner scanner= new Scanner(System.in);
        String password="";
        while(!password.equals(Login.getStoredPassword())) {
            System.out.println("Enter your password to display information.");
            password = scanner.nextLine();
            if (!password.equals(Login.getStoredPassword())) {
                char c;
                System.out.println("Press Y to retry and N to go Back");
                c=scanner.nextLine().charAt(0);
                if(c == 'n' || c =='N'){
                    Menu.displayMenu();
                }
            }
        }
            if (password.equals(Login.getStoredPassword())) {
                char c;
                System.out.println("Displaying Information.");
                System.out.println("Name : " + Login.getStoredUsername());
                System.out.println("Account Number : " + Login.getPatientNumber());
                System.out.println("Password : " + Login.getStoredPassword());
                System.out.println("Recovery Key : " + Login.getRecoverykey());
                System.out.println("Interest Rate "+Account.interest);
                System.out.println("press C to change details and Y to go back");
                c=scanner.nextLine().charAt(0);
                if(c == 'c' || c =='C'){
                    changeInfo();
                }
                else{
                    Menu.displayMenu();
                }
            }
    }
    public static void changeInfo(){
        Scanner scanner= new Scanner(System.in);
        String storesUsername;
        String storesPassword;
        String recoverkey;
        int c;
        System.out.println("1.Name : " + Login.getStoredUsername());
        System.out.println("2.Password : " + Login.getStoredPassword());
        System.out.println("3.Recovery Key : " + Login.getRecoverykey());
        System.out.println("Enter a Number corresponding to info to change it.");
        c=scanner.nextInt();
        switch (c){
            case 1:
                System.out.println("Enter a New Name.");
                storesUsername=scanner.nextLine();
                scanner.nextLine();
                Login.setStoredUsername(storesUsername);
                Menu.displayMenu();
                break;
            case 2:
                System.out.println("Enter a New Password.");
                storesPassword=scanner.nextLine();
                scanner.nextLine();
                Login.setStoredPassword(storesPassword);
                Menu.displayMenu();
                break;
            case 3:
                System.out.println("Enter a New Recovery Key.");
                recoverkey=scanner.nextLine();
                scanner.nextLine();
                Login.setRecoverykey(recoverkey);
                Menu.displayMenu();
                break;
        }
    }
}
