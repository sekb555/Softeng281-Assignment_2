package nz.ac.auckland.se281;

/**
 * A class to set the strategy for the AI to use. and change during gameplay depending on the
 * difficulty
 */
public class DiffStrategy {
  private Strategy strategy;

  /**
   * Sets the strategy for the AI to use
   *
   * @param strategy which strategy to use and this is the value that is set
   */
  public void SetStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /** Gets the current strategy that the AI is using */
  public Strategy getStrategy() {
    return strategy;
  }
}
