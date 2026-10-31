import java.util.Scanner;

public class LibraryCatalogLookup {

    public static String findBook(String[] isbns, String[] titles, String targetIsbn) {
        int left = 0;
        int right = isbns.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int comparison = isbns[mid].compareTo(targetIsbn);

            if (comparison == 0) {
                return titles[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] isbns = new String[n];
        String[] titles = new String[n];

        for (int i = 0; i < n; i++) {
            isbns[i] = sc.next();
            titles[i] = sc.nextLine().trim();
        }

        String targetIsbn = sc.next();

        System.out.println(findBook(isbns, titles, targetIsbn));

        sc.close();
    }
}