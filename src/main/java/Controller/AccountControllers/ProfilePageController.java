package Controller.AccountControllers;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.AccountLogic.AccountFacade;
import Model.Interfaces.AccountObserver;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * Controller for a handling the image view of the Account Page
 * @author Lenia
 */
public class ProfilePageController implements iPane, AccountObserver {
    //________________________________________________ VARIABLES _______________________________________________________

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    private MainController parent;

    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private AnchorPane popUpPosition;
    @FXML
    private AnchorPane back;
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private Text textMessage;

    //________________________________________________ Methods _________________________________________________________

    /**
     * Initialized the pane for which this controller is connected to Adds itself to the list of observers
     */
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        accountFacade.add(this);

    }

    /**
     * Handles the account page fields name, username and email when an Account object has been created.
     * Sets the account page fields name, through delegation, username and email when an Account object has been
     * created
     */
    @Override
    public void update() {
        username.setText(accountFacade.getAccountUsername());
        name.setText(accountFacade.getAccountName());
        email.setText(accountFacade.getAccountEmail());
    }

    /**
     * Handles color of "Submit Changes" button
     */
    @FXML
    private void onSubmitChangesClicked() {

        int changesMade = accountFacade.handleAccountChanges(username.getText(), name.getText(), email.getText());

        if (changesMade == 0) {
            textMessage.setText("No changes made.");
        }
        if (changesMade>0) {
            accountFacade.updateAccountFields(username.getText(), name.getText(), email.getText());
            textMessage.setText("Changes saved!");
        } if (changesMade == 3){
            textMessage.setText("Incorrect input(s)!");
        }

    }

    /**
     * Handles the action when sign out is clicked
     */
    @FXML
    private void onSignOutClicked() {
        parent.showLogInPage();
    }

    //________________________________________________ PopUps __________________________________________________________

    /**
     * Handles the mouse action for when the delete account link is clicked on
     */
    @FXML
    private void openDeleteAccountPop() {
        popUpHandler();
        popUpPosition.getChildren().add(parent.getDeleteAccountPopUp());
    }

    /**
     * Handles the mouse action for when the change password  link is clicked on
     */
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

    /**
     * Graphic method to hide pop ups
     */
    @FXML
    private void hidePopUp() {
        back.setVisible(false);
        popUpPosition.setVisible(false);
        headerAnchorPane.toFront();
    }

}
