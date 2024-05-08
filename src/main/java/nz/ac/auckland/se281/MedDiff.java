package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * A medium difficulty for the AI. This difficulty uses the random strategy for the first 3 rounds
 * and then switches to the top strategy.
 */
public class MedDiff implements DiffInterface {

  private int roundNum;
  private int sum;
  private Choice choice;

  /**
   * Constructor for the medium difficulty of the AI for the player to play againest.
   *
   * @param roundNum gets the round number to determine when to switch to the top strategy
   * @param sum the sum that keeps track of the evens and odds of the player
   * @param choice the choice that the player has chosen to determine what wins the round
   */
  public MedDiff(int roundNum, int sum, Choice choice) {
    this.roundNum = roundNum;
    this.sum = sum;
    this.choice = choice;
  }

  /**
   * Gets the AI input for the medium difficulty. uses the round number to switch to the top
   * strategy after the 3rd round
   */
  @Override
  public String getFingers() {
    // initializes the top and random strategies and asssigns them short names to make them easier
    // to use
    TopStategy top = new TopStategy(sum, choice);
    RandomStrategy rand = new RandomStrategy();
    // code for switching to top strategy after the 3rd round
    if (roundNum <= 3) {
      return rand.selectFingers();
    } else {
      return top.selectFingers();
    }
  }

  /** Gets the current strategy that the AI is using. */
  @Override
  public Strategy getStrategy() {
    return null;
  }
}
