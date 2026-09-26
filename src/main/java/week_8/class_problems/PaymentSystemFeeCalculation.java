import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getType();
}

class CardPayment extends Payment {

    public CardPayment(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount + (amount * 0.02);
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {

    public WalletPayment(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount + (amount * 0.01);
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {

    public BankTransferPayment(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystemFeeCalculation {

    public static Payment createPayment(String type, double amount) {

        switch (type) {
            case "CARD":
                return new CardPayment(amount);

            case "WALLET":
                return new WalletPayment(amount);

            case "BANKTRANSFER":
                return new BankTransferPayment(amount);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Payment payment = createPayment(type, amount);

            double finalAmount = payment.calculateFinalAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}