package controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class firstPageController {

    @FXML
    private Button newEntryButton;

    @FXML
    private Button newBudgetButton;

    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
