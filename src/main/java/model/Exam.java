package main.java.model;

import java.util.Date;

/**
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
              Date startTime, Date endTime) {
    this.requestId = requestId;
    this.examRecieved = examRecieved;
    this.professor = professor;
    this.requestStatus = requestStatus;
    this.accomodations = accomodations;
    this.course = course;
    this.startTime = startTime;
    this.endTime = endTime;
  }
  
  
}
