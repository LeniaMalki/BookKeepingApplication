package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class deleteAccountPopUpController {

    @FXML
    private AnchorPane deleteAccountPopUp;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private ImageView exitButton;

    @FXML
    private PasswordField enterPasswordToDelete;


    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("deleteAcountPopUp.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //Takes user back to logInPage when confirming to delete account
    @FXML
    void onAction_ConfirmDeleteAccount_CLICKED(ActionEvent event) throws Exception {

        Parent startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/logInPage.fxml"));
        Scene startScene = new Scene(startParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();

    }
}