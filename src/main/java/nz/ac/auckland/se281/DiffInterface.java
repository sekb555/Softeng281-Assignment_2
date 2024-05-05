package nz.ac.auckland.se281;

/** Interface for the Strategy pattern. To be implemented by the different strategies. */
public interface DiffInterface {
  public String getFingers();

  public Strategy getStrategy();
}
