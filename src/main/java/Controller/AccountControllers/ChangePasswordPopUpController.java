package Controller.AccountControllers;//NOPMD

import Model.AccountLogic.AccountFacade;
import Model.Interfaces.ControllerInterface;
import View.AccountView.ChangePasswordView;

/**
 * Controller changing the account password through account page of changePasswordPopup
 * @author Lenia
 */


public class ChangePasswordPopUpController implements ControllerInterface {
    //________________________________________________ VARIABLES _______________________________________________________

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    private final ChangePasswordView changePasswordView = ChangePasswordView.getInstance();//NOPMD


    //________________________________________________ Methods _________________________________________________________

    public ChangePasswordPopUpController() {
        setAllViewListeners();
    }


    /**
     * Goes back to account page when confirming change of password
     */

    private void onChangePasswordClicked() {

        //Checks if new password is valid
        if (accountFacade.isValidPasswordFormat(changePasswordView.newPassword.getText())) {

            //Checks if confirmPassword matches with new
            if (changePasswordView.newPassword.getText().equals(changePasswordView.confirmPassword.getText())) {

                accountFacade.updateAccountPassword(changePasswordView.newPassword.getText());
                changePasswordView.setMessage("correct");
            } else {
                changePasswordView.setMessage("noMatch");
            }
        } else {
            changePasswordView.setMessage("invalid");
        }
    }

    @Override
    public void setAllViewListeners() {
        changePasswordView.confirmChangeButton.setOnAction(e -> onChangePasswordClicked());
    }
}
