package main.java.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinishScene extends Scene {
  private static class FinishGridPane extends GridPane {
    public FinishGridPane(final Stage stage) {
      Label doneLabel = new Label("Finished.");
      doneLabel.setFont(new Font("Arial", 14));
      GridPane.setConstraints(doneLabel, 0, 0);
      
      Button closeButton = new Button("Close");
      closeButton.setOnAction(
          new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
              stage.close();
            }
          });
      GridPane.setConstraints(closeButton, 0, 1);
      
      this.setAlignment(Pos.CENTER);
      this.setVgap(20);
      this.getChildren().addAll(doneLabel, closeButton);
      
    }
  }
  
  public FinishScene(final Stage stage) {
    super(new FinishGridPane(stage), 200, 100);
  }

}
