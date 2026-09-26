import java.util.Scanner;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends Employee {

    public Intern(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    public double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {

    public static Employee createEmployee(String type, String name,
                                          double salary) {

        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);

            case "PARTTIME":
                return new PartTimeEmployee(name, salary);

            case "INTERN":
                return new Intern(name, salary);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee = createEmployee(type, name, salary);

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n",
                    employee.getName(), bonus);

            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}