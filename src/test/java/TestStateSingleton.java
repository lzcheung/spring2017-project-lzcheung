package test.java;

import static org.junit.Assert.assertEquals;

import main.java.controller.DataSingleton;
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

}
