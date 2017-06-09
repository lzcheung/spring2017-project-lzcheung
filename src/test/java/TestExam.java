package test.java;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import main.java.model.Exam;
import org.junit.Test;

public class TestExam {
  
  @Test
  public void testPojoStructureAndBehavior() {
    PojoClass coursePojo = PojoClassFactory.getPojoClass(Exam.class);


    Validator validator = ValidatorBuilder.create()
        // Lets make sure that we have a getter and a setter for every field defined.
        .with(new SetterMustExistRule()).with(new GetterMustExistRule())

        // Lets also validate that they are behaving as expected
        .with(new SetterTester()).with(new GetterTester()).build();

    // Start the Test
    validator.validate(coursePojo);
  }
  /*
  
  Exam exam = new Exam();
  Date startDate = new Date();
  Date endDate = new Date();
  
  @Test
  public void testReqId() {
    exam.setRequestId(0);
    assertEquals(0, exam.getRequestId());
  }
  
  @Test
  public void testExamReceived() {
    exam.setExamReceived("yes");
    assertEquals("yes", exam.getExamReceived());
  }
  
  @Test
  public void testCourse() {
    exam.setCourse("CPE 305");
    assertEquals("CPE 305", exam.getCourse());
  }
  
  @Test
  public void testProfessor() {
    exam.setProfessor("professor");
    assertEquals("professor", exam.getProfessor());
  }
  
  @Test
  public void testReqStatus() {
    exam.setRequestStatus("requestStatus");
    assertEquals("requestStatus", exam.getRequestStatus());
  }
  
  @Test
  public void testAccoaodations() {
    exam.setAccommodations("accommadations");
    assertEquals("accommadations", exam.getAccommodations());
  }
  
  @Test
  public void testSeat() {
    exam.setSeat("1");
    assertEquals("1", exam.getSeat());
  }
  
  @Test
  public void testStartDate() {
    exam.setStartTime(startDate);
    assertEquals(startDate, exam.getStartTime());
  }
  
  @Test
  public void testEndTime() {
    exam.setEndTime(endDate);
    assertEquals(endDate, exam.getEndTime());
  }
  
  @Test
  public void testStudent() {
    Student student = new Student("Liang", "lzcheung");
    exam.setStudent(student);
    assertEquals(student, exam.getStudent());
  }
  
  public void testPrint() {
    String str = String.format("%-60s%-40s%-30s%-30s%-30s", 
        exam.getStudent().toString(), 
        "Professor: professor", 
        "Course: CPE 305", 
        "Start time: " + Exam.TIME_FORMAT.format(startDate), 
        "End time: " + Exam.TIME_FORMAT.format(endDate)
        );
    assertEquals(str, exam.toString());
  }
  */

}
