package Controller.AccountControllers;

import Controller.MainControllers.MainController;
import Model.AccountLogic.AccountFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

/**
 * Controller for deleting the account through account page of deleteAccountPopup
 * @author Lenia
 */
public class DeleteAccountPopUpController {

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    //________________________________________________ VARIABLES _______________________________________________________
    @FXML
    private PasswordField password;
    @FXML
    private Text textMessage;
    private MainController parent;

    //________________________________________________ Methods _________________________________________________________

    /**
     * initialized this pane
     */
    public void initPane(MainController parent) {
        this.parent = parent;
    }

    /**
     * Handles the mouse action of deleting and account by delegation to AccountFacade's methods for deletion
     */
    @FXML
    private void onConfirmDeleteClicked() {

        if (accountFacade.doesPasswordMatchWithAccount(password.getText())) {
            accountFacade.deleteAccount();
            parent.showLogInPage();
        } else
            textMessage.setText("Password is incorrect! Try again.");
    }
}