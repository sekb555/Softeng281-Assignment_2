package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  protected String playerName;
  protected Choice choice;
  protected Difficulty difficulty;
  protected int roundNum = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    this.playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.choice = choice;
    this.difficulty = difficulty;
  }

  public void play() {
    roundNum += 1;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNum));
    String playerFingers = "-1";
    while (playerFingers.equals("-1")) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      if (!Utils.isInteger(input) || Integer.parseInt(input) > 5 || Integer.parseInt(input) < 0) {
        MessageCli.INVALID_INPUT.printMessage();
      } else {
        playerFingers = input;
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerFingers);
      }
    }

  }

  public void endGame() {}

  public void showStats() {}
}
