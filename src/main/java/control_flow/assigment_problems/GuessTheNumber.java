public class GuessTheNumber {
    public static void main(String[] args) {

        int secretNumber = 42;
        int maxTries = 4;

        int[] guesses = {20, 60, 42};

        int tries = 0;

        while (tries < maxTries) {

            int guess = guesses[tries];
            tries++;

            if (guess > secretNumber) {
                System.out.println("Too high");
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                break;
            }
        }

        if (tries == maxTries) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }
}