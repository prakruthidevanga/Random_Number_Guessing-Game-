import java.util.Random;
import java.util.Scanner;

public class Start {
    private final int secretNumber;
    private final User user;
    private final Input inputHandler;
    private final Scroll guessHistory;
    private final Check checker;
    private final Exit gameExiter;

    public Start() {
        Random random = new Random();
        this.secretNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        this.user = new User();
        this.inputHandler = new Input();
        this.guessHistory = new Scroll();
        this.checker = new Check(secretNumber);
        this.gameExiter = new Exit();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Random Guessing Game!");
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        user.setName(playerName);
        System.out.println("Hello, " + user.getName() + "! Try to guess the number between 1 and 100.");

        int guess;
        do {
            guess = inputHandler.getUserGuess(scanner);
            user.incrementAttempts();
            guessHistory.addGuess(guess);

            String result = checker.checkGuess(guess);
            System.out.println(result);
            guessHistory.displayHistory();

            if (result.equals("Congratulations! You guessed the correct number.")) {
                System.out.println("You guessed it in " + user.getAttempts() + " attempts.");
                System.out.println("Your final score is: " + user.getScore());
                break;
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                gameExiter.exitGame();
                break;
            }

        } while (true);

        scanner.close();
    }

    public static void main(String[] args) {
        Start game = new Start();
        game.playGame();
    }
}