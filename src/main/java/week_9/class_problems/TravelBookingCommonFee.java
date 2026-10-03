import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;

    public TravelBooking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class BusBooking extends TravelBooking {

    public BusBooking(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return distance * 2;
    }
}

class TrainBooking extends TravelBooking {

    public TrainBooking(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBooking {

    public FlightBooking(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return 2500 + (distance * 4);
    }
}

public class TravelBookingCommonFee {

    public static TravelBooking createBooking(String type, double distance) {

        switch (type) {
            case "BUS":
                return new BusBooking(distance);

            case "TRAIN":
                return new TrainBooking(distance);

            case "FLIGHT":
                return new FlightBooking(distance);

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

            TravelBooking booking =
                    createBooking(type, distance);

            double fare = booking.calculateFare();

            System.out.printf("%s: %.2f%n",
                    type, fare);

            totalFare += fare;
        }

        double commonFee = n * 50;
        totalFare += commonFee;

        System.out.printf("Common Fee: %.2f%n", commonFee);
        System.out.printf("Total Fare: %.2f%n", totalFare);

        sc.close();
    }
}