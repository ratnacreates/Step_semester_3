import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();

    public abstract String getShape();

    public String getOwner() {
        return owner;
    }
}

class Circle extends Plot {
    private double radius;

    public Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    private double length;
    private double width;

    public Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    private double base;
    private double height;

    public Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

    public String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {

    public static Plot createPlot(String shape, String owner,
                                  double value1, double value2) {

        switch (shape) {
            case "CIRCLE":
                return new Circle(owner, value1);

            case "RECTANGLE":
                return new Rectangle(owner, value1, value2);

            case "TRIANGLE":
                return new Triangle(owner, value1, value2);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {

            String shape = sc.next();
            String owner = sc.next();

            double value1 = sc.nextDouble();
            double value2 = 0;

            if (shape.equals("RECTANGLE") || shape.equals("TRIANGLE")) {
                value2 = sc.nextDouble();
            }

            Plot plot = createPlot(
                    shape, owner, value1, value2
            );

            double area = plot.calculateArea();

            System.out.printf("%s (%s): %.2f%n",
                    plot.getOwner(),
                    plot.getShape(),
                    area);

            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);

        sc.close();
    }
}