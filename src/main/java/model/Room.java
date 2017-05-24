package main.java.model;

public class Room {
  private String roomNumber;
  private int capacity;
  private Seat[] seats;
  
  /**
   * @param roomNumber The name of the room.
   * @param capacity The size of the room.
   */
  public Room(String roomNumber, int capacity) {
    this.roomNumber = roomNumber;
    this.capacity = capacity;
    this.seats = new Seat[capacity];
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public Seat[] getSeats() {
    return seats;
  }

  public void setSeats(Seat[] seats) {
    this.seats = seats;
  }
  
  public boolean containsExam(int reqId) {
    return reqId == 0;
  }
  
  public int isValidExam(Exam exam) {
    for (int i = 0; i < seats.length; i++) {
      if (seats[i] == null || seats[i].checkExam(exam)) {
        return i;
      }
    }
    return -1;
  }
  
  public void addExamToSeat(Exam exam, int seatNumber) {
    String assigned = roomNumber + "-" + Integer.toString(seatNumber);
    exam.setSeat(assigned);
    if (seats[seatNumber] == null) {
      seats[seatNumber] = new Seat(assigned);
      seats[seatNumber].addExam(exam);
      
    } else {
      seats[seatNumber].addExam(exam);
    }
  }
  
  public void printRoom() {
    for (int i = 0; i < seats.length; i++) {
      if (seats[i] != null) {
        seats[i].printSeat();
      }
    }
  }
}
