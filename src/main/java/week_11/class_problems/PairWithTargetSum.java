import java.util.HashMap;
import java.util.Scanner;

public class PairWithTargetSum {

    public static boolean hasPair(int[] numbers, int target) {
        HashMap<Integer, Boolean> seen = new HashMap<>();

        for (int number : numbers) {
            int complement = target - number;

            if (seen.containsKey(complement)) {
                return true;
            }

            seen.put(number, true);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(hasPair(numbers, target));

        sc.close();
    }
}