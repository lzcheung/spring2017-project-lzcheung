package test.java;

import static org.junit.Assert.assertEquals;

import main.java.controller.FileProcessor;

import org.junit.Test;

public class TestGenerateOutputFileName {

  @Test
  public void test() {
    FileProcessor fp = new FileProcessor();
    
    String result = fp.generateOutPath("/home", "hi.txt");
    
    assertEquals("/home/hi_result.txt", result);
    
  }

}
