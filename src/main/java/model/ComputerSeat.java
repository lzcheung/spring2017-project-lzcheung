package main.java.model;

public class ComputerSeat extends Seat {
  
  /**
   * @param id Seat number.
   */
  public ComputerSeat(String id) {
    super(id);
  }
  
  /**
   * @param id Seat number.
   * @param startBound earliest start time.
   * @param endBound latest end time.
   */
  public ComputerSeat(String id, String startBound, String endBound) {
    super(id, startBound, endBound);
  }
}
