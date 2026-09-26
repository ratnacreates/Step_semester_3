import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getBorrowingDays());
    }

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {

    public Book(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {

    public DVD(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 3;
    }
}

public class LibraryItemDueDateCalculator {

    public static LibraryItem createItem(String type, String title) {

        switch (type) {
            case "BOOK":
                return new Book(title);

            case "DVD":
                return new DVD(title);

            case "MAGAZINE":
                return new Magazine(title);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.nextLine().trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item = createItem(type, title);

            System.out.println(item.getTitle() + ": " + item.getDueDate());
        }

        sc.close();
    }
}