package Model.AccountLogic;


import javafx.scene.control.TextField;

public abstract class LogInHandler {

    Account account = Account.getInstance();


    private boolean checkLoginAccountName (TextField accountName) {
        return account.getUsername().equals(accountName.getText());
    }

    private boolean checkLoginPassword(TextField password) {
        return account.getPassword().equals(password.getText());
    }

    public boolean logIn (TextField accountName, TextField password) {

        boolean isLogInCorrect = true;
        if (!checkLoginAccountName(accountName)) {
            accountName.setStyle("-fx-text-box-border: #B22222;"); //RED
            isLogInCorrect = false;
        }
        else accountName.setStyle("-fx-text-box-border: #008000;");
        if (!checkLoginPassword(password)) {
            password.setStyle("-fx-text-box-border: #B22222;"); //RED
            isLogInCorrect = false;
        }
        else password.setStyle("-fx-text-box-border: #008000;");


        return isLogInCorrect;
    }



}
