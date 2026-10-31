import java.util.Scanner;

public class PrizeTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prizes = new int[n];

        for (int i = 0; i < n; i++) {
            prizes[i] = sc.nextInt();
        }

        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (prizes[j] > prizes[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = prizes[i];
                prizes[i] = prizes[maxIndex];
                prizes[maxIndex] = temp;
                swaps++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(prizes[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println(swaps);

        sc.close();
    }
}