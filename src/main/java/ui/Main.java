package main.java.ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import main.java.controller.ControllerManager;
import main.java.controller.DataSingleton;
import main.java.controller.FileProcessor;

public class Main extends Application {
  private Desktop desktop = Desktop.getDesktop();
  
  public static void main(String[] args) {
    Application.launch(args);
  }
  
  @Override
  public void start(final Stage stage) {
    stage.setTitle("File Chooser Sample");

    final FileChooser fileChooser = new FileChooser();

    final Button openButton = new Button("Select Excel file.");

    openButton.setOnAction(
        new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
              File file = fileChooser.showOpenDialog(stage);
              if (file != null && file.getName().endsWith(".xlsx")) {
                System.out.println(file.getParent());
                String path = file.getAbsolutePath();
                
                FileProcessor fp = new FileProcessor();
                DataSingleton state = new DataSingleton();
                ControllerManager controller = new ControllerManager();
                
                fp.readFile(path, state);
                // state.printExams();
                
                controller.addRoom("117/117", 50);
                controller.addRoom("224/224", 16);
                controller.addRoom("228/227", 13);
                controller.addRoom("125/122", 17);
                controller.addRoom("UU220", 40);
                
                // state.printExams();
                
                controller.seatExams(state.getExams());
                
                controller.printAllRooms();
                
                String outPath = fp.generateOutPath(file.getParent(), file.getName());
                System.out.println(outPath);
                fp.writeToExcelFile(outPath, state.getExams());
              }
            }
        });

    final GridPane inputGridPane = new GridPane();

    GridPane.setConstraints(openButton, 0, 0);
    
    inputGridPane.setHgap(6);
    inputGridPane.setVgap(6);
    inputGridPane.getChildren().addAll(openButton);

    final Pane rootGroup = new VBox(12);
    rootGroup.getChildren().addAll(inputGridPane);
    rootGroup.setPadding(new Insets(12, 12, 12, 12));

    stage.setScene(new Scene(rootGroup));
    stage.show();
  }
  
  private void openFile(File file) {
    try {
      desktop.open(file);
    } catch (IOException ex) {
      Logger.getLogger(
            FileChooser.class.getName()).log(
                Level.SEVERE, null, ex
      );
    }
  }
}
