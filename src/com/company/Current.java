public class Current extends AccountType {
     double transactionLimit() {
        return 1000000;
    }
     double calculateInterest() {
        return 0.10;
    }
}