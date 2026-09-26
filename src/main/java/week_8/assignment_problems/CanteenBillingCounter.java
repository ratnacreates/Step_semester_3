import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getType();
}

class Student extends Customer {

    public Student(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    public String getType() {
        return "STUDENT";
    }
}

class Staff extends Customer {

    public Staff(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    public String getType() {
        return "STAFF";
    }
}

class Guest extends Customer {

    public Guest(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {

    public static Customer createCustomer(String type, double amount) {

        switch (type) {
            case "STUDENT":
                return new Student(amount);

            case "STAFF":
                return new Staff(amount);

            case "GUEST":
                return new Guest(amount);

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

            Customer customer = createCustomer(type, amount);

            double finalAmount = customer.calculateFinalAmount();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}