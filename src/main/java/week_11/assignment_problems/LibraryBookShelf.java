import java.util.Scanner;

public class LibraryBookShelf {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] books = new int[n];

        for (int i = 0; i < n; i++) {
            books[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = key;

            for (int k = 0; k < n; k++) {
                System.out.print(books[k]);
                if (k < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}