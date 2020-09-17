package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpPageController extends Node {


    public AnchorPane signUpPopUp;
    @FXML
    private TextField signUpName;
    @FXML
    private TextField signUpUsername;
    @FXML
    private PasswordField signUpPassword;
    @FXML
    private PasswordField signUpConfirmPassword;
    @FXML
    private ImageView confirmPasswordIcon;
    @FXML
    private TextField signUpEmail;
    @FXML
    private ImageView signUpEmailIcon;
    @FXML
    private ImageView signUpEmailIcon1;
    @FXML
    private ImageView signUpNameIcon;
    @FXML
    private Button createAccount;

    mainController parent;

    @FXML
    private void createAccount (ActionEvent event) throws IOException{
        parent.showFirstPage();


    }

    public void initPane(mainController parent) {
        this.parent = parent;


    }
}

