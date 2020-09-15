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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class logInPageController {

    @FXML
    private AnchorPane logInPage;

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
    private AnchorPane positionForSignUpPopUp;


    @FXML
    private void loadFirstPage(ActionEvent event) throws IOException {
        Parent startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/firstPage.fxml"));
        Scene startScene = new Scene(startParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();
    }

    //Opens up the signUpPopUp when clicking on "Sign Up"-hyperlink
    @FXML
    public void onAction_signUpHyperLink_CLICKED(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/signUpPopUp.fxml"));
        positionForSignUpPopUp.getChildren().setAll(pane);
        positionForSignUpPopUp.toFront();
    }
}



