package main.java.controller;

import java.util.ArrayList;

import main.java.model.Exam;
import main.java.model.Room;

public class ControllerManager {
  private ArrayList<Room> rooms;
  
  public ControllerManager() {
    this.rooms = new ArrayList<>();
  }
  
  public void addRoom(String roomNumber, int capacity) {
    rooms.add(new Room(roomNumber, capacity));
  }
  
  public void seatExams(ArrayList<Exam> exams) {
    for (Exam exam: exams) {
      // System.out.println(exam.toString());
      for (Room room: rooms) {
        int seatNumber = room.isValidExam(exam);
        if (seatNumber > -1) {
          room.addExamToSeat(exam, seatNumber);
          break;
        }
      }
    }
  }
  
  public void printAllRooms() {
    for (Room rm: rooms) {
      rm.printRoom();
    }
  }
}
