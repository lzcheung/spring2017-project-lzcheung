package main.java.model;

import java.util.ArrayList;

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
}
