package Controller.AccountControllers;//NOPMD

import Controller.Interfaces.ControllerInterface;
import Model.AccountLogic.AccountFacade;
import StairwayInterfaces.iAccountFacade;
import View.AccountView.ChangePasswordView;

/**
 * @author : Lenia Malki
 * Responsibility: Updates and handles the Password through the logic in AccountFacade
 * Used by: PaneFactory
 * Uses: ControllerInterface, iAccountFacade, ChangePasswordView
 */
public class PasswordEditController implements ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________
    private final iAccountFacade accountFacade = AccountFacade.getInstance();
    private final ChangePasswordView changePasswordView = ChangePasswordView.getInstance();//NOPMD

    //________________________________________________ Methods _________________________________________________________

    /**
     * Constructor
     */
    public PasswordEditController() {
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

    /**
     * Sets fxml listeners of ChangePasswordView
     */
    @Override
    public void setAllViewListeners() {
        changePasswordView.confirmChangeButton.setOnAction(e -> onChangePasswordClicked());
    }
}
