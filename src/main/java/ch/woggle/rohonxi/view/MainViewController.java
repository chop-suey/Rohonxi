package ch.woggle.rohonxi.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainViewController {
  @FXML
  private TextArea availableCharacters;
  @FXML
  private TextField rows;
  @FXML
  private TextField columns;
  @FXML
  private TextArea output;
  @FXML
  private Button generateButton;
  @FXML
  private Button exportButton;

  @FXML
  private void initialize() {

  }

  @FXML
  private void handleGenerate() {
    output.appendText(availableCharacters.getText());
    output.appendText("\n");
  }

  @FXML
  private void handleExport() {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Missing functionality");
    alert.setHeaderText("Missing functionality");
    alert.setContentText("The export functionality is not yet implemented.");
    alert.showAndWait();
  }
}
