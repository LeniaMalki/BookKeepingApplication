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



    //Opens up/going back to first page when pressing on the Logo i.e. works as an escape hatch
    public void escapeHatchHandler(ActionEvent actionEvent) throws IOException {
        Parent startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/firstPage.fxml"));
        Scene startScene = new Scene(startParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();

    }


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
    private void escapeHatch(ActionEvent event) throws IOException {

        Parent startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/firstPage.fxml"));
        Scene startScene = new Scene(startParent);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();
    }
    }


