package nz.ac.auckland.se281;

/** A easy difficulty for the AI. This difficulty uses the random strategy to send an input. */
public class EasyDiff implements DiffInterface {

  /**
   * Gets the input for the easy difficulty of the AI. This method only uses the random strategy to
   * send an input.
   */
  @Override
  public String getFingers() {
    return new RandomStrategy().selectFingers();
  }

  /** Gets the current strategy that the AI is using. */
  @Override
  public Strategy getStrategy() {
    return null;
  }
}
