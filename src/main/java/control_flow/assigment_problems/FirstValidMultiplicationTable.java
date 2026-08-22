public class FirstValidMultiplicationTable {
    public static void main(String[] args) {

        int[] candidates = {-3, 0, 7, 9};

        for (int number : candidates) {

            if (number <= 0) {
                System.out.println("Skipping invalid number: " + number);
                continue;
            }

            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }

            break;
        }
    }
}
