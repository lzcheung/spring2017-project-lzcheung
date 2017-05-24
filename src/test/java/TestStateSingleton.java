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
    state.addExam(new Exam(0, "examRecieved", "professor", "requestStatus",
        "accomodations", "course", null, null, null));
    assertEquals(1, state.getNumOfExams());
  }

}
