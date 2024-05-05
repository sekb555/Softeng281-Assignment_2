package nz.ac.auckland.se281;

/** A factory class that helps set the difficulty of the AI. */
public class DiffFactory {

  /**
   * Creates a new DiffInterface for the AI to use to determine which difficulty to use based on
   * player input.
   *
   * @param diffType the difficulty type that the player has chosen
   * @param roundNum the currnt round number of the current game
   * @param lastWinner the last winner of the game
   * @return returns the difficulty type that the player has chosen
   */
  public DiffInterface createDiff(
      String diffType, int roundNum, String lastWinner, Strategy strategy) {

    // checks the difficulty type and returns the appropriate difficulty
    if (diffType.equalsIgnoreCase("Easy")) {
      return new EasyDiff();
    } else if (diffType.equalsIgnoreCase("Medium")) {
      return new MedDiff(roundNum);
    } else if (diffType.equalsIgnoreCase("Hard")) {
      return new HardDiff(roundNum, lastWinner, strategy);
    } else {
      return null;
    }
  }
}
