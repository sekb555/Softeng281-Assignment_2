package nz.ac.auckland.se281;

public class MedDiff implements DiffInterface{
  
  int roundNum;
  public MedDiff(int roundNum) {
    this.roundNum = roundNum;
  }
  
    @Override
    public String getFingers() {
      TopStategy top = new TopStategy();
      RandomStrategy rand = new RandomStrategy();
      if (roundNum < 3){
        return rand.selectFingers();
      } else {
        return top.selectFingers();
      }
    }
  
}
