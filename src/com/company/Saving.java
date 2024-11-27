public class Saving extends AccountType {
    double transactionLimit() {
        return 500000;
    }
    double calculateInterest() {
        return 0.15;
    }
}

