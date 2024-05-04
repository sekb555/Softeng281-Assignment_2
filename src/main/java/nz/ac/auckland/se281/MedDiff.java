package nz.ac.auckland.se281;

public class MedDiff implements DiffInterface {

  private int roundNum;

  /**
   * Constructor for the medium difficulty.
   *
   * @param roundNum
   */
  public MedDiff(int roundNum) {
    this.roundNum = roundNum;
  }

  /** Gets the AI input for the medium difficulty. */
  @Override
  public String getFingers() {
    TopStategy top = new TopStategy();
    RandomStrategy rand = new RandomStrategy();
    if (roundNum < 3) {
      return rand.selectFingers();
    } else {
      return top.selectFingers();
    }
  }
}
