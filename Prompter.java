import java.util.Scanner;

public class Prompter {
  private Game game;
  
  public Prompter(Game game){
    this.game = game;
  }
  
  public boolean promptForGuess() {
    Scanner scanner = new Scanner(System.in);
    boolean isHit  = false;
    boolean isAcceptable = false;
    do {
      System.out.print("Enter a letter:  ");
      String guessInput = scanner.nextLine();
      char guess = guessInput.charAt(0);
    
      try { 
        isHit = game.applyGuess(guess);
        isAcceptable = true;
      }  catch (IllegalArgumentException iae){
        System.out.println(iae.getMessage());
      }
    } while(!isAcceptable);
    
    return isHit;
  }
  
  public void displayProgress(){
    System.out.printf("You have %d trial left. Try to solve: %s %n", game.getMissCount(), game.getCurrentProgress());
  }

  public void displayOutcome() {
    if (game.isWon()) {
      System.out.printf("Congratulations!! you won with %d attempts remaining %n", game.getMissCount());
    } else {
      System.out.printf("Sorry you lose. The word was %s. %n", game.getAnswer());
    }
  }
}
