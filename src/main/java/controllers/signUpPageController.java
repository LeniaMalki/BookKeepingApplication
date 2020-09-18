package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class signUpPageController extends Node {


    public AnchorPane signUpPopUp;

    mainController parent;

    @FXML
    private void createAccount(ActionEvent event) throws IOException {
        parent.showFirstPage();


    }

    public void initPane(mainController parent) {
        this.parent = parent;


    }
}

