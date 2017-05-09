package main.java.controller;

import main.java.model.Room;

public class RoomController {
  private Room room;
  
  public RoomController(Room room) {
    this.room = room;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }
  
  
}
