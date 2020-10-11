package Controller.AccountControllers;

import Controller.MainControllers.MainController;
import Model.AccountLogic.AccountFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

/**
 * Controller changing the account password through account page > changePasswordPopup
 *
 * @author Lenia
 */


public class ChangePasswordPopUpController {
    //________________________________________________ VARIABLES _______________________________________________________

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    MainController parent;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Text textMessage;
    //________________________________________________ Methods _________________________________________________________

    /**
     * initialized this pane
     */
    public void initPane(MainController parent) {
        this.parent = parent;
    }

    /**
     * Goes back to account page when confirming change of password
     */
    @FXML
    void onAction_ConfirmChangePassword_CLICKED() {

        //Checks if new password is valid
        if (accountFacade.checkPassword(newPassword.getText())) {

            //Checks if confirmPassword matches with new
            if (newPassword.getText().equals(confirmPassword.getText())) {
                accountFacade.setAccountPassword(newPassword.getText());
                textMessage.setText("Changes saved! ");
            }
            else textMessage.setText("Password  does not match.");
        } else textMessage.setText("Invalid new password.");

    }
}
