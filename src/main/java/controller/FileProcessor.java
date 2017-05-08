package main.java.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileProcessor {
  public String readFile(String fileName) {
    String cellValue = "";
    try {
      FileInputStream file = new FileInputStream(new File(fileName));
      
      //Create Workbook instance holding reference to .xlsx file
      XSSFWorkbook workbook = new XSSFWorkbook(file);
      
      //Get first sheet from workbook
      XSSFSheet sheet = workbook.getSheetAt(0);
      
      //Get first row
      XSSFRow row = sheet.getRow(0);
      
      XSSFCell cell = row.getCell(0);
      
      cellValue = cell.getStringCellValue();
      
      workbook.close();
      file.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cellValue;
  }
}
