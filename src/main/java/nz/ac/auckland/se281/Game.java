package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private String playerName;
  private String computerName = "HAL-9000";
  private Choice choice;
  private String diffString;
  private int roundNum;
  private DiffInterface diffType;
  private String lastWinner;
  private int winnerTally;
  private int gameState;

  /**
   * Starts a new game.
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
    diffString = difficulty.toString();

    this.roundNum = 0;

    lastWinner = null;
    TopStategy.clear();
    new TopStategy().setChoice(choice);
    this.gameState = 1;
  }

  /** Plays a round of the game. */
  public void play() {
    if (gameState == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    roundNum += 1;
    diffType = new DiffFactory().createDiff(diffString, roundNum, lastWinner);
    String playerFingers = "-1";
    String computerFingers = diffType.getFingers();
    int roundTotal;

    MessageCli.START_ROUND.printMessage(String.valueOf(roundNum));
    while (playerFingers.equals("-1")) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      if (!Utils.isInteger(input) || Integer.parseInt(input) > 5 || Integer.parseInt(input) < 0) {
        MessageCli.INVALID_INPUT.printMessage();
      } else {
        playerFingers = input;
        MessageCli.PRINT_INFO_HAND.printMessage(playerName, playerFingers);
        TopStategy.addFingers(Integer.parseInt(playerFingers));

        MessageCli.PRINT_INFO_HAND.printMessage(computerName, computerFingers);
        roundTotal = Integer.parseInt(playerFingers) + Integer.parseInt(computerFingers);
        findWinner(roundTotal);
      }
    }
  }

  /**
   * Determines the winner of the round.
   *
   * @param sum
   */
  public void findWinner(int sum) {
    if (choice == Choice.ODD) {
      if (Utils.isOdd(sum)) {
        lastWinner = "P";
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
      } else {
        lastWinner = "C";
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", computerName);
      }
    } else if (choice == Choice.EVEN) {
      if (Utils.isEven(sum)) {
        lastWinner = "P";
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
      } else {
        lastWinner = "C";
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", computerName);
      }
    }

    if (lastWinner.equals("P")) {
      winnerTally += 1;
    } else if (lastWinner.equals("C")) {
      winnerTally -= 1;
    }
  }

  public void endGame() {
    if (winnerTally < 0) {
      MessageCli.PRINT_END_GAME.printMessage(computerName);
    } else if (winnerTally > 0) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
    gameState = 0;
  }

  public void showStats() {}
}
