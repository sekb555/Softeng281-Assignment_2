package nz.ac.auckland.se281;

public class HardDiff implements DiffInterface {

  private int roundNum;
  private String lastWinner;
  private TopStategy top = new TopStategy();
  private RandomStrategy rand = new RandomStrategy();

  /**
   * Constructor for the hard difficulty. to get the current round number and the last winner of the
   * game to determine which strategy to use
   *
   * @param roundNum gets the current round number
   * @param lastWinner gets the last winner of the round to determine which strategy to use
   */
  public HardDiff(int roundNum, String lastWinner) {
    this.roundNum = roundNum;
    this.lastWinner = lastWinner;
  }

  /**
   * gets the input for the hard difficulty of the AI. It works by using the random strategy for the
   * first 3 rounds and then switched between the random and the top strategy depending on the
   * winner of the last round
   */
  @Override
  public String getFingers() {
    // initialize the current strategy to random
    Strategy current = rand;
    // uses random strategy for the first 3 rounds and swtiches between top and random strategy
    // depending on if the player or the computer won the last round
    if (roundNum <= 3) {
      current = rand;
    } else {
      switch (lastWinner) {
        case ("Player"):
          if (current == top) {
            current = rand;
          } else if (current == rand) {
            current = top;
          }
      }
    }
    // returns the selected fingers based on the currently selected strategy
    return current.selectFingers();
  }
}
