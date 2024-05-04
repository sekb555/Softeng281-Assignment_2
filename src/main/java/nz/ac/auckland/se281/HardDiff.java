package nz.ac.auckland.se281;

public class HardDiff implements DiffInterface{

  int roundNum;
  public HardDiff(int roundNum) {
    this.roundNum = roundNum;
  }
  
    @Override
    public String getFingers() {
      return "3";
    }
  
}
