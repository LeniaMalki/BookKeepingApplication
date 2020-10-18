package Controller.AccountControllers;

import Model.AccountLogic.AccountFacade;
import Model.Interfaces.ControllerInterface;
import View.AccountView.DeleteAccountView;

/**
 * Controller for deleting the account through account page of deleteAccountPopup
 * @author Lenia
 */
public class DeleteAccountPopUpController implements ControllerInterface {

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    private final DeleteAccountView deleteAccountView = DeleteAccountView.getInstance();

    public DeleteAccountPopUpController() {
        setAllViewListeners();
    }
    @Override
    public void setAllViewListeners() {
        deleteAccountView.deleteAccountButton.setOnAction(e -> onConfirmDeleteClicked());
    }

    /**
     * Handles the mouse action of deleting and account by delegation to AccountFacade's methods for deletion
     */
    private void onConfirmDeleteClicked() {
        System.out.println("startDel");

        if (accountFacade.doesPasswordMatchWithAccount(deleteAccountView.password.getText())) {
            accountFacade.deleteAccount();
            deleteAccountView.parent.showLogInPage();
            System.out.println("correct but not :) ");
        }
        else deleteAccountView.setMessage();
        System.out.println("erorr");
    }
}