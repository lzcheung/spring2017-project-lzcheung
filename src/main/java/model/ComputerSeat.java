package main.java.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class ComputerSeat implements Seat {
  private String id;
  private Date startBound;
  private Date endBound;
  private ArrayList<Student> students;
  
  /**
   * @param id Seat number.
   */
  public ComputerSeat(String id) {
    this.id = id;
    students = new ArrayList<Student>();
    
    try {
      this.startBound = timeFormatter.parse(Seat.DEFAULT_START_BOUND);
      this.endBound = timeFormatter.parse(Seat.DEFAULT_END_BOUND);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  /**
   * @param id Seat number.
   */
  public ComputerSeat(String id, String startBound, String endBound) {
    this.id = id;
    students = new ArrayList<Student>();
    
    try {
      this.startBound = timeFormatter.parse(startBound);
      this.endBound = timeFormatter.parse(endBound);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
