import java.util.Scanner;

public class DiceThrowTally {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] counts = new int[7];

        for (int i = 0; i < n; i++) {
            int face = sc.nextInt();
            counts[face]++;
        }

        boolean first = true;

        for (int face = 1; face <= 6; face++) {
            for (int i = 0; i < counts[face]; i++) {
                if (!first) {
                    System.out.print(" ");
                }

                System.out.print(face);
                first = false;
            }
        }

        System.out.println();
        sc.close();
    }
}