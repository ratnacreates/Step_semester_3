import java.util.Scanner;

abstract class Appliance {
    protected double hours;
    protected boolean saverMode;

    public Appliance(double hours, boolean saverMode) {
        this.hours = hours;
        this.saverMode = saverMode;
    }

    public abstract double getPower();

    public abstract boolean supportsSaver();

    public double calculateUnits() {
        double units = (getPower() * hours) / 1000;

        if (saverMode && supportsSaver()) {
            units = units * 0.75;
        }

        return units;
    }

    public double calculateCost() {
        return calculateUnits() * 8;
    }
}

class Fridge extends Appliance {

    public Fridge(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    public double getPower() {
        return 150;
    }

    public boolean supportsSaver() {
        return false;
    }
}

class AC extends Appliance {

    public AC(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    public double getPower() {
        return 1500;
    }

    public boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {

    public TV(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    public double getPower() {
        return 100;
    }

    public boolean supportsSaver() {
        return false;
    }
}

class Washer extends Appliance {

    public Washer(double hours, boolean saverMode) {
        super(hours, saverMode);
    }

    public double getPower() {
        return 500;
    }

    public boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {

    public static Appliance createAppliance(String type,
                                            double hours,
                                            boolean saverMode) {

        switch (type) {
            case "FRIDGE":
                return new Fridge(hours, saverMode);

            case "AC":
                return new AC(hours, saverMode);

            case "TV":
                return new TV(hours, saverMode);

            case "WASHER":
                return new Washer(hours, saverMode);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");

            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);

            boolean saverMode =
                    parts.length > 2 && parts[2].equals("SAVER");

            Appliance appliance =
                    createAppliance(type, hours, saverMode);

            double units = appliance.calculateUnits();
            double cost = appliance.calculateCost();

            if (saverMode && !appliance.supportsSaver()) {

                System.out.printf(
                        "%s: Saver mode not supported%n",
                        type
                );

            }

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}