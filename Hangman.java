public class Hangman {

  public static void main(String[] args) {
    // Your incredible code goes here...
    Game game = new Game("Nikhil");
    
    Prompter prompter = new Prompter(game);
    
    
    while(game.getMissCount() > 0){
      prompter.displayProgress();
      prompter.promptForGuess();
    }
  }
}
