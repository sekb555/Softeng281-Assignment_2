package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * This class is used for the better strategy for the AI ans is used for the medium and hard
 * difficulty.
 */
public class TopStategy implements Strategy {

  private int sum;
  private Choice choice;

  public TopStategy(int sum, Choice choice) {
    this.sum = sum;
    this.choice = choice;
  }

  /**
   * Sets the winning number set(EVEN/ODD) for the AI to make sure that it can make the right
   * decision to increases its chances of winning.
   *
   * @param newChoice gets the choice that the player has made at the start of the game
   */
  public void setChoice(Choice newChoice) {

    // sets the choice at the start of a round
    choice = newChoice;
  }

  /**
   * Code for the AI to select an input to give its self better odds. when accompanied with hard
   * difficulty code AI becomes harder to beat
   */
  @Override
  public String selectFingers() {
    // if the player has selected even or odd then the AI will select the opposite to increase its
    // chances of winning
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

    // if the player has not selected even or odd then the AI will select a random number(although
    // this in not possible)
    return String.valueOf(Utils.random.nextInt(6));
  }
}
