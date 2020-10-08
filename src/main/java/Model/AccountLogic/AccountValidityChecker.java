package Model.AccountLogic;

public class AccountValidityChecker {
    private static AccountValidityChecker accountValidityChecker;

    Account account = Account.getInstance();

    public static AccountValidityChecker getInstance() {
        if (accountValidityChecker == null) {
            accountValidityChecker = new AccountValidityChecker();
        }
        return accountValidityChecker;
    }

    boolean checkSignupPasswordMatch(String signUpPassword, String confirmPassword) {
        return signUpPassword.equals(confirmPassword);
    }

    boolean doesPasswordMatch(String inputPassword) {
        return account.getPassword().equals(inputPassword);
    }

    public boolean checkPasswordLength(String password) {

        return password.length() >= 8;
    }

    boolean isValidEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

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


}
