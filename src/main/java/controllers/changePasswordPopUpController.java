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


public class changePasswordPopUpController {

    @FXML
    private AnchorPane changePasswordPopUp;
    @FXML
    private PasswordField signUpPassword;
    @FXML
    private PasswordField signUpConfirmPassword;
    @FXML
    private ImageView newPasswordCheck;
    @FXML
    private ImageView confirmNewPasswordCheck;
    @FXML
    private Button changePasswordConfirm;

    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("changePasswordPopUp.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //Goes back to account page when confirming change of password
    @FXML
    void onAction_ConfirmChangePassword_CLICKED(ActionEvent event) throws Exception {
        Parent startParent = FXMLLoader.load(getClass().getResource("/org/openjfx/accountPage.fxml"));
        Scene startScene = new Scene(startParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(startScene);
        window.show();
    }


}
