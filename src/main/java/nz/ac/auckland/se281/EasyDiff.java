package nz.ac.auckland.se281;

public class EasyDiff implements DiffInterface {

  /**
   * Gets the input for the easy difficulty of the AI. This method only uses the random strategy to
   * send an input.
   */
  @Override
  public String getFingers() {
    return new RandomStrategy().selectFingers();
  }
}
