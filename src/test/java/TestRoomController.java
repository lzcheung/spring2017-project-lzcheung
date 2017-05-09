package test.java;

import static org.junit.Assert.assertTrue;

import main.java.controller.RoomController;
import main.java.model.Room;

import org.junit.Test;

public class TestRoomController {

  @Test
  public void test() {
    Room room = new Room("101", 50);
    RoomController rc = new RoomController(room);
    assertTrue(rc.getRoom() == room);
  }

}
