package nz.ac.auckland.se281;

public class HardDiff implements DiffInterface {

  private int roundNum;
  private String lastWinner;
  private TopStategy top = new TopStategy();
  private RandomStrategy rand = new RandomStrategy();

  /**
   * Constructor for the hard difficulty.
   *
   * @param roundNum
   * @param lastWinner
   */
  public HardDiff(int roundNum, String lastWinner) {
    this.roundNum = roundNum;
    this.lastWinner = lastWinner;
  }

  /** Gets the AI input for the hard difficulty. */
  @Override
  public String getFingers() {
    Strategy current = rand;
    if (roundNum < 3) {
      current = rand;
    } else {
      switch (lastWinner) {
        case ("P"):
          if (current == top) {
            current = rand;
          } else if (current == rand) {
            current = top;
          }
      }
    }
    return current.selectFingers();
  }
}
