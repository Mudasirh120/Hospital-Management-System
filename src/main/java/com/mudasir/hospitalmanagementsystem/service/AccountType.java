package com.mudasir.hospitalmanagementsystem.service;
import java.util.Scanner;
abstract class AccountType{
//   static Current ca = new Current();
//    static Saving sa = new Saving();
    String accountType;
   static void AccountType(){
        int c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an account type : /n1. Saving Account /n2. Current Account ");
        c=scanner.nextInt();
        switch (c){
            case 1 :
//                Account.interest=sa.calculateInterest();
//                Account.transcationlimit=sa.transactionLimit();
                Menu.displayMenu();
                break;
            case 2 :
//                Account.interest=ca.calculateInterest();
//                Account.transcationlimit=ca.transactionLimit();
                Menu.displayMenu();
                break;
            default:
                System.out.println("Invalid Choice");
                AccountType();
                break;
        }
    }
}
