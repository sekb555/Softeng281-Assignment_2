package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** A factory class that helps set the difficulty of the AI. */
public class DiffFactory {

  /**
   * Creates a new DiffInterface for the AI to use to determine which difficulty to use based on
   * player input.
   *
   * @param diffType the difficulty type that the player has chosen
   * @param roundNum the currnt round number of the current game
   * @param lastWinner the last winner of the game
   * @param strategy the current strategy that the AI is using that the player has chosen
   * @param sum the sum that keeps track of the evens and odds of the player
   * @param choice the choice that the player has chosen to determine what wins the round
   * @return returns the difficulty type that the player has chosen
   */
  public DiffInterface createDiff(
      String diffType, int roundNum, String lastWinner, Strategy strategy, int sum, Choice choice) {

    // checks the difficulty type and returns the appropriate difficulty
    if (diffType.equalsIgnoreCase("Easy")) {
      return new EasyDiff();
    } else if (diffType.equalsIgnoreCase("Medium")) {
      return new MedDiff(roundNum, sum, choice);
    } else if (diffType.equalsIgnoreCase("Hard")) {
      return new HardDiff(roundNum, lastWinner, strategy, sum, choice);
    } else {
      return null;
    }
  }
}
