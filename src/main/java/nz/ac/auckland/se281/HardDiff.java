package nz.ac.auckland.se281;

public class HardDiff implements DiffInterface{

  int roundNum;
  String lastWinner;
  public HardDiff(int roundNum, String lastWinner) {
    this.roundNum = roundNum;
    this.lastWinner = lastWinner;
  }
  
    @Override
    public String getFingers() {
      return new RandomStrategy().selectFingers();
    }
  
}
