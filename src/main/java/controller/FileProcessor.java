package main.java.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.logging.Logger;

import main.java.model.Exam;
import main.java.model.Student;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileProcessor {
  public static final int PROCESS_ID = 0;
  public static final int STUDENT_NAME = 3;
  public static final int COURSE = 4;
  public static final int START_TIME = 5;
  public static final int END_TIME = 6;
  public static final int ACCOMODATIONS = 7;
  public static final int INSTRUCTOR_ALLOWS = 8;
  public static final int RECIEVED = 12;
  public static final int STUDENT_USERNAME = 13;
  public static final int INSTRUCTOR_NAME = 15;
  public static final int REQUEST_STATUS = 21;
  
  public void readFile(String fileName, StateSingleton state) {
    FileInputStream file = null;
    try {
      file = new FileInputStream(new File(fileName));
      
      //Create Workbook instance holding reference to .xlsx file
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      
      //Get first sheet from workbook
      XSSFSheet sheet = workbook.getSheetAt(0);
      
      for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
        if (i > 1) {
          XSSFRow row = sheet.getRow(i);
          Student newStudent = rowToStudent(row);
          Exam newExam = rowToExam(row, newStudent);
          newStudent.addExam(newExam);
          state.addStudent(newStudent);
          state.addExam(newExam);
        }
      }
      
      workbook.close();
      
    } catch (Exception e) {
      e.printStackTrace();
      //Logger l = Logger.getAnonymousLogger();
      //l.log(null, "Invalid Format", e);
    } finally {
      try {
        if (file != null) {
          file.close();
        }
      } catch (Exception e) {
        Logger l = Logger.getAnonymousLogger();
        l.log(null, "Exception: Filestream failed to close", e);
      }
    }
  }

  private Exam rowToExam(XSSFRow row, Student student) {
    int requestId = (int)row.getCell(PROCESS_ID).getNumericCellValue();
    String examReceived = row.getCell(RECIEVED).getStringCellValue();
    String professor = row.getCell(INSTRUCTOR_NAME).getStringCellValue();
    String requestStatus = row.getCell(REQUEST_STATUS).getStringCellValue();
    String accomodations = row.getCell(ACCOMODATIONS).getStringCellValue();
    String course = row.getCell(COURSE).getStringCellValue();
    Date startTime = row.getCell(START_TIME).getDateCellValue();
    Date endTime = row.getCell(END_TIME).getDateCellValue();
    
    return new Exam(requestId, examReceived, professor, requestStatus, 
        accomodations, course, startTime, endTime, student);
  }

  private Student rowToStudent(XSSFRow row) {
    String name = row.getCell(STUDENT_NAME).getStringCellValue();
    String username = row.getCell(STUDENT_USERNAME).getStringCellValue();
    
    return new Student(name, username);
  }
}
