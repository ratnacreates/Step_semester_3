import java.util.Scanner;

public class HeightLineUp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            for (int k = 0; k < n; k++) {
                System.out.print(heights[k]);
                if (k < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            if (!swapped) {
                break;
            }
        }

        sc.close();
    }
}