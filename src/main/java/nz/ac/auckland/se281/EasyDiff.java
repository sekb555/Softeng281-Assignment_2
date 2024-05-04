package nz.ac.auckland.se281;

public class EasyDiff implements DiffInterface {

  /** Gets the input for the easy difficulty of the AI. */
  @Override
  public String getFingers() {
    return new RandomStrategy().selectFingers();
  }
}
