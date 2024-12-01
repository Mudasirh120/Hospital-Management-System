package com.mudasir.hospitalmanagementsystem.util;
import java.util.Scanner;
import com.mudasir.hospitalmanagementsystem.service.Login;
public class AccountType{
    String accountType;
    public static void Role(){
        int c=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an account type : \n1. Patient \n2. Doctor \n3.Admin");
        c=scanner.nextInt();
        scanner.close();
        switch (c){
                        case 1 :
                        Login.setAccType("Patient");
                            break;
                        case 2 :
                        Login.setAccType("Doctor");
                            break;
                        case 3 :
                        Login.setAccType("Admin");
                        break;
                        default:
                            System.out.println("Invalid Choice");
                            Role();
                            break;
                    }
    }
//    static void AccountType(){
//         int c;
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Choose an account type : /n1. Saving Account /n2. Current Account ");
//         c=scanner.nextInt();
//         switch (c){
//             case 1 :
// //                Account.interest=sa.calculateInterest();
// //                Account.transcationlimit=sa.transactionLimit();
//                 Menu.displayMenu();
//                 break;
//             case 2 :
// //                Account.interest=ca.calculateInterest();
// //                Account.transcationlimit=ca.transactionLimit();
//                 Menu.displayMenu();
//                 break;
//             default:
//                 System.out.println("Invalid Choice");
//                 AccountType();
//                 break;
//         }
//     }
}
