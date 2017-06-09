package main.java.ui;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.java.controller.DataSingleton;
import main.java.controller.FileProcessor;
import main.java.model.Room;

public class ImportFileScene extends Scene {
  
  private static class ModifiedVBox extends VBox {
    private TableView<Room> roomTable;
    private DataSingleton data;
    private ObservableList<Room> roomObservableList;
    private File file;
    
    public ModifiedVBox(final Stage stage) {
      this.roomTable = new TableView<>();
      this.data = DataSingleton.getInstance();
      this.roomObservableList = FXCollections.observableArrayList();
      this.file = null;
      init(stage);
    }
    
    private void init(final Stage stage) {
      final FileChooser fileChooser = new FileChooser();
      
      final Label titleLabel = new Label("List of Rooms:");
      titleLabel.setFont(new Font("Arial", 20));
      
      GridPane roomPane = new GridPane();
      roomPane.setPadding(new Insets(10, 10, 10, 10));
      roomPane.setVgap(20);
      roomPane.setHgap(20);
      
      final Label addRoomLabel = new Label("Add Room: ");
      GridPane.setConstraints(addRoomLabel, 0, 0);
      
      final TextField roomNameField = new TextField();
      roomNameField.setPromptText("Name");
      GridPane.setConstraints(roomNameField, 1, 0);
      
      final TextField roomCapacityField = new TextField();
      roomCapacityField.setPromptText("Capacity");
      GridPane.setConstraints(roomCapacityField, 2, 0);
      
      final Label errorLabel = new Label();
      GridPane.setConstraints(errorLabel, 0, 2);
      
      final Button addRoomButton = new Button("Add");
      addRoomButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(final ActionEvent e) {
          if (validateCapacity(roomCapacityField.getText())) {
            int capacity = Integer.parseInt(roomCapacityField.getText());
            Room room = new Room(roomNameField.getText(), capacity);
            data.addRoom(room);
            roomObservableList.add(room);
            errorLabel.setText("");
            roomTable.getColumns().clear();
            initRoomTable();
          } else {
            errorLabel.setText("Invalid room name or capacity value.");
          }
        }
      });
      GridPane.setConstraints(addRoomButton, 3, 0);
      
      roomPane.getChildren().addAll(addRoomLabel, roomNameField, 
          roomCapacityField, addRoomButton);

      final Label filePathLabel = new Label();
      final Label sortLabel = new Label();
      
      final Button openButton = new Button("Select Excel file.");
      openButton.setOnAction(
          new EventHandler<ActionEvent>() {
              @Override
              public void handle(final ActionEvent e) {
                file = fileChooser.showOpenDialog(stage);
                if (file != null && file.getName().endsWith(".xlsx")) {
                  filePathLabel.setText(file.getAbsolutePath());
                  sortLabel.setText("");
                } else {
                  filePathLabel.setText("Invalid File");
                }
              }
          });
      
      GridPane.setConstraints(openButton, 0, 1);
      GridPane.setConstraints(filePathLabel, 1, 1);
      
      GridPane inputGridPane = new GridPane();
      inputGridPane.setHgap(20);
      inputGridPane.setVgap(20);
      inputGridPane.getChildren().addAll(openButton, filePathLabel);
      
      final Button sortButton = new Button("Sort");
      sortButton.setOnAction(
          new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
              if (file == null) {
                sortLabel.setText("Select a file");
              } else {
                String path = file.getAbsolutePath();
                FileProcessor fp = new FileProcessor();

                fp.readFile(path, data);

                data.getRoomManager().seatExams(data.getExams());
                
                String outPath = fp.generateOutPath(file.getParent(), file.getName());

                stage.setScene(new TableScene(stage, outPath));
              }
            }
          });
      
      GridPane.setConstraints(sortButton, 0, 1);
      GridPane.setConstraints(sortLabel, 1, 1);
      
      GridPane sortGridPane = new GridPane();
      sortGridPane.setHgap(20);
      sortGridPane.setVgap(20);
      sortGridPane.getChildren().addAll(sortButton, sortLabel);
      
      initRoomTable();
      
      this.setPadding(new Insets(12, 12, 12, 12));
      this.getChildren().addAll(titleLabel, roomPane, errorLabel, 
          roomTable, inputGridPane, sortGridPane);
      
    }
    
    private boolean validateCapacity(String capacity) {
      Boolean isValid = false;
      try {
        int value = Integer.parseInt(capacity);
        if (value > 0) {
          isValid = true;
        }
      } catch (NumberFormatException e) {
        isValid = false;
      }
      return isValid;
    }
    
    private void initRoomTable() {
      roomTable.setEditable(true);
      
      TableColumn<Room, String> roomNameCol = new TableColumn<>("Room Name");
      roomNameCol.setCellValueFactory(new PropertyValueFactory<Room, String>("roomName"));
      roomNameCol.prefWidthProperty().bind(roomTable.widthProperty().multiply(0.3));
      TableColumn<Room, Integer> capacityCol = new TableColumn<>("Capacity");
      capacityCol.setCellValueFactory(new PropertyValueFactory<Room, Integer>("capacity"));
      
      roomTable.setItems(roomObservableList);
      roomTable.getColumns().add(roomNameCol);
      roomTable.getColumns().add(capacityCol);
    }
  }
  
  public ImportFileScene(final Stage stage) {
    super(new ModifiedVBox(stage));
  }

}
