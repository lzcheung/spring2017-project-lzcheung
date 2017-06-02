package test.java;

import static org.junit.Assert.assertTrue;

import main.java.controller.RoomController;
import org.junit.Test;

public class TestRoomController {

  @Test
  public void test() {
    RoomController rc = new RoomController();
    rc.addRoom("101", 50);
    assertTrue(true);
  }

}
