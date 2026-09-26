import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();

    public abstract String getType();
}

class Bike extends Vehicle {

    public Bike(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        return hours * 10;
    }

    public String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {

    public Car(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        return 30 + ((hours - 1) * 20);
    }

    public String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {

    public Truck(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        return Math.max(hours * 50, 100);
    }

    public String getType() {
        return "TRUCK";
    }
}

public class CampusParkingChargeCalculator {

    public static Vehicle createVehicle(String type, int hours) {

        switch (type) {
            case "BIKE":
                return new Bike(hours);

            case "CAR":
                return new Car(hours);

            case "TRUCK":
                return new Truck(hours);

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
            int hours = sc.nextInt();

            Vehicle vehicle = createVehicle(type, hours);

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n",
                    vehicle.getType(), charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}