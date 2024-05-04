package nz.ac.auckland.se281;

public class EasyDiff implements DiffInterface {

  @Override
  public String getFingers() {
    return new RandomStrategy().selectFingers();
  }
}
