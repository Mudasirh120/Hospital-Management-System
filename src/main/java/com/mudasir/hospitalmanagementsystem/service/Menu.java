package com.mudasir.hospitalmanagementsystem.service;
import java.util.Scanner;
public class Menu {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome ");
        System.out.println("Choose what to do ");
        System.out.println("1. View Details");
        System.out.println("2. Book Appointment ");
        System.out.println("3. Check Prescription ");
        System.out.println("4. Check Reports ");
        System.out.println("5. Check Medicines ");
        System.out.println("6. Pending Payments");
        System.out.println("7. Logout");
        System.out.println("Make a Choice :");
        int mychoice;
        mychoice=scanner.nextInt();
        switch (mychoice){
            case 1 :
               Account.displayAccount();
               break;
            case 2 :
              break;
            case 3:
              break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7 :
              Login.loginPage();
              break;
            default:
                System.out.println("Invalid Input");
                displayMenu();
                break;
        }
        scanner.close();
    }
}

