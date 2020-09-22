package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class changePasswordPopUpController {

    mainController parent;

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

    public void initPane(mainController parent) {
        this.parent = parent;
    }


    //Goes back to account page when confirming change of password
    @FXML
    void onAction_ConfirmChangePassword_CLICKED(ActionEvent event) throws Exception {
        parent.getChangePasswordPopUp().toBack();
        parent.showAccountPage();

    }


}
