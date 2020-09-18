package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class deleteAccountPopUpController {

    @FXML
    public AnchorPane delAccPopUp;


    mainController parent;

    public void initPane(mainController parent) {
        this.parent = parent;
    }


    @FXML
    public void deleteAccountConfirm(ActionEvent actionEvent) {
        parent.showLogInPage();
    }
}
