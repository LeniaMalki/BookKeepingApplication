package Controller.AccountControllers;

import Model.AccountLogic.AccountFacade;
import View.AccountView.ChangePasswordView;

/**
 * Controller changing the account password through account page of changePasswordPopup
 * @author Lenia
 */


public class ChangePasswordPopUpController {
    //________________________________________________ VARIABLES _______________________________________________________

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    private final ChangePasswordView changePasswordView = ChangePasswordView.getInstance();


    //________________________________________________ Methods _________________________________________________________

    public ChangePasswordPopUpController() {
        setAllViewListeners();
    }

    private void setAllViewListeners() {
        changePasswordView.confirmChangeButton.setOnAction(e -> onChangePasswordClicked());
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
            } else changePasswordView.setMessage("noMatch");
        } else changePasswordView.setMessage("invalid");
    }
}
