package Controller.AccountControllers;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.AccountLogic.AccountFacade;
import Model.Interfaces.AccountObserver;
import Controller.Interfaces.iPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * Handles the view for an account page.
 * Listens to changes made to an Account object by implementing AccountObserver.
 */
public class AccountPageController implements iPane, AccountObserver {

    //________________________________________________ VARIABLES _______________________________________________________
    AccountFacade accountFacade = AccountFacade.getInstance();
    MainController parent;

    //________________________________________________ FXML ____________________________________________________________
    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private AnchorPane popUpPosition;
    @FXML
    private AnchorPane back;
    @FXML
    private TextField usernameSetting;
    @FXML
    private TextField nameSetting;
    @FXML
    private TextField emailSetting;
    @FXML
    private Text textMessage;

    //________________________________________________ Methods _________________________________________________________

    @FXML
    private void openDeleteAccountPop() {
        popUpHandler();
        popUpPosition.getChildren().add(parent.getDeleteAccountPopUp());
    }

    @FXML
    private void openChangePasswordPop() {
        popUpHandler();
        popUpPosition.getChildren().add(parent.getChangePasswordPopUp());
    }

    /**
     * Handles image view for opening a pop up on account page
     */
    private void popUpHandler() {
        back.setVisible(true);
        popUpPosition.setVisible(true);
        popUpPosition.getChildren().clear();
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        popUpPosition.toFront();
    }

    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        accountFacade.add(this);

    }

    /**
     * Handles the account page fields name, username and email when an Account object has been created
     */
    @Override
    public void update() {
        setAccountFields();
    }

    /**
     * Sets the account page fields name, through delegation, username and email when an Account object has been created
     */
    private void setAccountFields() {
        this.usernameSetting.setText(accountFacade.getAccountUsername());
        this.nameSetting.setText(accountFacade.getAccountName());
        this.emailSetting.setText(accountFacade.getAccountEmail());
    }

    /**
     * Handles color of "Submit Changes" button
     */
    @FXML
    private void onActionSubmitChangesButton() {
        if (accountFacade.getAccountUsername().equals(usernameSetting.getText()) && accountFacade.getAccountName().equals(nameSetting.getText()) && accountFacade.getAccountEmail().equals(emailSetting.getText())) {
            textMessage.setText("No changes made.");
        }

        else if (accountFacade.isAccountPageFieldsCorrect(usernameSetting, nameSetting, emailSetting)) {
            accountFacade.setAccountUsername  (usernameSetting) ;
            accountFacade.setAccountName(nameSetting);
            accountFacade.setAccountEmail(emailSetting);
            textMessage.setText("Changes saved!");
        }
        else {
            textMessage.setText("Incorrect input(s)!");
        }


    }

    @FXML
    private void signOutAction () {
        parent.showLogInPage();
    }

    @FXML
    private void hidePopUp() {
        back.setVisible(false);
        popUpPosition.setVisible(false);
        headerAnchorPane.toFront();
    }

}
