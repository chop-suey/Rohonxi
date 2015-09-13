package ch.woggle.rohonxi;

import java.io.IOException;

import ch.woggle.rohonxi.view.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {
  private Stage primaryStage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Rohonxi");

    showMainView();
  }

  private void showMainView() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));

      AnchorPane pane = (AnchorPane) loader.load();

      MainViewController controller = loader.getController();
      controller.setMainApp(this);

      Scene scene = new Scene(pane);
      primaryStage.setScene(scene);

      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }
}
