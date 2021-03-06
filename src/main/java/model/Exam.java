package main.java.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class models an exam and stores the data for a single exam.
 * @author lzcheung
 *
 */
public class Exam {
  public static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm a");
  
  private int requestId;
  private String examReceived;
  private String professor;
  private String requestStatus;
  private String accommodations;
  private String course;
  private String seatName;
  private Date startTime;
  private Date endTime;
  private Student student;
  private String studentName;
  private String studentUsername;
  private String allows;
  
  
  public Exam() {
  }
  
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
  public Exam(int requestId, String[] strings, Date startTime, Date endTime, Student student) {
    this.requestId = requestId;
    this.examReceived = strings[0];
    this.professor = strings[1];
    this.requestStatus = strings[2];
    this.accommodations = strings[3];
    this.course = strings[4];
    this.startTime = startTime;
    this.endTime = endTime;
    this.student = student;
    this.studentName = student.getName();
    this.studentUsername = student.getUsername();
    this.seatName = "Not seated";
    this.allows = strings[4];
  }

  public int getRequestId() {
    return requestId;
  }

  public void setRequestId(int requestId) {
    this.requestId = requestId;
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

  public String getAccommodations() {
    return accommodations;
  }

  public void setAccommodations(String accomodations) {
    this.accommodations = accomodations;
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
  
  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentUsername() {
    return studentUsername;
  }

  public void setStudentUsername(String studentUsername) {
    this.studentUsername = studentUsername;
  }

  public String getExamReceived() {
    return examReceived;
  }

  public void setExamReceived(String examReceived) {
    this.examReceived = examReceived;
  }

  public String getSeatName() {
    return seatName;
  }

  public void setSeatName(String seatName) {
    this.seatName = seatName;
  }

  public String getAllows() {
    return allows;
  }

  public void setAllows(String allows) {
    this.allows = allows;
  }

  public String toString() {
    return String.format("%-60s%-40s%-30s%-30s%-30s", 
        student.toString(), 
        "Professor: " + professor, 
        "Course: " + course, 
        "Start time: " + TIME_FORMAT.format(startTime), 
        "End time: " + TIME_FORMAT.format(endTime)
        );
  }
  
  public boolean compare(Exam exam) {
    return !(this.endTime.after(exam.startTime));
  }
}
