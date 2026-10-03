import java.util.Scanner;

abstract class Connection {
    protected double units;

    public Connection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class HomeConnection extends Connection {

    public HomeConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else {
            return (100 * 5) + ((units - 100) * 7);
        }
    }
}

class ShopConnection extends Connection {

    public ShopConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        return (units * 8) + 100;
    }
}

class FactoryConnection extends Connection {

    public FactoryConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {

    public static Connection createConnection(String type, double units) {

        switch (type) {
            case "HOME":
                return new HomeConnection(units);

            case "SHOP":
                return new ShopConnection(units);

            case "FACTORY":
                return new FactoryConnection(units);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBill = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            Connection connection =
                    createConnection(type, units);

            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n",
                    type, bill);

            totalBill += bill;
        }

        System.out.printf("Total Bill: %.2f%n", totalBill);

        sc.close();
    }
}