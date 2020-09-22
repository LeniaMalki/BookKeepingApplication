package controllers;

import Model.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LogInPageController implements iPane {

    MainController parent;
    @FXML
    private AnchorPane back;
    @FXML
    private AnchorPane pos_for_popUp_on_LogInPage;


    @FXML
    private void signUpButton(ActionEvent event) throws IOException {
        pos_for_popUp_on_LogInPage.getChildren().clear();
        pos_for_popUp_on_LogInPage.getChildren().add(parent.getSignUpPopUp());
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        pos_for_popUp_on_LogInPage.toFront();

    }

    @FXML
    private void loadFirstPage(ActionEvent event) throws IOException {
        parent.showFirstPage();
    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
    }
}



