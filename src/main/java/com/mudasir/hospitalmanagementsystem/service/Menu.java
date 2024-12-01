package com.mudasir.hospitalmanagementsystem.service;
import java.util.Scanner;

import com.mudasir.hospitalmanagementsystem.util.AccountType;
public class Menu {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome ");
        System.out.println("Choose what to do ");
        System.out.println("1. View Details");
        System.out.println("2. Reset Password");
        System.out.println("3. Change User Type");
        System.out.println("4. Pending Payments");
        System.out.println("5. Book Appointment ");
        System.out.println("6. Check Reports ");
        System.out.println("7. Check Medicines ");
        System.out.println("8. Check Prescription ");
        System.out.println("9. Logout");
        System.out.println("Make a Choice :");
        int mychoice;
        mychoice=scanner.nextInt();
        switch (mychoice){
            case 1 :
               Account.displayAccount();
               break;
            case 2 :
              ResetPin.changePin();
              break;
            case 3:
              AccountType.AccountType();
              break;
            case 4:
                double depo;
                System.out.println("Enter amount to be deposited");
                depo = scanner.nextDouble();
                Deposits.deposit(depo);
                displayMenu();
                break;
            case 5:
                double with;
                System.out.println("Enter amount to be Withdrawn");
                with = scanner.nextDouble();
                Withdraws.withdraw(with);
                displayMenu();
                break;
            case 6:
                BankAccounts.getBalance();
                displayMenu();
                break;
            case 7 :
              Login.loginPage();
              break;
            default:
                System.out.println("Invalid Input");
                displayMenu();
                break;
        }
    }
}

