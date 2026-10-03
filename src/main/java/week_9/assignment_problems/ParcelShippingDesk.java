import java.util.Scanner;

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();

    public abstract double calculateInsurance();
}

class StandardParcel extends Parcel {

    public StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double calculateCharge() {
        return 40 + (10 * weight);
    }

    public double calculateInsurance() {
        return 0;
    }
}

class ExpressParcel extends Parcel {

    public ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double calculateCharge() {
        return 80 + (15 * weight);
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel {

    public FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    public double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {

    public static Parcel createParcel(String type,
                                      double weight,
                                      double declaredValue) {

        switch (type) {
            case "STANDARD":
                return new StandardParcel(weight, declaredValue);

            case "EXPRESS":
                return new ExpressParcel(weight, declaredValue);

            case "FRAGILE":
                return new FragileParcel(weight, declaredValue);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel =
                    createParcel(type, weight, declaredValue);

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = charge + insurance;

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}