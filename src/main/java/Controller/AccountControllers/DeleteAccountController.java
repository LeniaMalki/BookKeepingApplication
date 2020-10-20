package Controller.AccountControllers;//NOPMD

import Model.AccountLogic.AccountFacade;
import Controller.Interfaces.ControllerInterface;
import View.AccountView.DeleteAccountView;

/**
 * @author : Lenia Malki
 * Responsibility: Updates and handles the DeleteAccountView through the logic in AccountFacade
 * Used by: PaneFactory
 * Uses: ControllerInterface, AccountFacade, DeleteAccountView
 */
public class DeleteAccountController implements ControllerInterface {

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    private final DeleteAccountView deleteAccountView = DeleteAccountView.getInstance();

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