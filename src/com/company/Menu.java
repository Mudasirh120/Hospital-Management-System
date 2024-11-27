import java.util.Scanner;

public class Menu {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome ");
        System.out.println("Choose what to do ");
        System.out.println("1. View Details");
        System.out.println("2. Reset Pin");
        System.out.println("3. Change Account Type");
        System.out.println("4. Deposit Cash");
        System.out.println("5. Withdraw Cash ");
        System.out.println("6. Check Balance ");
        System.out.println("7. Logout");
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
