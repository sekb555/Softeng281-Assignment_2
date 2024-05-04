package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStategy implements Strategy {

  private static int sum;
  private static Choice choice;

  /**
   * Constructor for the TopStrategy.
   *
   * @param newChoice
   */
  public void setChoice(Choice newChoice) {
    choice = newChoice;
  }

  /** code for the more difficult AI strategy. */
  @Override
  public String selectFingers() {
    if (choice == Choice.EVEN) {
      if (sum > 0) {
        return String.valueOf(Utils.getRandomOddNumber());
      } else if (sum < 0) {
        return String.valueOf(Utils.getRandomEvenNumber());
      }
    } else if (choice == Choice.ODD) {
      if (sum > 0) {
        return String.valueOf(Utils.getRandomEvenNumber());
      } else if (sum < 0) {
        return String.valueOf(Utils.getRandomOddNumber());
      }
    }

    return String.valueOf(Utils.random.nextInt(6));
  }

  /**
   * adds fingers to the sum.
   *
   * @param fingers
   */
  public static void addFingers(int fingers) {
    boolean even = Utils.isEven(fingers);
    if (even == true) {
      sum += 1;
    } else if (even == false) {
      sum -= 1;
    }
  }

  public static void clear() {
    sum = 0;
  }
}
