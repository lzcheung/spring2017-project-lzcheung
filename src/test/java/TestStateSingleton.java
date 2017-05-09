package test.java;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import main.java.controller.StateSingleton;
import main.java.model.Exam;
import main.java.model.Student;

import org.junit.Test;

public class TestStateSingleton {

  @Test
  public void testStudents0() {
    StateSingleton state = StateSingleton.getInstance();
    assertEquals(0, state.getNumOfStudents());
  }
  
  @Test
  public void testStudents1() {
    StateSingleton state = StateSingleton.getInstance();
    state.addStudent(new Student("hello", "world"));
    assertEquals(1, state.getNumOfStudents());
  }
  
  @Test
  public void testExams0() {
    StateSingleton state = StateSingleton.getInstance();
    assertEquals(0, state.getNumOfExams());
  }
  
  @Test
  public void testExams1() {
    StateSingleton state = StateSingleton.getInstance();
    state.addExam(new Exam(0, "examRecieved", "professor", "requestStatus",
        "accomodations", "course", null, null, null));
    assertEquals(1, state.getNumOfExams());
  }

}
