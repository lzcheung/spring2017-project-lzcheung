package main.java.ui;

import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.java.controller.DataSingleton;
import main.java.model.Exam;

public class TableScene extends Scene {
  private static class TableSceneVBox extends VBox {
    private TableView<Exam> table;
    private DataSingleton data;
    
    public TableSceneVBox() {
      table = new TableView<>();
      data = DataSingleton.getInstance();
      initVBox();
    }
    
    private void initVBox() {
      final Label label = new Label("Exams");
      label.setFont(new Font("Arial", 20));

      table.setEditable(true);
      /*
      TableColumn<Exam, String> examReceivedCol = new TableColumn<>("EXAM RECEIVED");
      examReceivedCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("examReceived"));
      TableColumn<Exam, String> professorCol = new TableColumn<>("PROFESSOR");
      professorCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("professor"));
      TableColumn<Exam, String> reqStatusCol = new TableColumn<>("REQUEST STATUS");
      reqStatusCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("requestStatus"));
      TableColumn<Exam, String> accomCol = new TableColumn<>("ACCOMMADATIONS");
      accomCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("accommodations"));
      TableColumn<Exam, Integer> reqIdCol = new TableColumn<>("REQ #");
      reqIdCol.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("requestId"));
      TableColumn<Exam, String> seatCol = new TableColumn<>("LOCATION/SEAT");
      seatCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("seat"));
      TableColumn<Exam, String> studentNameCol = new TableColumn<>("STUDENT");
      studentNameCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("studentName"));
      TableColumn<Exam, Date> startTimeCol = new TableColumn<>("START TIME");
      startTimeCol.setCellValueFactory(new PropertyValueFactory<Exam, Date>("startTime"));
      TableColumn<Exam, Date> endTimeCol = new TableColumn<>("END TIME");
      endTimeCol.setCellValueFactory(new PropertyValueFactory<Exam, Date>("endTime"));
      TableColumn<Exam, String> allowsCol = new TableColumn<>("INSTRUCTOR ALLOWS");
      allowsCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("allows"));
      TableColumn<Exam, String> usernameCol = new TableColumn<>("STUDENT USERNAME");
      usernameCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("studentUsername"));
      
      table.setItems(getExams());
      table.getColumns().addAll(examReceivedCol, 
                                professorCol, 
                                reqStatusCol,
                                accomCol,
                                reqIdCol,
                                seatCol,
                                studentNameCol,
                                startTimeCol,
                                endTimeCol,
                                allowsCol,
                                usernameCol);
                                */

      TableColumn<Exam, Integer> reqIdCol = new TableColumn<>("REQ #");
      reqIdCol.setCellValueFactory(new PropertyValueFactory<Exam, Integer>("requestId"));
      TableColumn<Exam, String> seatCol = new TableColumn<>("LOCATION/SEAT");
      seatCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("seat"));
      TableColumn<Exam, String> studentNameCol = new TableColumn<>("STUDENT");
      studentNameCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("studentName"));
      TableColumn<Exam, Date> startTimeCol = new TableColumn<>("START TIME");
      startTimeCol.setCellValueFactory(new PropertyValueFactory<Exam, Date>("startTime"));
      TableColumn<Exam, Date> endTimeCol = new TableColumn<>("END TIME");
      endTimeCol.setCellValueFactory(new PropertyValueFactory<Exam, Date>("endTime"));
      TableColumn<Exam, String> usernameCol = new TableColumn<>("STUDENT USERNAME");
      usernameCol.setCellValueFactory(new PropertyValueFactory<Exam, String>("studentUsername"));
      
      table.setItems(getExams());
      table.getColumns().addAll(reqIdCol,
                                studentNameCol,
                                usernameCol,
                                startTimeCol,
                                seatCol,
                                endTimeCol);

      this.setSpacing(5);
      this.setPadding(new Insets(10, 0, 0, 10));
      this.getChildren().addAll(label, table);
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

  public TableScene(Stage stage) {
    super(new TableSceneVBox());
    stage.setWidth(880);
    stage.setHeight(500);
  }

}
