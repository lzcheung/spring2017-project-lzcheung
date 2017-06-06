package main.java.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class Seat {
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
      this.startBound = Exam.TIME_FORMAT.parse(DEFAULT_START_BOUND);
      this.endBound = Exam.TIME_FORMAT.parse(DEFAULT_END_BOUND);
    } catch (ParseException e) {
      parseError(e);
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
      this.startBound = Exam.TIME_FORMAT.parse(startBound);
      this.endBound = Exam.TIME_FORMAT.parse(endBound);
    } catch (ParseException e) {
      parseError(e);
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
  
  public Date getEndBound() {
    return endBound;
  }
  
  public boolean containsExam(int reqId) {
    return true;
  }
  
  public Exam getExamByReqId(int reqId) {
    return null;
  }
  
  public int getNumExams() {
    return exams.size();
  }
  
  public ArrayList<Exam> getExams() {
    return exams;
  }

  public void setExams(ArrayList<Exam> exams) {
    this.exams = exams;
  }

  public static String getDefaultStartBound() {
    return DEFAULT_START_BOUND;
  }

  public static String getDefaultEndBound() {
    return DEFAULT_END_BOUND;
  }

  private void parseError(Exception e) {
    Logger l = Logger.getAnonymousLogger();
    l.log(null, "Invalid Format", e);
  }
  
  public boolean checkExam(Exam exam) {
    if (exams.isEmpty()) {
      return true;
    }
    
    Exam lastExam = exams.get(exams.size() - 1);

    return lastExam.compare(exam);
  }
  
  public void addExam(Exam exam) {
    exams.add(exam);
  }
  
  public void printSeat() {
    for (Exam exam: exams) {
      String formated = String.format("Seat: %-10s %s", id, exam.toString());
      System.out.println(formated);
    }
  }
}
