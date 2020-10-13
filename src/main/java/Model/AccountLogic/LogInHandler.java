package Model.AccountLogic;


/**
 * A class that handles the logic of login in to logIn page
 * @author Lenia
 */
public abstract class LogInHandler {
    Account account = Account.getInstance();

    /**
     * checks whether the usernames matches
     * @param accountName is the variables obtained from logInTextField on logIn controller
     */
    private boolean checkLoginAccountName(String accountName) {
        return account.getUsername().equals(accountName);
    }

    /**
     * checks whether the password matches
     * @param password is the variables obtained from logInTextField on logIn controller
     */
    private boolean checkLoginPassword(String password) {
        return account.getPassword().equals(password);
    }

    /**
     * handles the actual login
     * @param password is the variables obtained from logInTextField on logIn controller
     */
    public boolean logIn(String accountName, String password) {

        boolean isLogInCorrect = true;
        if (!checkLoginAccountName(accountName)) {
            System.out.println("Incorrect accountName");
            //accountName.setStyle("-fx-text-box-border: #B22222;"); //RED
            isLogInCorrect = false;
        } //else accountName.setStyle("-fx-text-box-border: #008000;");
        if (!checkLoginPassword(password)) {
            //password.setStyle("-fx-text-box-border: #B22222;"); //RED
            System.out.println("Incorrect password");
            isLogInCorrect = false;
        } //else password.setStyle("-fx-text-box-border: #008000;");


        return isLogInCorrect;
    }


}
