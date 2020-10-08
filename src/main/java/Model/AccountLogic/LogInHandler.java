package Model.AccountLogic;


import javafx.scene.control.TextField;

public abstract class LogInHandler {

    Account account = Account.getInstance();

    public boolean logIn(TextField usernameField, TextField logInField) {

        if (account.doesUserExist()) {
            return loginFieldChecker(usernameField, logInField) == 0;
        }
        return false;
    }


    public int loginFieldChecker(TextField usernameField, TextField logInField) {

        int caseNumber = 0;

        if (!(account.getUsername().equals(usernameField.getText()))) {
            usernameField.setStyle("-fx-text-box-border: #B22222;");
            caseNumber++;
        }
        if (!(account.getPassword().equals(logInField.getText()))) {
            logInField.setStyle("-fx-text-box-border: #B22222;");
            caseNumber++;
        }
        return caseNumber;
    }


}
