package main.java.controller;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main {
  public static void main(String[] args) {

    FileProcessor fp = new FileProcessor();
    DataSingleton state = new DataSingleton();
    ControllerManager controller = new ControllerManager();
    
    fp.readFile("src/main/resources/testFile1.xlsx", state);
    // state.printExams();
    
    controller.addRoom("117/117", 50);
    controller.addRoom("224/224", 16);
    controller.addRoom("228/227", 13);
    controller.addRoom("125/122", 17);
    controller.addRoom("UU220", 40);
    
    // state.printExams();
    
    controller.seatExams(state.getExams());
    
    controller.printAllRooms();

    fp.writeToExcelFile("src/main/resources/output.xls", state.getExams());
  }
  /*
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Hello World!");
    Button btn = new Button();
    btn.setText("Say 'Hello World'");
    btn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Hello World!");
        }
    });
    
    StackPane root = new StackPane();
    root.getChildren().add(btn);
    primaryStage.setScene(new Scene(root, 300, 250));
    primaryStage.show();
  }*/
}
