package com.mudasir.hospitalmanagementsystem.service;
import java.util.Scanner;
class Account{
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
                System.out.println("FatherName : "+ Login.getStoredFatherName());
                System.out.println("Cnic : " + Login.getStoredCnic());
                System.out.println("City : "+Login.getStoredCity());
                System.out.println("Role : "+Login.getStoredAccType());
                System.out.println("Password : " + Login.getStoredPassword());
                System.out.println("Recovery Key : " + Login.getStoredRecoveryKey());
                System.out.println("press C to change details and Y to go back");
                c=scanner.nextLine().charAt(0);
                if(c == 'c' || c =='C'){
                    changeInfo();
                }
                else{
                    Menu.displayMenu();
                }
            }
            scanner.close();
    }
    public static void changeInfo(){
        Scanner scanner= new Scanner(System.in);
        int c;
        String changedInfo;
        System.out.println("1.Name : " + Login.getStoredUsername());
        System.out.println("2.FatherName : "+ Login.getStoredFatherName());
        System.out.println("3.Cnic : " + Login.getStoredCnic());
        System.out.println("4.City : "+Login.getStoredCity());
        System.out.println("5.Password : " + Login.getStoredPassword());
        System.out.println("6.Recovery Key : " + Login.getStoredRecoveryKey());
        System.out.println("Enter a Number corresponding to info to change it.");
        c=scanner.nextInt();
        scanner.nextLine();
        switch (c){
            case 1:
                System.out.println("Enter a New Name.");
                changedInfo=scanner.nextLine();                
                Login.setStoredUsername(changedInfo);
                Menu.displayMenu();
                break;
            case 2:
                System.out.println("Enter a New FatherName.");
                changedInfo=scanner.nextLine();                
                Login.setStoredFatherName(changedInfo);
                Menu.displayMenu();
                break;
            case 3:
                System.out.println("Enter a New Cnic.");
                changedInfo=scanner.nextLine();                
                Login.setStoredCnic(changedInfo);
                Menu.displayMenu();
                break;
            case 4:
                System.out.println("Enter a New City.");
                changedInfo=scanner.nextLine();                
                Login.setStoredCity(changedInfo);
                Menu.displayMenu();
                break;
            case 5:
                System.out.println("Enter a New Password.");
                changedInfo=scanner.nextLine();                
                Login.setStoredPassword(changedInfo);
                Menu.displayMenu();
                break;
            case 6:
                System.out.println("Enter a New Recovery Key.");
                changedInfo=scanner.nextLine();                
                Login.setStoredRecovery(changedInfo);
                Menu.displayMenu();
                break;
            default:
            System.out.println("Invalid Choice.");
            changeInfo();    
        }
        scanner.close();
    }
}
