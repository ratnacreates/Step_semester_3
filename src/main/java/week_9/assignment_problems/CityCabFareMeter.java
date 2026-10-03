import java.util.Scanner;

abstract class Cab {
    protected double distance;
    protected String time;

    public Cab(double distance, String time) {
        this.distance = distance;
        this.time = time;
    }

    public abstract double calculateFare();
}

class MiniCab extends Cab {

    public MiniCab(double distance, String time) {
        super(distance, time);
    }

    public double calculateFare() {
        if (time.equals("NIGHT")) {
            return -1;
        }

        return Math.max(distance * 10, 100);
    }
}

class SedanCab extends Cab {

    public SedanCab(double distance, String time) {
        super(distance, time);
    }

    public double calculateFare() {
        double fare = Math.max(distance * 14, 100);

        if (time.equals("NIGHT")) {
            fare = fare * 1.20;
        }

        return fare;
    }
}

class SUVCab extends Cab {

    public SUVCab(double distance, String time) {
        super(distance, time);
    }

    public double calculateFare() {
        double fare = Math.max(distance * 18, 100);

        if (time.equals("NIGHT")) {
            fare = fare * 1.20;
        }

        return fare;
    }
}

public class CityCabFareMeter {

    public static Cab createCab(String type, double distance, String time) {

        switch (type) {
            case "MINI":
                return new MiniCab(distance, time);

            case "SEDAN":
                return new SedanCab(distance, time);

            case "SUV":
                return new SUVCab(distance, time);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalFare = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();
            String time = sc.next();

            Cab cab = createCab(type, distance, time);

            double fare = cab.calculateFare();

            if (fare == -1) {
                System.out.printf(
                        "%s %.2f %s: REJECTED%n",
                        type, distance, time
                );
            } else {
                System.out.printf(
                        "%s %.2f %s: %.2f%n",
                        type, distance, time, fare
                );

                totalFare += fare;
            }
        }

        System.out.printf("Total Fare: %.2f%n", totalFare);

        sc.close();
    }
}