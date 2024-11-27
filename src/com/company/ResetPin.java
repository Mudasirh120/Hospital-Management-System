import java.util.Scanner;

public class ResetPin {
    public static void changePin(){
        Scanner scanner= new Scanner(System.in);
        String password;
        String pin;
        System.out.println("Enter your password to display information.");
        password = scanner.nextLine();
        if (!password.equals(Login.getStoredPassword())) {
            char c;
            System.out.println("Press Y to retry and N to go Back");
            c=scanner.nextLine().charAt(0);
            if(c == 'n' || c =='N'){
                Menu.displayMenu();
            }
        }else {
            System.out.println("Enter new pin.");
            pin = scanner.nextLine();
            while (true) {
                System.out.print("\t\t\t\t\t\t\t  Transaction Pin (4 digits): ");
                pin = scanner.nextLine();
                if (pin.matches("\\d{4}")) {
                    Login.setPin(pin);
                    Menu.displayMenu();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter exactly 4 digits for the Transaction Pin.");
                }
            }
        }
    }
}
