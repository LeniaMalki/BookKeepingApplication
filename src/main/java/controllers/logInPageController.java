package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    private void loadFirstPage(ActionEvent event) throws IOException {
        Parent startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/firstPage.fxml"));
        Scene startScene = new Scene(startParent);


        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();
    }


}



