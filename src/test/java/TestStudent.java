package test.java;

import static org.junit.Assert.assertTrue;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import java.text.ParseException;
import java.util.Date;

import main.java.model.Exam;
import main.java.model.Student;

import org.junit.Test;

public class TestStudent {
  private Student student = new Student("Joe", "jsmith");

  @Test
  public void testPojoStructureAndBehavior() {
    PojoClass coursePojo = PojoClassFactory.getPojoClass(Student.class);


    Validator validator = ValidatorBuilder.create()
        // Lets make sure that we have a getter and a setter for every field defined.
        .with(new SetterMustExistRule()).with(new GetterMustExistRule())

        // Lets also validate that they are behaving as expected
        .with(new SetterTester()).with(new GetterTester()).build();

    // Start the Test
    validator.validate(coursePojo);
  }
  
  private Exam makeExam(int id) {
    Date startTime = null;
    try {
      startTime = Exam.TIME_FORMAT.parse("08:00 am");
    } catch (ParseException e1) {
      e1.printStackTrace();
    }
    Date endTime = null;
    try {
      endTime = Exam.TIME_FORMAT.parse("10:10 am");
    } catch (ParseException e) {
      e.printStackTrace();
    }
    String[] examStrings = {"examReceived", 
                            "professor", 
                            "requestStatus", 
                            "accommodations", 
                            "course", 
                            "allows"};
    
    return new Exam(id, examStrings, startTime, endTime, student);
    
  }

  @Test
  public void testContainsExam() {
    int id = 0;
    Exam exam = makeExam(id);
    student.addExam(exam);
    assertTrue(student.containsExam(id));
  }
  
  @Test
  public void testGetExam() {
    int id = 1;
    Exam exam = makeExam(id);
    student.addExam(exam);
    assertTrue(student.getExam(id) == exam);
  }
  
  @Test
  public void testToString() {
    String studentString = String.format("%-30s%-30s", "name: Joe", "Username: jsmith");
    assertTrue(student.toString().equals(studentString));
  }
}
