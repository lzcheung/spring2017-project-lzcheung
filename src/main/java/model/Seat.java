package main.java.model;

import java.util.ArrayList;

public class Seat {
 
  private String id;
  private ArrayList<Exam> exams;

  /**
   * @param id Seat number.
   */
  public Seat(String id) {
    this.id = id;
    exams = new ArrayList<>();
  }
 
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
}
