package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import main.java.model.Exam;
import main.java.model.Seat;
import org.junit.Test;

public class TestSeat {

  @Test
  public void testGetExam() {
    Seat seat = new Seat("1");
    assertEquals(0, seat.getNumExams());
  }
  
  @Test
  public void testCheckExamTrue() {
    Seat seat = new Seat("1");
    Exam exam = new Exam();
    assertTrue(seat.checkExam(exam));
  }
  
  @Test
  public void testCheckExamFalse() throws ParseException {
    Seat seat = new Seat("1");
    Exam exam = new Exam();
    exam.setStartTime(Exam.TIME_FORMAT.parse("08:00 am"));
    exam.setEndTime(Exam.TIME_FORMAT.parse("10:10 am"));
    seat.addExam(exam);
    assertFalse(seat.checkExam(exam));
  }
  
  @Test
  public void testPojoStructureAndBehavior() {
    PojoClass coursePojo = PojoClassFactory.getPojoClass(Seat.class);


    Validator validator = ValidatorBuilder.create()
        // Lets make sure that we have a getter and a setter for every field defined.
        .with(new SetterMustExistRule()).with(new GetterMustExistRule())

        // Lets also validate that they are behaving as expected
        .with(new SetterTester()).with(new GetterTester()).build();

    // Start the Test
    validator.validate(coursePojo);
  }

}
