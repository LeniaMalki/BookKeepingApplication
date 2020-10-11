package Controller.AccountControllers;

import Controller.MainControllers.MainController;
import Model.AccountLogic.AccountFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * Controller for deleting the account through account page of deleteAccountPopup
 *
 * @author Lenia
 */
public class DeleteAccountPopUpController {

    //________________________________________________ VARIABLES _______________________________________________________

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    @FXML
    public AnchorPane delAccPopUp;
    MainController parent;
    @FXML
    private PasswordField enterPasswordToDelete;
    @FXML
    private Text passwordIncorrectMessage;

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
    private void deleteAccountConfirm() {

        if (accountFacade.checkPasswordMatch(enterPasswordToDelete.getText())) {
            accountFacade.deleteAccount();
            parent.showLogInPage();
        } else
            passwordIncorrectMessage.setText("Password is incorrect! Try again.");


    }

}