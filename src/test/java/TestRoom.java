package test.java;

import static org.junit.Assert.assertEquals;

import main.java.model.Exam;
import main.java.model.Room;

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
}
