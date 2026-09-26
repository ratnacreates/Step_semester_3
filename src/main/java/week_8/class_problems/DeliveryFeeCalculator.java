import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();

    public abstract String getType();
}

class StandardDelivery extends Delivery {

    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {

    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {

    public static Delivery createDelivery(String type, double weight,
                                           double distance, double customsFee) {

        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);

            case "EXPRESS":
                return new ExpressDelivery(weight, distance);

            case "INTERNATIONAL":
                return new InternationalDelivery(weight, distance, customsFee);

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
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            double customsFee = 0;

            if (type.equals("INTERNATIONAL")) {
                customsFee = sc.nextDouble();
            }

            Delivery delivery = createDelivery(
                    type, weight, distance, customsFee
            );

            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n",
                    delivery.getType(), fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}