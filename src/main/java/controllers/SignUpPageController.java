package controllers;

import Model.Interfaces.UserObserver;
import Model.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SignUpPageController implements UserObserver {

    public AnchorPane signUpPopUp;
    MainController parent;
    private MainModel mainModel;
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


    @FXML
    private void createAccount(ActionEvent event) throws IOException {
        parent.showFirstPage();
    }

    public void initPane(MainModel mainModel) {

        this.mainModel = mainModel;
        mainModel.add(this);

    }

    public void initPane(MainController parent) {
        this.parent = parent;
    }

    @Override
    public void notifed() {
        updateUserName();

    }

    private void updateUserName() {
        mainModel.setUsername(signUpUsername.toString());
    }

}