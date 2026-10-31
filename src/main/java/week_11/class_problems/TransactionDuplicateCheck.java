import java.util.HashSet;
import java.util.Scanner;

public class TransactionDuplicateCheck {

    public static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seen = new HashSet<>();

        for (String id : transactionIds) {
            if (seen.contains(id)) {
                return true;
            }

            seen.add(id);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] transactionIds = new String[n];

        for (int i = 0; i < n; i++) {
            transactionIds[i] = sc.next();
        }

        System.out.println(hasDuplicate(transactionIds));

        sc.close();
    }
}