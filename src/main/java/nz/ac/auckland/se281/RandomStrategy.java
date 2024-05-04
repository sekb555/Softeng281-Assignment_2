package nz.ac.auckland.se281;

/** A strategy that selects a random number of fingers. */
public class RandomStrategy implements Strategy {

  /** Selects a random number of fingers. for the AI */
  @Override
  public String selectFingers() {
    // reuturns a random number of fingers
    return String.valueOf(Utils.random.nextInt(6));
  }
}
