package main.java.ui;

import java.util.Date;
import java.util.List;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.java.controller.DataSingleton;
import main.java.controller.FileProcessor;
import main.java.model.Exam;

import org.controlsfx.control.table.TableFilter;

public class TableScene extends Scene {
  private static class TableSceneVBox extends VBox {
    private TableView<Exam> table;
    private DataSingleton data;
    
    public TableSceneVBox(Stage stage, String outFilePath) {
      table = new TableView<>();
      data = DataSingleton.getInstance();
      initVBox(stage, outFilePath);
    }
    
    private void initVBox(final Stage stage, final String outFilePath) {
      final Label title = new Label("Exams");
      title.setFont(new Font("Arial", 20));
      
      final Label instruction = new Label("Right click column name to filter table.");

      table.setEditable(true);

      TableColumn<Exam, Integer> reqIdCol = new TableColumn<>("REQ #");
      reqIdCol.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("requestId"));
      TableColumn<Exam, String> seatCol = new TableColumn<>("LOCATION/SEAT");
      seatCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("seatName"));
      TableColumn<Exam, String> studentNameCol = new TableColumn<>("STUDENT");
      studentNameCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("studentName"));
      TableColumn<Exam, Date> startTimeCol = new TableColumn<>("START TIME");
      startTimeCol.setCellValueFactory(new PropertyValueFactory<Exam, Date>("startTime"));
      TableColumn<Exam, Date> endTimeCol = new TableColumn<>("END TIME");
      endTimeCol.setCellValueFactory(new PropertyValueFactory<Exam, Date>("endTime"));
      TableColumn<Exam, String> usernameCol = new TableColumn<>("STUDENT USERNAME");
      usernameCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("studentUsername"));
      
      table.setItems(getExams());
      table.getColumns().add(reqIdCol);
      table.getColumns().add(studentNameCol);
      table.getColumns().add(usernameCol);
      table.getColumns().add(startTimeCol);
      table.getColumns().add(seatCol);
      table.getColumns().add(endTimeCol);
      
      TableFilter tableFilter = new TableFilter(table);
      
      Button detailsButton = new Button("Expand Selection");
      detailsButton.setOnAction(
          new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
              Exam exam = table.getSelectionModel().getSelectedItem();
              Stage details = new Stage();
              details.setScene(new ExamDetailsScene(details, exam));
              details.setTitle("Exam Details");
              details.showAndWait();
            }
        });
      
      Button exportButton = new Button("Export");
      exportButton.setOnAction(
          new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
              FileProcessor.writeToExcelFile(outFilePath, data.getExams());
              stage.setScene(new FinishScene(stage));
            }
        });

      this.setSpacing(8);
      this.setPadding(new Insets(10, 0, 0, 10));
      this.getChildren().addAll(title, instruction, table, detailsButton, exportButton);
    }
    
    private ObservableList<Exam> getExams() {
      ObservableList<Exam> examsObservableList = FXCollections.observableArrayList();
      List<Exam> examsList = data.getExams();
      
      for (Exam exam: examsList) {
        examsObservableList.add(exam);
      }
      return examsObservableList;
    }
  }

  public TableScene(Stage stage, String outFilePath) {
    super(new TableSceneVBox(stage, outFilePath), 880, 600);
  }

}
