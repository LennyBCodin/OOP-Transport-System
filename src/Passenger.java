public class Passenger extends User implements Payable {
    private double walletBalance;

    public Passenger(String name, String id, double walletBalance) {
        super(name, id);
      
        this.walletBalance = (walletBalance < 0) ? 0 : walletBalance;
    }

    @Override
    public void showDashboard() {
        System.out.println("Passenger: " + this.name + " | Balance: $" + walletBalance);
    }

    @Override
    public void processPayment(double amount) {
        
        if (amount > walletBalance) {
            throw new ArithmeticException("Insufficient funds! Trip cost: $" + amount + " but you only have $" + walletBalance);
        }
        this.walletBalance -= amount;
        System.out.println("Payment Successful. Enjoy your ride!");
    }
}