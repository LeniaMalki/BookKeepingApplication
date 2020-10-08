package Model.AccountLogic;


import javafx.scene.control.TextField;

/**
 * A class that handles the logic of login in to logIn page
 *
 * @author Lenia
 */
public abstract class LogInHandler {
    Account account = Account.getInstance();

    /**
     * checks whether the usernames matches
     *
     * @param accountName is the variables obtained from logInTextField on logIn controller
     */
    private boolean checkLoginAccountName(TextField accountName) {
        return account.getUsername().equals(accountName.getText());
    }

    /**
     * checks whether the password matches
     *
     * @param password is the variables obtained from logInTextField on logIn controller
     */
    private boolean checkLoginPassword(TextField password) {
        return account.getPassword().equals(password.getText());
    }

    /**
     * handles the actual login
     *
     * @param password is the variables obtained from logInTextField on logIn controller
     */
    public boolean logIn(TextField accountName, TextField password) {

        boolean isLogInCorrect = true;
        if (!checkLoginAccountName(accountName)) {
            accountName.setStyle("-fx-text-box-border: #B22222;"); //RED
            isLogInCorrect = false;
        } else accountName.setStyle("-fx-text-box-border: #008000;");
        if (!checkLoginPassword(password)) {
            password.setStyle("-fx-text-box-border: #B22222;"); //RED
            isLogInCorrect = false;
        } else password.setStyle("-fx-text-box-border: #008000;");


        return isLogInCorrect;
    }


}
