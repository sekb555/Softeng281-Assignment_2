package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * A hard difficulty for the AI. This difficulty uses the random strategy for the first 3 rounds and
 * then switches between the random and top strategy depending on the winner of the last round.
 */
public class HardDiff implements DiffInterface {

  private int roundNum;
  private String lastWinner;
  private TopStategy top;
  private RandomStrategy rand = new RandomStrategy();
  private Strategy current;

  /**
   * Constructor for the hard difficulty. to get the current round number and the last winner of the
   * game to determine which strategy to use
   *
   * @param roundNum gets the current round number
   * @param lastWinner gets the last winner of the round to determine which strategy to use
   * @param strategy the current strategy that the AI is using that the player has chosen
   * @param sum the sum that keeps track of the evens and odds of the player
   * @param choice the choice that the player has chosen to determine what wins the round
   */
  public HardDiff(int roundNum, String lastWinner, Strategy strategy, int sum, Choice choice) {
    top = new TopStategy(sum, choice);
    this.roundNum = roundNum;
    this.lastWinner = lastWinner;

    if (strategy == null) {
      this.current = rand;
    } else if (strategy instanceof RandomStrategy) {
      this.current = rand;
    } else if (strategy instanceof TopStategy) {
      this.current = top;
    }
  }

  /**
   * gets the input for the hard difficulty of the AI. It works by using the random strategy for the
   * first 3 rounds and then switched between the random and the top strategy depending on the
   * winner of the last round
   */
  @Override
  public String getFingers() {
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

  /** Gets the current strategy that the AI is using. */
  @Override
  public Strategy getStrategy() {
    return current;
  }
}
