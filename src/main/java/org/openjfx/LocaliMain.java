package org.openjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LocaliMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);

        Parent root = FXMLLoader.load(getClass().getResource("logInPage.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Locali");
        stage.setScene(scene);
        stage.show();
    }

}
