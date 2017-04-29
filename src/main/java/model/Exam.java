package main.java.model;

import java.util.Date;

/**
 * This class models an exam and stores the data for a single exam.
 * @author lzcheung
 *
 */
public class Exam {
  private int requestId;
  private String examRecieved;
  private String professor;
  private String requestStatus;
  private String accomodations;
  private String course;
  private Date startTime;
  private Date endTime;
  private Student student;
  
  /**
   * @param requestId Exam request id.
   * @param examRecieved Exam method of retrieval.
   * @param professor Professor name.
   * @param requestStatus Exam request status.
   * @param accomodations Accommodations.
   * @param course Course id.
   * @param startTime Exam start time.
   * @param endTime Exam end time.
   */
  public Exam(int requestId, String examRecieved, String professor, 
              String requestStatus, String accomodations, String course, 
              Date startTime, Date endTime, Student student) {
    this.requestId = requestId;
    this.examRecieved = examRecieved;
    this.professor = professor;
    this.requestStatus = requestStatus;
    this.accomodations = accomodations;
    this.course = course;
    this.startTime = startTime;
    this.endTime = endTime;
    this.student = student;
  }

  public int getRequestId() {
    return requestId;
  }

  public void setRequestId(int requestId) {
    this.requestId = requestId;
  }

  public String getExamRecieved() {
    return examRecieved;
  }

  public void setExamRecieved(String examRecieved) {
    this.examRecieved = examRecieved;
  }

  public String getProfessor() {
    return professor;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }

  public String getRequestStatus() {
    return requestStatus;
  }

  public void setRequestStatus(String requestStatus) {
    this.requestStatus = requestStatus;
  }

  public String getAccomodations() {
    return accomodations;
  }

  public void setAccomodations(String accomodations) {
    this.accomodations = accomodations;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
  
}
