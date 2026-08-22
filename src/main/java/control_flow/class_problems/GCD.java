import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int gcd = 1;

        int limit;

        if (a < b) {
            limit = a;
        } else {
            limit = b;
        }

        for (int i = 1; i <= limit; i++) {

            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        System.out.println("GCD = " + gcd);

        sc.close();
    }
}