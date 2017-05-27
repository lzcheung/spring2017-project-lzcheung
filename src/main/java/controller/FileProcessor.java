package main.java.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import main.java.model.Exam;
import main.java.model.Seat;
import main.java.model.Student;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
  
  public void readFile(String fileName, DataSingleton state) {
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
      Logger l = Logger.getAnonymousLogger();
      l.log(null, "Invalid Format", e);
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
  
  public void writeToExcelFile(String outputFileName, List<Exam> exams) {
    Workbook wb = new XSSFWorkbook();
    Sheet sheet = wb.createSheet("Sheet 1");
    Row header = sheet.createRow(0);
    
    header.createCell(0).setCellValue("EXAM RECEIVED");
    header.createCell(1).setCellValue("PROFESSOR");
    header.createCell(2).setCellValue("REQUEST STATUS");
    header.createCell(3).setCellValue("ACCOMMODATIONS");
    header.createCell(4).setCellValue("REQ #");
    header.createCell(5).setCellValue("LOCATION/SEAT");
    header.createCell(6).setCellValue("STUDENT");
    header.createCell(7).setCellValue("CLASS");
    header.createCell(8).setCellValue("START TIME");
    header.createCell(9).setCellValue("END TIME");
    header.createCell(10).setCellValue("INSTRUCTOR");
    header.createCell(11).setCellValue("STUDENT USERNAME");
    
    for (int i = 0; i < exams.size(); i++) {
      Exam exam = exams.get(i);
      Row row = sheet.createRow(i + 1);
      
      row.createCell(0).setCellValue(exam.getExamRecieved());
      row.createCell(1).setCellValue(exam.getProfessor());
      row.createCell(2).setCellValue(exam.getRequestStatus());
      row.createCell(3).setCellValue(exam.getAccommodations());
      row.createCell(4).setCellValue(exam.getRequestId());
      row.createCell(5).setCellValue(exam.getSeat());
      row.createCell(6).setCellValue(exam.getStudent().getName());
      row.createCell(7).setCellValue(exam.getCourse());
      row.createCell(8).setCellValue(Seat.TIME_FORMAT.format(exam.getStartTime()));
      row.createCell(9).setCellValue(Seat.TIME_FORMAT.format(exam.getEndTime()));
      row.createCell(10).setCellValue(exam.getProfessor());
      row.createCell(11).setCellValue(exam.getStudent().getUsername());
    }
   
    FileOutputStream fileOut = null;
    
    try {
      fileOut = new FileOutputStream(outputFileName);
      wb.write(fileOut);
    } catch (Exception e) {
      Logger l = Logger.getAnonymousLogger();
      l.log(null, "Invalid Format", e);
    } finally {
      try {
        if (wb != null) {
          wb.close();
        }
      } catch (Exception e) {
        Logger l = Logger.getAnonymousLogger();
        l.log(null, "Exception: Workbook failed to close", e);
      }
      try {
        if (fileOut != null) {
          fileOut.close();
        }
      } catch (Exception e) {
        Logger l = Logger.getAnonymousLogger();
        l.log(null, "Exception: Filestream failed to close", e);
      }
    }
  }
  
  public String generateOutPath(String parent, String name) {
    int idx = name.lastIndexOf('.');
    String oldName = name.substring(0, idx);
    String ext = name.substring(idx);
    String outPath = String.format("%s/%s_result%s", parent, oldName, ext);
    return outPath;
  }
}
