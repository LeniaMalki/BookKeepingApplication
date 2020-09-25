package Model;

import javafx.scene.control.TextField;

public abstract class AccountHandler {

    private final User user = User.getInstance();

    public User createUser(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                           TextField signUpPassword, TextField signUpConfirmPassword) {

        if (isAllFieldsEntered(signUpName, signUpUsername, signUpEmail, signUpPassword, signUpConfirmPassword)) {


            if (isValidName(signUpName.getText())) {
                signUpName.getStyleClass().add("confirmationButtonGreen");


                if (isValidEmail(signUpEmail.getText())) {
                    signUpEmail.getStyleClass().add("confirmationButtonGreen");

                    if (checkPasswordLength(signUpPassword.getText())) {
                        signUpPassword.getStyleClass().add("confirmationButtonGreen");

                        if (doesPasswordMatch(signUpPassword.getText(), signUpConfirmPassword.getText())) {
                            signUpPassword.getStyleClass().add("confirmationButtonGreen");

                            assignUserFields(signUpName, signUpUsername, signUpEmail, signUpPassword,
                                             signUpConfirmPassword);

                            return user;
                        } else {
                            signUpConfirmPassword.getStyleClass().add("confirmationButtonRed");
                            return null;
                        }

                    } else {
                        signUpPassword.getStyleClass().add("confirmationButtonRed");
                        return null;
                    }

                } else {
                    signUpEmail.getStyleClass().add("confirmationButtonRed");
                    return null;
                }
            } else {
                signUpName.getStyleClass().add("confirmationButtonRed");
                return null;
            }
        }

        //else return; System.out.println("Not all fields entered");

        return null;
    }

    public boolean doesPasswordMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public boolean isAllFieldsEntered(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                                      TextField signUpPassword, TextField signUpConfirmPassword) {
        return (!signUpName.getText().equals("") && !signUpUsername.getText().equals("") && !signUpEmail.getText().equals("") && !signUpPassword.getText().equals("") && !signUpConfirmPassword.getText().equals(""));
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

}


