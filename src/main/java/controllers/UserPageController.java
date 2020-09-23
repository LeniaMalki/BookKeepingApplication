package controllers;

import Model.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class UserPageController implements iPane {
    MainController parent;
    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private AnchorPane pos_for_popUp_on_accountPage;
    @FXML
    private AnchorPane back;

    @FXML
    private TextField editableUsername;

    @FXML
    private void onDeleteAccountLinkPressed(ActionEvent event) throws IOException {
        pos_for_popUp_on_accountPage.getChildren().clear();
        pos_for_popUp_on_accountPage.getChildren().add(parent.getDeleteAccountPopUp());
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        pos_for_popUp_on_accountPage.toFront();

    }

    @FXML
    private void onChangePasswordLinkPressed(ActionEvent event) throws IOException {
        pos_for_popUp_on_accountPage.getChildren().clear();
        pos_for_popUp_on_accountPage.getChildren().add(parent.getChangePasswordPopUp());
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        pos_for_popUp_on_accountPage.toFront();

    }


    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }


}
