import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {

    public static Staff createStaff(String type, String name,
                                    double value1, double value2) {

        switch (type) {
            case "FULLTIME":
                return new FullTimeStaff(name, value1);

            case "HOURLY":
                return new HourlyStaff(name, value1, value2);

            case "INTERN":
                return new InternStaff(name, value1);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalPay = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            double value1 = sc.nextDouble();
            double value2 = 0;

            if (type.equals("HOURLY")) {
                value2 = sc.nextDouble();
            }

            Staff staff = createStaff(
                    type, name, value1, value2
            );

            double pay = staff.calculatePay();

            System.out.printf("%s: %.2f%n",
                    staff.getName(), pay);

            totalPay += pay;
        }

        System.out.printf("Total Pay: %.2f%n", totalPay);

        sc.close();
    }
}