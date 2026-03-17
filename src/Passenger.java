public class Passenger extends User implements Payable {
    private double walletBalance;

    public Passenger(String name, String id, double walletBalance) {
        super(name, id); // Inheritance: Passing data to User constructor
        this.walletBalance = walletBalance; // Encapsulation: accessing private field
    }

    @Override
    public void showDashboard() {
        System.out.println(">>> PASSENGER PANEL: " + this.name + " (ID: " + this.id + ")");
    }

    @Override
    public void processPayment(double amount) {
        // Exception Handling Logic
        if (amount > walletBalance) {
            throw new ArithmeticException("Payment Denied: Balance is too low for this Taxify trip.");
        }
        this.walletBalance -= amount;
        System.out.println("Transaction successful! New Balance: $" + walletBalance);
    }
}