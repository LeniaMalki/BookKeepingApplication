package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class logInPageController {

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

    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("logInPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


}



