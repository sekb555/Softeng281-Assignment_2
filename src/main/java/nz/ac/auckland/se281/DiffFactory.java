package nz.ac.auckland.se281;

public class DiffFactory {

  /**
   * Creates a new DiffInterface for the AI to use to determine which difficulty to use.
   *
   * @param diffType
   * @param roundNum
   * @param lastWinner
   * @return
   */
  public DiffInterface createDiff(String diffType, int roundNum, String lastWinner) {

    if (diffType.equalsIgnoreCase("Easy")) {
      return new EasyDiff();
    } else if (diffType.equalsIgnoreCase("Medium")) {
      return new MedDiff(roundNum);
    } else if (diffType.equalsIgnoreCase("Hard")) {
      return new HardDiff(roundNum, lastWinner);
    } else {
      return null;
    }
  }
}
