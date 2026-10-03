import java.util.Scanner;

abstract class Ticket {
    protected int quantity;

    public Ticket(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateAmount();
}

class RegularTicket extends Ticket {

    public RegularTicket(int quantity) {
        super(quantity);
    }

    public double calculateAmount() {
        return quantity * 150;
    }
}

class PremiumTicket extends Ticket {

    public PremiumTicket(int quantity) {
        super(quantity);
    }

    public double calculateAmount() {
        return quantity * 250;
    }
}

class ReclinerTicket extends Ticket {

    public ReclinerTicket(int quantity) {
        super(quantity);
    }

    public double calculateAmount() {
        return quantity * 400;
    }
}

public class MovieTicketCounter {

    public static Ticket createTicket(String type, int quantity) {

        switch (type) {
            case "REGULAR":
                return new RegularTicket(quantity);

            case "PREMIUM":
                return new PremiumTicket(quantity);

            case "RECLINER":
                return new ReclinerTicket(quantity);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int quantity = sc.nextInt();

            Ticket ticket = createTicket(type, quantity);

            double seatAmount = ticket.calculateAmount();
            double convenienceFee = quantity * 20;
            double ticketTotal = seatAmount + convenienceFee;

            System.out.printf("%s: %.2f%n",
                    type, ticketTotal);

            total += ticketTotal;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}