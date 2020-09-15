package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class headerController {
    @FXML
    private AnchorPane header;
    @FXML
    private Hyperlink logo;
    @FXML
    private Hyperlink homeButton;
    @FXML
    private Hyperlink entryButton;
    @FXML
    private Hyperlink statisticsButton;
    @FXML
    private Hyperlink budgetButton;
    @FXML
    private Hyperlink goalsButton;
    @FXML
    private Hyperlink nameHyperlink;


    //Handles the different menu buttons and gets user from one menu page to another
    @FXML
    private void onAction_headerMenu_CLICKED(ActionEvent event) throws IOException {
        Parent startParent;
        if (homeButton.equals(event.getTarget()) || logo.equals(event.getTarget())) {
            startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/firstPage.fxml"));
        } else if (budgetButton.equals(event.getTarget())) {
            startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/bugetCharPage.fxml"));
        } else if (entryButton.equals(event.getTarget())) {
            startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/entryPage.fxml"));
        } else if (statisticsButton.equals(event.getTarget())) {
            startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/statisticsOverviewPage.fxml"));
        } else if (nameHyperlink.equals(event.getTarget())) {
            startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/accountPage.fxml"));
        } else {
            throw new IllegalStateException("Unexpected value: " + event.getTarget());
        }
        Scene startScene = new Scene(startParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();
    }
}


