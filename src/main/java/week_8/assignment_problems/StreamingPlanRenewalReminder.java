import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {

    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {

    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {

    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {

    public static SubscriptionPlan createPlan(
            String type, String name, LocalDate startDate) {

        switch (type) {
            case "BASIC":
                return new BasicPlan(name, startDate);

            case "STANDARD":
                return new StandardPlan(name, startDate);

            case "PREMIUM":
                return new PremiumPlan(name, startDate);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan =
                    createPlan(type, name, startDate);

            System.out.println(
                    plan.getName() + ": " +
                    plan.getRenewalDate()
            );
        }

        sc.close();
    }
}