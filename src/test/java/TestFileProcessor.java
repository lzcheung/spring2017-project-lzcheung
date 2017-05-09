package test.java;

import static org.junit.Assert.assertEquals;

import main.java.controller.FileProcessor;
import org.junit.Test;

public class TestFileProcessor {

  @Test
  public void test() {
    FileProcessor fp = new FileProcessor();
    assertEquals("a", fp.readFile(
        "/Users/lzcheung/Documents/CPE305/Project_workspace/SeatGenProject/resources/test.xlsx"));
  }

}
