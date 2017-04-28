package main.java.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Seat {
  public static DateFormat timeFormatter = new SimpleDateFormat("HH:mm a");
  public static final String DEFAULT_START_BOUND = "08:00 am";
  public static final String DEFAULT_END_BOUND = "10:00 pm";
  
  private String id;
  private Date startBound;
  private Date endBound;
  private ArrayList<Student> students;

  /**
   * @param id Seat number.
   */
  public Seat(String id) {
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
   * @param startBound earliest start time.
   * @param endBound latest end time.
   */
  public Seat(String id, String startBound, String endBound) {
    this.id = id;
    students = new ArrayList<Student>();
    
    try {
      this.startBound = timeFormatter.parse(startBound);
      this.endBound = timeFormatter.parse(endBound);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
