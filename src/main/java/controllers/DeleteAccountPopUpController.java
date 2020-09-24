package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class DeleteAccountPopUpController {

    @FXML
    public AnchorPane delAccPopUp;


    MainController parent;

    public void initPane(MainController parent) {
        this.parent = parent;
    }


    @FXML
    public void deleteAccountConfirm(ActionEvent actionEvent) {
        parent.showLogInPage();
    }
}