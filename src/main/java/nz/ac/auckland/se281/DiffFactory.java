package nz.ac.auckland.se281;

public class DiffFactory {

  public DiffInterface createDiff(String diffType) {

    if (diffType.equalsIgnoreCase("Easy")) {
      return new EasyDiff();
    } else if (diffType.equalsIgnoreCase("Medium")) {
      return new EasyDiff();
    } else {
      return null;
    }
  }
}
