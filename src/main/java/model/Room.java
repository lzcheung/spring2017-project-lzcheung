package main.java.model;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Logger;

public class Room {
  public static final String DEFAULT_START_BOUND = "08:00 am";
  public static final String DEFAULT_END_BOUND = "10:00 pm";
  
  private String roomName;
  private int capacity;
  private Date startBound;
  private Date endBound;
  private Seat[] seats;
  
  /**
   * @param roomName The name of the room.
   * @param capacity The size of the room.
   */
  public Room(String roomName, int capacity) {
    this.roomName = roomName;
    this.capacity = capacity;
    this.seats = new Seat[capacity];
    
    try {
      this.startBound = Exam.TIME_FORMAT.parse(DEFAULT_START_BOUND);
      this.endBound = Exam.TIME_FORMAT.parse(DEFAULT_END_BOUND);
    } catch (ParseException e) {
      parseError(e);
    }
  }
  
  public Room(String roomName, int capacity, String startBound, String endBound) {
    this.roomName = roomName;
    this.capacity = capacity;
    this.seats = new Seat[capacity];
    
    try {
      this.startBound = Exam.TIME_FORMAT.parse(startBound);
      this.endBound = Exam.TIME_FORMAT.parse(endBound);
    } catch (ParseException e) {
      parseError(e);
    }
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public Seat[] getSeats() {
    return seats;
  }

  public void setSeats(Seat[] seats) {
    this.seats = seats;
  }
  
  public Date getStartBound() {
    return startBound;
  }

  public void setStartBound(Date startBound) {
    this.startBound = startBound;
  }
  
  public void setStartBound(String startTime) {
    try {
      this.startBound = Exam.TIME_FORMAT.parse(startTime);
    } catch (ParseException e) {
      parseError(e);
    }
  }
  
  public Date getEndBound() {
    return endBound;
  }
  
  public void setEndBound(Date endBound) {
    this.endBound = endBound;
  }
  
  public void setEndBound(String endTime) {
    try {
      this.endBound = Exam.TIME_FORMAT.parse(endTime);
    } catch (ParseException e) {
      parseError(e);
    }
  }
  
  public boolean containsExam(int reqId) {
    return reqId == 0;
  }
  
  public int isValidExam(Exam exam) {
    for (int i = 0; i < seats.length; i++) {
      if (seats[i] == null || seats[i].checkExam(exam)) {
        return i;
      }
    }
    return -1;
  }
  
  public void addExamToSeat(Exam exam, int seatNumber) {
    String assigned = roomName + "-" + Integer.toString(seatNumber);
    exam.setSeat(assigned);
    if (seats[seatNumber] == null) {
      seats[seatNumber] = new Seat(assigned);
      seats[seatNumber].addExam(exam);
      
    } else {
      seats[seatNumber].addExam(exam);
    }
  }
  
  private void parseError(Exception e) {
    Logger l = Logger.getAnonymousLogger();
    l.log(null, "Invalid Format", e);
  }
}
