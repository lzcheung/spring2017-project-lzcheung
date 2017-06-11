package main.java.model;

import java.util.HashMap;
import java.util.Map;

public class Student {
  private String name;
  private String username;
  private Map<Integer, Exam> exams;
  
  /**
   * @param name Student name.
   * @param username Student username.
   */
  public Student(String name, String username) {
    this.name = name;
    this.username = username;
    exams = new HashMap<>();
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
  
  public Map<Integer, Exam> getExams() {
    return exams;
  }

  public void setExams(Map<Integer, Exam> exams) {
    this.exams = exams;
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
  
  public String toString() {
    return String.format("%-30s%-30s", "name: " + name, "Username: " + username);
  }
}
