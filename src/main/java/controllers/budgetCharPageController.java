package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class budgetCharPageController implements Initializable {

    @FXML
    private Button editBudgetButton;

    @FXML
    private Button addNewBudgetButton;
    @FXML
    private AnchorPane headerAnchorPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/header.fxml"));
            headerAnchorPane.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
