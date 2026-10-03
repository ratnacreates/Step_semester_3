import java.util.Scanner;

abstract class StudentFee {
    protected String name;

    public StudentFee(String name) {
        this.name = name;
    }

    public abstract double calculateFee();

    public String getName() {
        return name;
    }
}

class DayScholar extends StudentFee {

    public DayScholar(String name) {
        super(name);
    }

    public double calculateFee() {
        return 40000 + 12000;
    }
}

class Hosteller extends StudentFee {

    public Hosteller(String name) {
        super(name);
    }

    public double calculateFee() {
        return 40000 + 60000;
    }
}

class Scholar extends StudentFee {

    public Scholar(String name) {
        super(name);
    }

    public double calculateFee() {
        return 20000 + 12000;
    }
}

public class CollegeFeeCounter {

    public static StudentFee createStudent(String type, String name) {

        switch (type) {
            case "DAY_SCHOLAR":
                return new DayScholar(name);

            case "HOSTELLER":
                return new Hosteller(name);

            case "SCHOLAR":
                return new Scholar(name);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalFee = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            StudentFee student =
                    createStudent(type, name);

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n",
                    student.getName(), fee);

            totalFee += fee;
        }

        System.out.printf("Total Fee: %.2f%n", totalFee);

        sc.close();
    }
}