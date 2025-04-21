public class User {
    private String name;
    private int attempts;
    private int score;

    public User() {
        this.attempts = 0;
        this.score = 100; // Initial score
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttempts() {
        return attempts;
    }

    public void incrementAttempts() {
        this.attempts++;
        if (this.attempts > 1) {
            this.score -= 10; // Deduct points for each incorrect attempt after the first
            if (this.score < 0) {
                this.score = 0; // Ensure score doesn't go below zero
            }
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}