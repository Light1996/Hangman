package client;

public class Reader implements java.io.Serializable {

    public Integer tries;
    public String guess;
    public String message;

    public Reader(String level, String word) {
        System.out.println("Level is:" + level);
        switch (level) {
            case "Easy":
                this.tries = 20;
                break;
            case "Medium":
                this.tries = 15;
                break;
            case "Hard":
                this.tries = 10;
                break;
            case "Veteran":
                this.tries = 5;
                break;
            default:
                this.tries = 15;
                break;
        }
        this.guess = word;
        this.message = "Welcome to the Hangman game! Guess a letter or the word";
    }

    public void setWord(String str) {
        this.guess = str;
    }

    public void disincrementCounter() {
        this.tries--;
    }

    public void setLooseMessage() {
        this.message = "Sorry, you lost the game!";
    }

    public String getMessage() {
        return this.message;
    }

    public void setInvalidTryMessage(String l) {
        this.message = "You have already tried letter " + l + " . Try another letter of the alphabet";
    }

    public void setCongratsMessage() {
        this.message = "Congratulations! You won the server!";
    }

    public void setRetryMessage(String reply) {
        this.message = "Letter " + reply + " is not contained. Sorry";
    }

    public void setFoundMessage() {
        this.message = "Good job! You found a letter!";
    }

    public void setCounter(Integer attempts) {
        this.tries = attempts;
    }

    public Integer getCounter() {
        return this.tries;
    }

    public String getWord() {
        return this.guess;
    }

    public void setscoresMessage(int c, int s) {
        this.message = "Client is: " + c + "\n Server: " + s;
    }

}
