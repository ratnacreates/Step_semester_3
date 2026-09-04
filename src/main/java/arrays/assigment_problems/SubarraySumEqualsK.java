import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {

            currentSum = currentSum + nums[i];

            int requiredSum = currentSum - k;

            if (map.containsKey(requiredSum)) {
                count = count + map.get(requiredSum);
            }

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        System.out.println("Number of subarrays: " + count);

        sc.close();
    }
}
