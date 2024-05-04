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
  private int playerWins;
  private int compWins;
  private int gameState = 0;

  /**
   * Starts a new game. This method initializes the game variables and allows gameplay to begin.
   *
   * @param difficulty The difficulty of the game which is chosen by the player.
   * @param choice choice that the player makes to determine what wins the round.
   * @param options allows the player to input their name.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // initializes game variables and sets logic set by player
    roundNum = 0;
    lastWinner = null;
    playerWins = 0;
    compWins = 0;
    this.playerName = options[0];
    this.choice = choice;
    diffString = difficulty.toString();
    TopStategy.clear();
    new TopStategy().setChoice(choice);
    gameState = 1;

    // prints welcome message to the player
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  /**
   * Plays a round of the game. using the player's input and the AI's input to determine the winner.
   */
  public void play() {
    roundNum += 1;
    // checks if the game has started or not
    if (gameState == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // creates a new dificulty object based on the player's choice
    diffType = new DiffFactory().createDiff(diffString, roundNum, lastWinner);
    String playerFingers = "-1";
    String computerFingers = diffType.getFingers();
    int roundTotal;

    // prints the round number
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNum));
    // asks the player for their game input
    while (playerFingers.equals("-1")) {
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      // checks if the input is valid if not prints an error message and if so prints the proper
      // information
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
   * Assists in determining the winner of the round. By checking if the sum favours the player or
   * the AI.
   *
   * @param sum The sum of the player and AI's inputs to determine the winner. based on the player's
   *     choice at the start of the game
   */
  public void findWinner(int sum) {
    // checks if the sum is odd or even and determines the winner of the round
    if (choice == Choice.ODD) {
      if (Utils.isOdd(sum)) {
        lastWinner = "Player";
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
      } else {
        lastWinner = "Computer";
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", computerName);
      }
    } else if (choice == Choice.EVEN) {
      if (Utils.isEven(sum)) {
        lastWinner = "Player";
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
      } else {
        lastWinner = "Computer";
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", computerName);
      }
    }

    // updates the number of times the player or the computer has won depending on the winner of the
    // round
    if (lastWinner.equals("Player")) {
      playerWins++;
    } else if (lastWinner.equals("Computer")) {
      compWins++;
    }
  }

  /**
   * Ends the game and prints the winner and the stats of the game that was just played such as the
   * number of rounds won by each player.
   */
  public void endGame() {
    // intializes the winnerTally variable to determine the winner of the full game
    int winnerTally = playerWins - compWins;

    // prints the stats of the game
    showStats();

    // prints the winner of the game
    if (winnerTally < 0) {
      MessageCli.PRINT_END_GAME.printMessage(computerName);
    } else if (winnerTally > 0) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // sets the game state to the end value
    gameState = 0;
  }

  /**
   * Shows the stats of the current game. If the game has not started yet, it will print an error
   * message.
   */
  public void showStats() {
    // prints the stats of the game
    if (gameState == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    } else if (gameState == 1) {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName, String.valueOf(playerWins), String.valueOf(compWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          computerName, String.valueOf(compWins), String.valueOf(playerWins));
    }
  }
}
