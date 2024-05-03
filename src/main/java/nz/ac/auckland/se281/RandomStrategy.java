package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy{

  @Override
  public String selectFingers() {
    return String.valueOf(Utils.random.nextInt(5) + 1);
  }
  
}
