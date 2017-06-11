package main.java.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Exam;
import main.java.model.Room;

public class RoomController {
  private List<Room> rooms;
  private List<Exam> extras;
  
  public RoomController() {
    this.rooms = new ArrayList<>();
    this.extras = new ArrayList<>();
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  public List<Exam> getExtras() {
    return extras;
  }

  public void setExtras(List<Exam> extras) {
    this.extras = extras;
  }

  public void addRoom(Room room) {
    rooms.add(room);
  }
  
  public void seatExams(List<Exam> exams) {
    int seatNumber = -1;
    
    for (Exam exam: exams) {
      for (Room room: rooms) {
        seatNumber = room.isValidExam(exam);
        if (seatNumber > -1) {
          room.addExamToSeat(exam, seatNumber);
          break;
        }
      }
      if (seatNumber == -1) {
        extras.add(exam);
      }
    }
  }

}
