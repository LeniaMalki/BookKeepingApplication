package Controller.AccountControllers;

import Model.AccountLogic.AccountFacade;
import Model.AccountLogic.LogInHandler;
import Model.Interfaces.AccountObserver;
import Model.Interfaces.ControllerInterface;
import View.AccountView.LogInView;

/**
 * Controller for login on login page
 *
 * @author Lenia
 */

public class LogInPageController implements AccountObserver, ControllerInterface {

    private final LogInHandler logInHandler = new LogInHandler() {
        public boolean logIn(String accountName, String password) {
            return super.logIn(accountName, password);
        }
    };

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    private final LogInView logInView = LogInView.getInstance();


    //________________________________________________ Methods _________________________________________________________

    public LogInPageController() {
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
        if (accountFacade.getAccountEmail() != null) {
            accountFacade.sendPasswordToEmail();
            logInView.setMessage("An email with your password has been sent to you!");
        } else logInView.setMessage("No user registered!");
    }

    /**
     * Handles the mouse action of opening up the signup pop up. The pop up is disabled if an account already exists by
     * checking if there instance of account has a name assigned to it.
     */
    private void signUpButton() {
        if (accountFacade.getAccountName() == null) {
            logInView.showSignUpPopUp();
        } else logInView.setMessage("An account already exists!");

    }

    /**
     * Handles the mouse action of logging in to the first page. The logic of checking log in fields is partly managed
     * by the account facade and logInHandler.
     */
    private void onLoginClicked() {
        if (accountFacade.getAccountName() == null) {
            logInView.setMessage("No user registered!");
        } else if (logInHandler.logIn(logInView.usernameField.getText(), logInView.logInField.getText())) {
            logInView.setMessage("");
            logInView.clearLogInFields();
            logInView.parent.showFirstPage();
        } else logInView.setMessage("Wrong/missing input(s)!");
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
