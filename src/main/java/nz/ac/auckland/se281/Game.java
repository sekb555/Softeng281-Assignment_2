package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private String playerName;
  private String computerName = "HAL-9000";
  protected Choice choice;
  protected Difficulty difficulty;
  private int roundNum;
  private RandomStrategy randomStrategy = new RandomStrategy();

  /**
   * Starts a new game with the given parameters.
   * 
   * @param difficulty
   * @param choice
   * @param options
   */

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    this.playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.choice = choice;
    this.difficulty = difficulty;
    this.roundNum = 0;
  }

  /**
   * Plays a round of the game.
   * 
   */
  public void play() {

    String playerFingers = "-1";
    String computerFingers = randomStrategy.selectFingers();

    roundNum += 1;

    MessageCli.START_ROUND.printMessage(String.valueOf(roundNum));
    while (playerFingers.equals("-1")) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      if (!Utils.isInteger(input) || Integer.parseInt(input) > 5 || Integer.parseInt(input) < 0) {
        MessageCli.INVALID_INPUT.printMessage();
      } else {
        playerFingers = input;
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerFingers);
        MessageCli.PRINT_INFO_HAND.printMessage(computerName, computerFingers);
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
