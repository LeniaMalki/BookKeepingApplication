package Controller.AccountControllers;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Model.AccountLogic.AccountFacade;
import Model.AccountLogic.LogInHandler;
import Model.Interfaces.AccountObserver;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * Controller for login on login page
 * @author Lenia
 */

public class LogInPageController implements iPane, AccountObserver {

    private final LogInHandler logInHandler = new LogInHandler() {
        public boolean logIn(String accountName, String password) {
            return super.logIn(accountName, password);
        }
    };

    private final AccountFacade accountFacade = AccountFacade.getInstance();

    @FXML
    public AnchorPane pos_for_popUp_on_LogInPage;
    @FXML
    public AnchorPane back;
    @FXML
    public AnchorPane logInContent;
    private MainController parent;
    @FXML
    private TextField logInField;
    @FXML
    private TextField usernameField;
    @FXML
    private Text message;

    //________________________________________________ Methods _________________________________________________________

    /**
     * initialized this pane
     */
    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        accountFacade.add(this);
    }

    /**
     * Handles the mouse action of opening up the signup pop up. The pop up is disabled if an account already exists by
     * checking if there instance of account has a name assigned to it.
     */
    @FXML
    private void signUpButton() {

        if (accountFacade.getAccountName() == null) {
            back.setVisible(true);
            pos_for_popUp_on_LogInPage.setVisible(true);

            pos_for_popUp_on_LogInPage.getChildren().clear();
            pos_for_popUp_on_LogInPage.getChildren().add(parent.getSignUpPopUp());
            back.toFront();
            back.setStyle("-fx-background-color: #000000");
            back.setOpacity(0.5);
            pos_for_popUp_on_LogInPage.toFront();
        } else message.setText("An account already exists! ");

    }

    /**
     * Handles the mouse action of logging in to the first page. The logic of checking log in fields is partly managed
     * by the account facade and logInHandler.
     */
    @FXML
    private void onLoginClicked() {
        if (accountFacade.getAccountName() == null) {
            message.setText("No user registered!");
        } else if (logInHandler.logIn(usernameField.getText(), logInField.getText())) {
            message.setText("");
            clearLogInFields();
            parent.showFirstPage();
        }
        else message.setText("Wrong/missing input(s)! ");
    }

    /**
     * Graphic method to hide pop ups
     */
    @FXML
    private void hidePopUp() {
        back.setVisible(false);
        pos_for_popUp_on_LogInPage.setVisible(false);
        logInContent.toFront();
    }

    /**
     * Whenever a user gets registered, the signup page is hidden
     */
    @Override
    public void update() {
        hidePopUp();
        message.setText("");
    }

    /**
     * Clears all textFields on Login page pop up
     */
    private void clearLogInFields() {
        this.usernameField.clear();
        this.logInField.clear();
    }
}
