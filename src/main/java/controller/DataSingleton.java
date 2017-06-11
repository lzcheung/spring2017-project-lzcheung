package main.java.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Exam;
import main.java.model.Room;
import main.java.model.Student;

public class DataSingleton {
  private static final DataSingleton INSTANCE = new DataSingleton();
  private ArrayList<Student> students;
  private RoomController roomManager;
  private ArrayList<Exam> exams;
  
  private DataSingleton() {
    this.students = new ArrayList<>();
    this.exams = new ArrayList<>();
    this.roomManager = new RoomController();
  }
  
  public static DataSingleton getInstance() {
    return INSTANCE;
  }
  
  public RoomController getRoomManager() {
    return roomManager;
  }

  public void setRoomManager(RoomController roomManager) {
    this.roomManager = roomManager;
  }

  public void setStudents(List<Student> students) {
    this.students = (ArrayList<Student>)students;
  }

  public void setExams(List<Exam> exams) {
    this.exams = (ArrayList<Exam>)exams;
  }
  
  public void addRoom(Room room) {
    roomManager.addRoom(room);
  }

  public void addStudent(Student student) {
    students.add(student);
  }
  
  public void addExam(Exam exam) {
    exams.add(exam);
  }

  public int getNumOfStudents() {
    return students.size();
  }
  
  public int getNumOfExams() {
    return exams.size(); 
  }

  public List<Student> getStudents() {
    return students;
  }

  public List<Exam> getExams() {
    return exams;
  }
}
