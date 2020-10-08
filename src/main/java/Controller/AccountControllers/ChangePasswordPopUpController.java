package Controller.AccountControllers;
import Model.AccountLogic.AccountFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import Controller.MainControllers.MainController;



public class ChangePasswordPopUpController {

    MainController parent;
    private final AccountFacade accountFacade = AccountFacade.getInstance();

    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Text textMessage;

    public void initPane(MainController parent) {
        this.parent = parent;
    }


    //Goes back to account page when confirming change of password
    @FXML
    void onAction_ConfirmChangePassword_CLICKED ()   {

            //Checks if new password is valid
            if (accountFacade.setAccountPassword(newPassword)) {

                //Checks if confirmPassword matches with new
                if (newPassword.getText().equals(confirmPassword.getText()))  {
                    accountFacade.setAccountPassword(newPassword);
                    textMessage.setText("Changes saved! ");
                }
                else textMessage.setText("Password  does not match.");
            }
            else textMessage.setText("Invalid new password.");

    }


}
