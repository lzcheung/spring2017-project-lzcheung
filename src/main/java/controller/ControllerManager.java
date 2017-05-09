package main.java.controller;

import java.util.ArrayList;

public class ControllerManager {
  private ArrayList<RoomController> listOfRooms;
  
  public ControllerManager() {
    this.listOfRooms = new ArrayList<>();
  }
  
  public void addRoom(RoomController rc) {
    listOfRooms.add(rc);
  }

}
