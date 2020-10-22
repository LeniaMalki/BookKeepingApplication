package Model.AccountLogic;//NOPMD

/**
 * A class that checks the validity of textField inputs
 * @author Lenia
 */
public final class AccountValidityChecker {
    //________________________________________________ Variables _______________________________________________________
    private static AccountValidityChecker accountValidityChecker;//NOPMD

    //---------------------------------------------------- METHODS -----------------------------------------------------
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
            synchronized (AccountValidityChecker.class) {
            accountValidityChecker = new AccountValidityChecker();}
        }
        return accountValidityChecker;
    }

    /**
     * Checks if signup password and confirmation password match
     * @param confirmPassword confirmPassword textfield
     * @param signUpPassword signUpPassword textfield
     */
    boolean doesPasswordMatch(final String signUpPassword, final String confirmPassword) {
        return signUpPassword.equals(confirmPassword);
    }

    /**
     * Checks if  password is at least 8 char long
     * @param password password textfield
     */
    boolean isValidPasswordLength(final String password) {

        return password.length() >= 8;
    }

    /**
     * Checks if  email is in right format
     * @param email email textfield
     */
    boolean isValidEmail(final String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    /**
     * Checks if  name is in right format
     * @param name name textfield
     */
    boolean isValidName(final String name) {

        final int len = name.length();

        if (len == 0) {
            return false;
        } else {
            for (int i = 0; i < len; i++) {

                // checks whether the character is not a letter if it is not a letter ,it will return false

                if (!Character.isLetter(name.charAt(i))) {
                    return false;
                }


            }
        }
        return true;
    }

    /**
     * Checks whether the username is not empty
     * @param username passed in by whichever controller in use of method
     * @return true/false
     */
    boolean isValidUsername(final String username) {
        return !"".equals(username); }

    /**
     * A collective check for all account variables
     * @param name passed in by whichever controller in use of method
     * @param username passed in by whichever controller in use of method
     * @param password passed in by whichever controller in use of method
     * @param confirmPassword passed in by whichever controller in use of method
     * @param email passed in by whichever controller in use of method
     * @return true/false depending if all account variables are valid or not
     */
    boolean areAllAccountValuesCorrect(final String name, final String username,
                                       final String password, final String confirmPassword, final String email) {

        return isValidName(name) && isValidUsername(username) && isValidPasswordLength(password) && doesPasswordMatch(password, confirmPassword) && isValidEmail(email);


    }

    /**
     * Same as method "areAllAccountValuesCorrect" but checks only the three variables of the profile page
     * @param username passed in by whichever controller in use of method
     * @param name passed in by whichever controller in use of method
     * @param email passed in by whichever controller in use of method
     * @return true/false depending if all account variables are valid or not
     */
    boolean areAllProfilePageValuesCorrect(final String username, final String name, final String email) {
        return isValidUsername(username) && isValidName(name) && isValidEmail(email);

    }
}
