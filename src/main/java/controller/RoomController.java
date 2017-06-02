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
  
  public void addRoom(String roomNumber, int capacity) {
    rooms.add(new Room(roomNumber, capacity));
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
  
  public void printAllRooms() {
    for (Room rm: rooms) {
      rm.printRoom();
    }
    System.out.println("Extra Exams: " + Integer.valueOf(extras.size()));
    for (Exam exam: extras) {
      System.out.println(exam.toString());
    }
  }
}
