package Controller.AccountControllers;

import Controller.MainControllers.MainController;
import Model.AccountLogic.AccountFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class DeleteAccountPopUpController {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    private final AccountFacade accountFacade = AccountFacade.getInstance();

    //________________________________________________ FXML ____________________________________________________________
    @FXML
    public AnchorPane delAccPopUp;
    @FXML
    private PasswordField enterPasswordToDelete;
    @FXML
    private Text passwordIncorrectMessage;

    //________________________________________________ Methods _________________________________________________________

    public void initPane(MainController parent) {
        this.parent = parent;
    }

    @FXML
    private void deleteAccountConfirm() {

        if (accountFacade.checkPasswordMatch(enterPasswordToDelete.getText())) {
            accountFacade.deleteAccount();
            parent.showLogInPage();
        } else
            passwordIncorrectMessage.setText("Password is incorrect! Try again.");


    }

}