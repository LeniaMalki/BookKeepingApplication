package Model;

import javafx.scene.control.TextField;

public abstract class AccountDataHandler {

    private final User user = User.getInstance();


    public User createUser(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                           TextField signUpPassword, TextField signUpConfirmPassword) {


        if (signUpFieldsChecker(signUpName, signUpUsername, signUpEmail,
                                signUpPassword, signUpConfirmPassword) == 0) {

            assignUserFields(signUpName, signUpUsername, signUpEmail,
                             signUpPassword, signUpConfirmPassword);
            return user;
        }
        return null;
    }

    //Checkers for sign Up individual inputs
    public boolean checkSignupPasswordMatch(String signUpPassword, String confirmPassword) {
        return signUpPassword.equals(confirmPassword);
    }

    public boolean doesPasswordMatch(String inputPassword) {
        return user.getPassword().equals(inputPassword);
    }

    public boolean checkPasswordLength(String password) {

        return password.length() >= 8;
    }

    public void assignUserFields(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                                 TextField signUpPassword, TextField signUpConfirmPassword) {
        user.setName(signUpName.getText());
        user.setUsername(signUpUsername.getText());
        user.setEmailAddress(signUpEmail.getText());
        user.setPassword(signUpPassword.getText());
        user.setConfirmPassword(signUpConfirmPassword.getText());

    }

    public boolean isValidEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public boolean isValidName(String name) {

        int len = name.length();

        if (len == 0) {
            return false;
        } else {
            for (int i = 0; i < len; i++) {

                // checks whether the character is not a letter if it is not a letter ,it will return false

                if ((!Character.isLetter(name.charAt(i)))) {
                    return false;
                }


            }
        }
        return true;
    }

    //Checkers for entire sign up page
    private int signUpFieldsChecker(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                                    TextField signUpPassword, TextField signUpConfirmPassword) {

        int i = 0;

        if (!isValidName(signUpName.getText())) {
            signUpName.setStyle("-fx-text-box-border: #B22222;");
            i++;
        } else signUpName.setStyle("-fx-text-box-border: #008000;");

        if (!isValidEmail(signUpEmail.getText())) {
            signUpEmail.setStyle("-fx-text-box-border: #B22222;");
            i++;
        } else signUpEmail.setStyle("-fx-text-box-border: #008000;");

        if (signUpUsername.getText().equals("")) {
            signUpUsername.setStyle("-fx-text-box-border: #B22222;");
            i++;
        } else signUpUsername.setStyle("-fx-text-box-border: #008000;");

        if (!checkPasswordLength(signUpPassword.getText())) {
            signUpPassword.setStyle("-fx-text-box-border: #B22222;");
            i++;
        } else signUpPassword.setStyle("-fx-text-box-border: #008000;");

        if (!checkSignupPasswordMatch(signUpPassword.getText(), signUpConfirmPassword.getText())) {
            signUpConfirmPassword.setStyle("-fx-text-box-border: #B22222;");
            i++;
        } else signUpConfirmPassword.setStyle("-fx-text-box-border: #008000;");
        return i;
    }

    public boolean isAllFieldsEntered(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                                      TextField signUpPassword, TextField signUpConfirmPassword) {
        return (!signUpName.getText().equals("") && !signUpUsername.getText().equals("") && !signUpEmail.getText().equals("") && !signUpPassword.getText().equals("") && !signUpConfirmPassword.getText().equals(""));
    }

    public void deleteAccount () {
        user.setName(null);
        user.setName(null);
        user.setUsername(null);
        user.setEmailAddress(null);
        user.setPassword(null);
        user.setConfirmPassword(null);
    }



}


