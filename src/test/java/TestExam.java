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
  
  @Test
  public void testToString() throws ParseException {
    String[] examStrings = {"examReceived", 
        "professor", 
        "requestStatus", 
        "accommodations", 
        "course", 
        "allows"};
    Date startTime = Exam.TIME_FORMAT.parse("08:00 am");
    Date endTime = Exam.TIME_FORMAT.parse("10:00 am");
    Student student = new Student("name", "user");
    Exam exam = new Exam(0, examStrings, startTime, endTime, student);
    String examString = String.format("%-60s%-40s%-30s%-30s%-30s", 
        student.toString(), 
        "Professor: professor", 
        "Course: course", 
        "Start time: " + Exam.TIME_FORMAT.format(startTime), 
        "End time: " + Exam.TIME_FORMAT.format(endTime)
        );
    assertTrue(exam.toString().equals(examString));
  }

}
