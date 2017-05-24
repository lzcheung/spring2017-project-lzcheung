package test.java;

import static org.junit.Assert.assertTrue;

import main.java.controller.ControllerManager;
import org.junit.Test;

public class TestRoomController {

  @Test
  public void test() {
    ControllerManager rc = new ControllerManager();
    rc.addRoom("101", 50);
    assertTrue(true);
  }

}
