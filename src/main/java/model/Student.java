package main.java.model;

import java.util.HashMap;

public class Student {
  private String name;
  private String username;
  private HashMap<Integer, Exam> exams;
  
  /**
   * @param name Student name.
   * @param username Student username.
   */
  public Student(String name, String username) {
    this.name = name;
    this.username = username;
    exams = new HashMap<Integer, Exam>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  public void addExam(Exam e) {
    exams.put(e.getRequestId(), e);
  }
  
  public boolean containsExam(int requestId) {
    return exams.containsKey(requestId);
  }
  
  public Exam getExam(int requestId) {
    return exams.get(requestId);
  }
  
}
