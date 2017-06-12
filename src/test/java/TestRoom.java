package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import main.java.model.Exam;
import main.java.model.Room;
import main.java.model.Seat;

import org.junit.Test;

public class TestRoom {
  Room rm = new Room("117", 20);

  @Test
  public void testRoomNumber() {
    assertEquals("117", rm.getRoomName());
  }
  
  @Test
  public void testSetRoomNumber() {
    rm.setRoomName("102");
    assertEquals("102", rm.getRoomName());
  }
  
  @Test
  public void testCapacity() {
    assertEquals(20, rm.getCapacity());
  }
  
  @Test
  public void testSetCapacity() {
    rm.setCapacity(21);
    assertEquals(21, rm.getCapacity());
  }

  @Test
  public void testSeatsArray() {
    assertEquals(20, rm.getSeats().length);
  }
  
  @Test
  public void testIsValidExam() {
    assertEquals(0, rm.isValidExam(new Exam()));
  }
  
  @Test
  public void testConstructor2() {
    Room rm2 = new Room("room 2", 10, "08:00 am", "10:00 pm");
    assertTrue(rm2 instanceof Room);
  }
  
  @Test
  public void testSeatArray() {
    Seat[] s = new Seat[10];
    rm.setSeats(s);
    assertTrue(s == rm.getSeats());
  }
  
  @Test
  public void testStartBound() {
    Date start = new Date();
    rm.setStartBound(start);
    assertTrue(rm.getStartBound() == start);
  }
  
  @Test
  public void testEndBound() {
    Date end = new Date();
    rm.setEndBound(end);
    assertTrue(rm.getEndBound() == end);
  }
  
  @Test
  public void testisValidExam() {
    Exam exam = new Exam();
    assertEquals(0, rm.isValidExam(exam));
  }
  
  @Test
  public void testAddExamToSeatSucess() {
    Exam exam = new Exam();
    rm.addExamToSeat(exam, 0);
    assertTrue(rm.getSeats()[0].getExams().get(0).equals(exam));
  }
  
}
