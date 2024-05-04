package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * This class is used for the better strategy for the AI ans is used for the medium and hard
 * difficulty.
 */
public class TopStategy implements Strategy {

  private static int sum;
  private static Choice choice;

  /**
   * Code for the AI to select an input to give its self better odds. when accompanied with hard
   * difficulty code AI becomes harder to beat
   */
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
   * Adds the fingers to the sum to keep track of the amount of odd and even inputs that the human
   * has given so that the AI can make a decision to increase chances of winning.
   *
   * @param fingers gets the number of finngers that the player has inputed and add it to the sum
   */
  public static void addFingers(int fingers) {
    boolean even = Utils.isEven(fingers);
    if (even == true) {
      sum += 1;
    } else if (even == false) {
      sum -= 1;
    }
  }

  /**
   * Clears the sum. This is used for when a new game is starting and the sum needs to be clear as
   * the player could have changed
   */
  public static void clear() {
    sum = 0;
  }

  /**
   * Sets the winning number set(EVEN/ODD) for the AI to make sure that it can make the right
   * decision to increases its chances of winning.
   *
   * @param newChoice gets the choice that the player has made at the start of the game
   */
  public void setChoice(Choice newChoice) {
    choice = newChoice;
  }
}
