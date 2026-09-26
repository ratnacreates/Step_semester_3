import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class SingleRoom extends Room {

    public SingleRoom(int units) {
        super(units);
    }

    public double calculateBill() {
        return units * 8;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6) / (double) occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {

    public ACRoom(int units) {
        super(units);
    }

    public double calculateBill() {
        return (units * 10) + 200;
    }

    public String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {

    public static Room createRoom(String type, int units, int occupants) {

        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);

            case "SHARED":
                return new SharedRoom(units, occupants);

            case "AC":
                return new ACRoom(units);

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
            int units = sc.nextInt();

            int occupants = 1;

            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            Room room = createRoom(type, units, occupants);

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n",
                    room.getType(), bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}