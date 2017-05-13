package main.java.model;

import java.util.Date;

/**
 * This class models an exam and stores the data for a single exam.
 * @author lzcheung
 *
 */
public class Exam {
  private int requestId;
  private String examReceived;
  private String professor;
  private String requestStatus;
  private String accomodations;
  private String course;
  private Date startTime;
  private Date endTime;
  private Student student;
  
  /**
   * @param requestId Exam request id.
   * @param examReceived Exam method of retrieval.
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
    this.examReceived = examRecieved;
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
    return examReceived;
  }

  public void setExamRecieved(String examRecieved) {
    this.examReceived = examRecieved;
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
  
  public String toString() {
    String exam = String.format("%-60s%-40s%-30s%-30s%-30s", 
        student.toString(), 
        "Professor: " + professor, 
        "Course: " + course, 
        "Start time: " + Seat.TIME_FORMAT.format(startTime), 
        "End time: " + Seat.TIME_FORMAT.format(endTime)
        );
    return exam;
  }
  
  public boolean compare(Exam exam) {
    if (this.endTime.before(exam.startTime) || this.endTime.equals(exam.startTime)) {
      return true;
    } else {
      return false;
    }
  }
}
