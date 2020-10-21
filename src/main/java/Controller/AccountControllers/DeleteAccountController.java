package Controller.AccountControllers;//NOPMD

import Controller.Interfaces.ControllerInterface;
import StairwayInterfaces.iAccountFacade;
import Model.AccountLogic.AccountFacade;
import View.AccountView.DeleteAccountView;

/**
 * @author : Lenia Malki
 * Responsibility: Updates and handles the DeleteAccountView through the logic in AccountFacade
 * Used by: PaneFactory
 * Uses: ControllerInterface, iAccountFacade, DeleteAccountView
 */
public class DeleteAccountController implements ControllerInterface {

    //________________________________________________ Variables _______________________________________________________
    private final iAccountFacade accountFacade = AccountFacade.getInstance();
    private final DeleteAccountView deleteAccountView = DeleteAccountView.getInstance();

    //---------------------------------------------------- METHODS -----------------------------------------------------

    /**
     * Constructor
     */
    public DeleteAccountController() {
        setAllViewListeners();//NOPMD
    }

    @Override
    public void setAllViewListeners() {
        deleteAccountView.deleteAccountButton.setOnAction(e -> onConfirmDeleteClicked());
    }

    /**
     * Handles the mouse action of deleting and account by delegation to AccountFacade's methods for deletion
     */
    private void onConfirmDeleteClicked() {
        if (accountFacade.doesPasswordMatchWithAccount(deleteAccountView.password.getText())) {
            accountFacade.deleteAccount();
            deleteAccountView.parent.showLogInPage();
        } else {
            deleteAccountView.setMessage();
        }

    }
}