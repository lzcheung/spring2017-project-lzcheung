package main.java.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Seat {
  public static final DateFormat timeFormatter = new SimpleDateFormat("HH:mm a");
  public static final String DEFAULT_START_BOUND = "08:00 am";
  public static final String DEFAULT_END_BOUND = "10:00 pm";
  
  private String id;
  private Date startBound;
  private Date endBound;
  private ArrayList<Exam> exams;

  /**
   * @param id Seat number.
   */
  public Seat(String id) {
    this.id = id;
    exams = new ArrayList<>();
    
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
    exams = new ArrayList<>();
    
    try {
      this.startBound = timeFormatter.parse(startBound);
      this.endBound = timeFormatter.parse(endBound);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getStartBound() {
    return startBound;
  }

  /**
   * @param startTime Start bound.
   */
  public void setStartBound(String startTime) {
    try {
      this.startBound = timeFormatter.parse(startTime);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  public Date getEndBound() {
    return endBound;
  }

  /**
   * @param endTime End bound.
   */
  public void setEndBound(String endTime) {
    try {
      this.endBound = timeFormatter.parse(endTime);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
  
  public boolean containsExam(int reqId) {
    return true;
  }
  
  public Exam getExamByReqId(int reqId) {
    return null;
  }
}
