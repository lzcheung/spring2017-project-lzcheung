package main.java.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.java.model.Exam;
import main.java.model.Student;

public class ExamDetailsScene extends Scene {
  
  private static class ExamDetailsVBox extends VBox {
    Exam exam;
    
    public ExamDetailsVBox(Stage stage, Exam exam) {
      this.exam = exam;
      initVBox(stage);
    }
    
    private void initVBox(final Stage stage) {
      final Label requestNumberLabel = new Label("Request #: " + exam.getRequestId());
      requestNumberLabel.setFont(new Font("Arial", 20));
      final Label requestStatusLabel = new Label("Request Status: " + exam.getRequestStatus());
      
      Student student = exam.getStudent();
      final Label studentNameLabel = new Label("Name: " + student.getName());
      final Label studentUsernameLabel = new Label("Username: " + student.getUsername());
      
      final Label seatLabel = new Label("Seat: " + exam.getSeat());
      
      final Label startTimeLabel = 
          new Label("Start time:" + Exam.TIME_FORMAT.format(exam.getStartTime()));
      final Label endTimeLabel =
          new Label("End time: " + Exam.TIME_FORMAT.format(exam.getEndTime()));
      
      final Label professorLabel = new Label("Professor: " + exam.getProfessor());
      final Label classLabel = new Label("Course: " + exam.getCourse());
      final Label allowsLabel = new Label("Instructor Allows: " + exam.getAllows());
      final Label accommodationsLabel = new Label("Accommodations: " + exam.getAccommodations());
      final Label receivedLabel = new Label("Exam Received: " + exam.getExamReceived());
      
      Button closeButton = new Button("Close");
      closeButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(final ActionEvent e) {
          stage.close();
        }
      });
      
      this.setSpacing(10);
      this.setPadding(new Insets(10, 0, 0, 10));
      this.getChildren().addAll(requestNumberLabel, requestStatusLabel, studentNameLabel,
          studentUsernameLabel, seatLabel, startTimeLabel, endTimeLabel, professorLabel,
          classLabel, allowsLabel, accommodationsLabel, receivedLabel, closeButton);
    }
  }

  public ExamDetailsScene(Stage currentStage, Exam exam) {
    super(new ExamDetailsVBox(currentStage, exam), 400, 400);
  }
}
