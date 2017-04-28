package main.java.model;

import java.util.ArrayList;

public class RegularSeat implements Seat {
  private String name;
  private ArrayList<Student> students;

  public RegularSeat(String name) {
    this.name = name;
    students = new ArrayList<Student>();
  }
}
