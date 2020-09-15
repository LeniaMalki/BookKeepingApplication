package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class logInPageController implements ChildPane {
    mainController parent;

    @FXML
    private PasswordField logInField;

    @FXML
    private TextField usernameField;

    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private Button logInButton;

    @FXML
    private Hyperlink signUpLink;



    @FXML
    private void loadFirstPage(ActionEvent event) throws IOException {
        parent.showFirstPage();
    }

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
    }
}



