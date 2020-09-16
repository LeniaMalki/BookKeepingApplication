package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class signUpPageController extends Node {


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

    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("signUpPopUp.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

