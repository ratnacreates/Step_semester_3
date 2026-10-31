import java.util.Scanner;

public class IsTheQueueInOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] queue = new int[n];

        for (int i = 0; i < n; i++) {
            queue[i] = sc.nextInt();
        }

        int result = -1;

        for (int i = 1; i < n; i++) {
            if (queue[i] < queue[i - 1]) {
                result = i;
                break;
            }
        }

        System.out.println(result);

        sc.close();
    }
}