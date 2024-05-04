package nz.ac.auckland.se281;

/**
 * A medium difficulty for the AI. This difficulty uses the random strategy for the first 3 rounds
 * and then switches to the top strategy.
 */
public class MedDiff implements DiffInterface {

  private int roundNum;

  /**
   * Constructor for the medium difficulty.
   *
   * @param roundNum gets the round number to determine when to switch to the top strategy
   */
  public MedDiff(int roundNum) {
    this.roundNum = roundNum;
  }

  /**
   * Gets the AI input for the medium difficulty. uses the round number to switch to the top
   * strategy after the 3rd round
   */
  @Override
  public String getFingers() {
    // initializes the top and random strategies and asssigns them short names to make them easier
    // to use
    TopStategy top = new TopStategy();
    RandomStrategy rand = new RandomStrategy();
    // code for switching to top strategy after the 3rd round
    if (roundNum <= 3) {
      return rand.selectFingers();
    } else {
      return top.selectFingers();
    }
  }
}
