package Model;


import javafx.scene.control.TextField;

public abstract class LogInHandler {

    User user = User.getInstance();

    public boolean logIn (TextField usernameField, TextField logInField) {

        if (user.doesUserExist()) {
            return loginFieldChecker(usernameField, logInField) == 0;
        }
       return false;
    }


    public int loginFieldChecker(TextField usernameField, TextField logInField) {

        int caseNumber = 0;

        if (!(user.getUsername().equals(usernameField.getText()))) {
            usernameField.setStyle("-fx-text-box-border: #B22222;");
            caseNumber++;
        }
        if (!(user.getPassword().equals(logInField.getText()))) {
            logInField.setStyle("-fx-text-box-border: #B22222;");
            caseNumber++;
        }
        return caseNumber;
    }



}
