package test.java;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import main.java.controller.RoomController;
import main.java.model.Exam;
import main.java.model.Room;

import org.junit.Test;

public class TestRoomController {
  @Test
  public void testGetRoom() {
    RoomController roomController = new RoomController();
    ArrayList<Room> rooms = new ArrayList<>();
    roomController.setRooms(rooms);
    assertTrue(roomController.getRooms().equals(rooms));
  }

  @Test
  public void testGetExams() {
    RoomController roomController = new RoomController();
    ArrayList<Exam> exams = new ArrayList<>();
    roomController.setExtras(exams);
    assertTrue(roomController.getExtras().equals(exams));
  }
}
