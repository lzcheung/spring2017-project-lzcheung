package main.java.ui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.controller.RoomController;
import main.java.controller.DataSingleton;
import main.java.controller.FileProcessor;

public class ImportFileScene extends Scene {
  
  private static class ModifiedVBox extends VBox {
    public ModifiedVBox(final Stage stage) {
      super(12);
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
                  DataSingleton state = DataSingleton.getInstance();
                  RoomController controller = new RoomController();
                  
                  fp.readFile(path, state);
                  
                  controller.addRoom("117/117", 50);
                  controller.addRoom("224/224", 16);
                  controller.addRoom("228/227", 13);
                  controller.addRoom("125/122", 17);
                  controller.addRoom("UU220", 40);
                  
                  controller.seatExams(state.getExams());
                  
                  controller.printAllRooms();
                  
                  stage.setScene(new TableScene(stage));
                }
              }
          });
      
      GridPane inputGridPane = new GridPane();
      
      GridPane.setConstraints(openButton, 0, 0);
      
      inputGridPane.setHgap(20);
      inputGridPane.setVgap(20);
      inputGridPane.getChildren().addAll(openButton);
      
      this.getChildren().addAll(inputGridPane);
      this.setPadding(new Insets(12, 12, 12, 12));
    }
  }
  
  public ImportFileScene(final Stage stage) {
    super(new ModifiedVBox(stage));
  }

}
