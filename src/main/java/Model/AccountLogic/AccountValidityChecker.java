package Model.AccountLogic;

/**
 * A class that checks the validity of textField inputs
 *
 * @author Lenia
 */
public class AccountValidityChecker {
    private static AccountValidityChecker accountValidityChecker;

    /**
     * Private constructor
     */
    private AccountValidityChecker() {
    }

    /**
     * Method for obtaining a validity checker
     */
    static AccountValidityChecker getInstance() {
        if (accountValidityChecker == null) {
            accountValidityChecker = new AccountValidityChecker();
        }
        return accountValidityChecker;
    }

    /**
     * Checks if signup password and confirmation password match
     *
     * @param confirmPassword confirmPassword textfield
     * @param signUpPassword  signUpPassword textfield
     */
     boolean checkSignupPasswordMatch(String signUpPassword, String confirmPassword) {
        return signUpPassword.equals(confirmPassword);
    }

    /**
     * Checks if  password is at least 8 char long
     *
     * @param password password textfield
     */
     boolean checkPasswordLength(String password) {

        return password.length() >= 8;
    }

    /**
     * Checks if  email is in right format
     *
     * @param email email textfield
     */
     boolean isValidEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }


    /**
     * Checks if  name is in right format
     *
     * @param name name textfield
     */
     boolean isValidName(String name) {

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

    boolean checkUsername (String username) {
         return  (!username.equals("")) ;
    }

}
