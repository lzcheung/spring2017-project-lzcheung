package test.java;

import static org.junit.Assert.assertEquals;

import main.java.model.Room;

import org.junit.Test;

public class TestRoomModel {

  @Test
  public void testIsValidExam() {
    Room rm = new Room("101", 10);
    
    assertEquals("101", rm.getRoomNumber());
  }

}
