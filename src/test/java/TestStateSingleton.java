package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import main.java.controller.DataSingleton;
import main.java.controller.RoomController;
import main.java.model.Exam;
import main.java.model.Student;

import org.junit.Test;

public class TestStateSingleton {

  @Test
  public void testStudents0() {
    DataSingleton state = DataSingleton.getInstance();
    assertEquals(0, state.getNumOfStudents());
  }
  
  @Test
  public void testStudents1() {
    DataSingleton state = DataSingleton.getInstance();
    state.addStudent(new Student("hello", "world"));
    assertEquals(1, state.getNumOfStudents());
  }
  
  @Test
  public void testExams0() {
    DataSingleton state = DataSingleton.getInstance();
    assertEquals(0, state.getNumOfExams());
  }
  
  @Test
  public void testExams1() {
    DataSingleton state = DataSingleton.getInstance();
    String[] examStrings = {"examReceived", 
        "professor", 
        "requestStatus", 
        "accommodations", 
        "course", 
        "allows"};
    state.addExam(new Exam(0, examStrings, null, null, new Student("name", "user")));
    assertEquals(1, state.getNumOfExams());
  }
  
  @Test
  public void testGetRoomManager() {
    DataSingleton state = DataSingleton.getInstance();
    RoomController room = new RoomController();
    state.setRoomManager(room);
    assertTrue(state.getRoomManager().equals(room));
  }
  
  @Test
  public void testGetStudents() {
    DataSingleton state = DataSingleton.getInstance();
    ArrayList<Student> students = new ArrayList<>();
    state.setStudents(students);
    assertTrue(state.getStudents().equals(students));
  }
  
  @Test
  public void testGetExams() {
    DataSingleton state = DataSingleton.getInstance();
    ArrayList<Exam> exams = new ArrayList<>();
    state.setExams(exams);
    assertTrue(state.getExams().equals(exams));
  }

}
