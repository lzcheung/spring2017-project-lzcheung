package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import main.java.model.Exam;
import main.java.model.Seat;
import org.junit.Test;

public class TestCompareExams {

  @Test
  public void testValidDifferent() {
    Date exam1Start = null;
    Date exam2Start = null;
    Date exam1End = null;
    Date exam2End = null;
    try {
      exam1Start = Seat.TIME_FORMAT.parse("8:00 am");
      exam2Start = Seat.TIME_FORMAT.parse("10:10 am");
      exam1End = Seat.TIME_FORMAT.parse("10:00 am");
      exam2End = Seat.TIME_FORMAT.parse("12:10 am");
    } catch (Exception e) {
      e.printStackTrace();
    }
    Exam exam1 = new Exam(1, 
                          "examRecieved", 
                          "professora", 
                          "requestStatus", 
                          "accomodations", 
                          "course", 
                          exam1Start,
                          exam1End,
                          null);
    Exam exam2 = new Exam(1, 
                          "examRecieved", 
                          "professora", 
                          "requestStatus", 
                          "accomodations", 
                          "course", 
                          exam2Start,
                          exam2End,
                          null);
    assertTrue(exam1.compare(exam2));
  }
  
  @Test
  public void testValidSame() {
    Date exam1Start = null;
    Date exam2Start = null;
    Date exam1End = null;
    Date exam2End = null;
    try {
      exam1Start = Seat.TIME_FORMAT.parse("8:00 am");
      exam2Start = Seat.TIME_FORMAT.parse("10:00 am");
      exam1End = Seat.TIME_FORMAT.parse("10:00 am");
      exam2End = Seat.TIME_FORMAT.parse("12:10 am");
    } catch (Exception e) {
      e.printStackTrace();
    }
    Exam exam1 = new Exam(1, 
                          "examRecieved", 
                          "professora", 
                          "requestStatus", 
                          "accomodations", 
                          "course", 
                          exam1Start,
                          exam1End,
                          null);
    Exam exam2 = new Exam(1, 
                          "examRecieved", 
                          "professora", 
                          "requestStatus", 
                          "accomodations", 
                          "course", 
                          exam2Start,
                          exam2End,
                          null);
    assertTrue(exam1.compare(exam2));
  }
  
  @Test
  public void testInvalid() {
    Date exam1Start = null;
    Date exam2Start = null;
    Date exam1End = null;
    Date exam2End = null;
    try {
      exam1Start = Seat.TIME_FORMAT.parse("8:00 am");
      exam2Start = Seat.TIME_FORMAT.parse("9:00 am");
      exam1End = Seat.TIME_FORMAT.parse("10:00 am");
      exam2End = Seat.TIME_FORMAT.parse("12:10 am");
    } catch (Exception e) {
      e.printStackTrace();
    }
    Exam exam1 = new Exam(1, 
                          "examRecieved", 
                          "professora", 
                          "requestStatus", 
                          "accomodations", 
                          "course", 
                          exam1Start,
                          exam1End,
                          null);
    Exam exam2 = new Exam(1, 
                          "examRecieved", 
                          "professora", 
                          "requestStatus", 
                          "accomodations", 
                          "course", 
                          exam2Start,
                          exam2End,
                          null);
    assertFalse(exam1.compare(exam2));
  }

}
