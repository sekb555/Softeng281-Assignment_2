package nz.ac.auckland.se281;

/**
 * A strategy that selects a random number of fingers.
 * 
 */

public class RandomStrategy implements Strategy {

  @Override
  public String selectFingers() {
    return String.valueOf(Utils.random.nextInt(6));
  }
}
