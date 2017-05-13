package main.java.controller;

public class Main {
  public static void main(String[] args) {
    FileProcessor fp = new FileProcessor();
    StateSingleton state = new StateSingleton();
    ControllerManager controller = new ControllerManager();
    // FileInputStream file = new FileInputStream(new File("src/main/resources/testFile1.xlsx"));
    
    fp.readFile("src/main/resources/testFile1.xlsx", state);
    // state.printExams();
    
    controller.addRoom("225", 30);
    controller.addRoom("125", 30);
    
    controller.seatExams(state.getExams());
    
    controller.printAllRooms();
    
  }
}
