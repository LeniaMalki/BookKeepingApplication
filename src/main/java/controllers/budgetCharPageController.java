package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class budgetCharPageController {

    @FXML
    private Button editBudgetButton;

    @FXML
    private Button addNewBudgetButton;


    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("budgetCharPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
