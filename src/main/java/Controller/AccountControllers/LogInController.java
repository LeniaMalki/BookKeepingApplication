package Controller.AccountControllers;//NOPMD

import Controller.Interfaces.ControllerInterface;
import Interfaces.iAccountFacade;
import Model.AccountLogic.AccountFacade;
import Model.AccountLogic.LogInHandler;
import Model.Interfaces.AccountObserver;
import View.AccountView.LogInView;

/**
 * @author : Lenia Malki
 * Responsibility: Updates and handles the LogInPage through the logic in AccountFacade
 * Used by: PaneFactory
 * Uses: ControllerInterface, AccountObserver,  AccountFacade, LogInView, LogInHandler
 */
public class LogInController implements AccountObserver, ControllerInterface {

    private final LogInHandler logInHandler = new LogInHandler() {
        public boolean logIn(final String accountName, final String password) {
            return super.logIn(accountName, password);
        }
    };

    private final iAccountFacade accountFacade = AccountFacade.getInstance();
    private final LogInView logInView = LogInView.getInstance();


    //________________________________________________ Methods
    // _________________________________________________________//NOPMD

    public LogInController() {
        accountFacade.add(this);
        setAllViewListeners();
    }

    @Override
    public void setAllViewListeners() {
        logInView.signUpLink.setOnAction(e -> signUpButton());
        logInView.logInButton.setOnAction(event -> onLoginClicked());
        logInView.forgotPassword.setOnAction(event -> sendForgottenPasswordToEmail());
    }

    /**
     * sends an email to the user with their password if the user exists
     */
    private void sendForgottenPasswordToEmail() {
        final String accountEmail = accountFacade.getAccountEmail();

        if (accountEmail == null) {
            logInView.setMessage("No user registered!");
        } else {
            accountFacade.sendPasswordToEmail();
            logInView.setMessage("An email with your password has been sent to you!");
        }
    }

    /**
     * Handles the mouse action of opening up the signup pop up. The pop up is disabled if an account already exists
     * by//NOPMD checking if there instance of account has a name assigned to it.
     */
    private void signUpButton() {
        if (accountFacade.getAccountName() == null) {
            logInView.showSignUpPopUp();
        } else {
            logInView.setMessage("An account already exists!");
        }

    }

    /**
     * Handles the mouse action of logging in to the first page. The logic of checking log in fields is partly
     * managed//NOPMD by the account facade and logInHandler.
     */
    private void onLoginClicked() {
        logInView.parent.showFirstPage();
        if (accountFacade.getAccountName() == null) {
            logInView.setMessage("No user registered!");
        } else if (logInHandler.logIn(logInView.usernameField.getText(), logInView.logInField.getText())) {
            logInView.setMessage("");
            logInView.clearLogInFields();
            logInView.parent.showFirstPage();
        } else {
            logInView.setMessage("Wrong/missing input(s)!");
        }
    }

    /**
     * Whenever a user gets registered, the signup page is hidden
     */
    @Override
    public void update() {
        logInView.hidePopUp();
        logInView.setMessage("");
    }

}
