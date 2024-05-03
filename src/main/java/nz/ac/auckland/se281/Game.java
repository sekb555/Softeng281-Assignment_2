package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  protected String playerName;
  protected Choice choice;
  protected Difficulty difficulty;
  protected int noOfGames = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    this.playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.choice = choice;
    this.difficulty = difficulty;
    noOfGames += 1;

  }

  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(noOfGames));
    MessageCli.ASK_INPUT.printMessage();
    String playerFingers = Utils.scanner.nextLine();
    if (!Utils.isInteger(playerFingers) || Integer.parseInt(playerFingers) > 5){
      MessageCli.INVALID_INPUT.printMessage();
      return;
    }
  }

  public void endGame() {}

  public void showStats() {}
}
