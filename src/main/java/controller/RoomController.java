package main.java.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Exam;
import main.java.model.Room;

public class RoomController {
  private ArrayList<Room> rooms;
  private ArrayList<Exam> extras;
  
  public RoomController() {
    this.rooms = new ArrayList<>();
    this.extras = new ArrayList<>();
  }
  
  public ArrayList<Room> getRooms() {
    return rooms;
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
