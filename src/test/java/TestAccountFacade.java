import Model.AccountLogic.Account;
import Model.AccountLogic.AccountFacade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccountFacade {

    AccountFacade accountFacade = AccountFacade.getInstance();
    Account account = Account.getInstance();

    String name = "lenia";
    String username = "lenia98";
    String password = "12345678";
    String confirmPassword = "12345678";
    String email = "lea@hotm.com";

    String empty = "";

    //---------------------------------------------------- METHODS -----------------------------------------------------


    @Test
    public void createAccount() {
        /*
        Creates an account
        Goes through accountExistenceManager.createAccount() which passes  signUpFieldsChecker() and assignUserFields()
        in AccountExistenceManager
         */
        Account validAccount = accountFacade.createAccount(name, username, password, confirmPassword, email);
        assertEquals(validAccount, account);

        assertEquals(account.getName(), name);
        assertEquals(account.getUsername(), username);
        assertEquals(account.getPassword(), password);
        assertEquals(account.getEmailAddress(), email);

        assertNotEquals(account.getName(), empty);

        //creates an invalid account by leaving the field for name blank, will thus return null, i.e. no account
        Account inValidAccount = accountFacade.createAccount(empty, username, password, confirmPassword,
                                                             email);
        assertNull(inValidAccount);

    }

    @Test
    public void deleteAccount() {
        /*
        Creates an account and assigns values to account variables
         */
        Account validAccount = accountFacade.createAccount(name, username, password, confirmPassword, email);
        assertEquals(validAccount, account);
        assertEquals(account.getName(), name);

        //Deletes the created account by setting all its' variables to null
        accountFacade.deleteAccount();
        assertNotEquals(account.getName(), name);
        assertNotEquals(account.getUsername(), username);
        assertNotEquals(account.getPassword(), password);
        assertNotEquals(account.getEmailAddress(), email);

    }

    @Test
    public void checkPassword() {
        /*Checks whether the input password is of a valid format through AccountExistenceManager's method
        CheckPassword(String password) which in turn is passed down to accountValidityChecker.checkPasswordLength
        (password). Used in order to change the password of an account.
         */
        accountFacade.setAccountPassword(password);
        assertEquals(account.getPassword(), password);
        boolean bool = accountFacade.checkPassword(password);
        assertTrue(bool);

        //Sets accounts' password to an invalid input --> will not pass
        bool = accountFacade.checkPassword(empty);
        assertFalse(bool);
        assertNotEquals(account.getPassword(), empty);


    }

    @Test
    public void isAccountPageFieldsCorrect() {
        /* Checks whether all three fields of the account page is correct when edited.
        Goes through AccountEditor's areAccountFieldsCorrect(String username, String name, String email)
        which in turn goes through different checks within class AccountValidityChecker.
         */
        boolean bool = accountFacade.isAccountPageFieldsCorrect(username, name, email);
        assertTrue(bool);

        bool = accountFacade.isAccountPageFieldsCorrect(empty, name, email);
        assertFalse(bool);

        bool = accountFacade.isAccountPageFieldsCorrect(username, name, password);
        assertFalse(bool);

        bool = accountFacade.isAccountPageFieldsCorrect(empty, empty, empty);
        assertFalse(bool);


    }

    @Test
    public void checkPasswordMatch() {
        /* Checks whether the inputted password matches that of the existing account.
        Goes through AccountExistenceManager's checkPasswordMatch(String inputPassword).
         */
        account.setPassword(password);

        boolean bool = accountFacade.checkPasswordMatch(confirmPassword);
        assertTrue(bool);

        bool = accountFacade.checkPasswordMatch(empty);
        assertFalse(bool);

        bool = accountFacade.checkPasswordMatch(name);
        assertFalse(bool);

    }

    //---------------------------------------------------- SETTERS -----------------------------------------------------

    @Test
    public void setAccountName() {
        //Sets accounts' name to an valid input through AccountEditor's method setAccountName(String textField)
        //which in turn gets passed down to AccountValidityChecker's isValidName();
        accountFacade.setAccountName(name);
        assertEquals(account.getName(), name);

        //Sets accounts' name to an invalid input --> will not pass
        accountFacade.setAccountName(empty);
        assertNotEquals(account.getName(), empty);
    }

    @Test
    public void setAccountUsernameName() {
        //Sets accounts' username to an valid input AccountEditor's method setAccountUsername(String username)
        //which in turn gets passed down to AccountValidityChecker's checkUsername(String username);
        accountFacade.setAccountUsername(username);
        assertEquals(account.getUsername(), username);

        //Sets accounts' username to an invalid input --> will not pass
        accountFacade.setAccountUsername(empty);
        assertNotEquals(account.getUsername(), empty);
    }

    @Test
    public void setAccountEmail() {
        //Sets accounts' email to an valid input AccountEditor's method setAccountEmail(String email)
        //which in turn gets passed down to AccountValidityChecker's isValidEmail(String email);
        accountFacade.setAccountEmail(email);
        assertEquals(account.getEmailAddress(), email);

        //Sets accounts' email to an invalid input --> will not pass
        accountFacade.setAccountEmail(empty);
        assertNotEquals(account.getEmailAddress(), empty);
    }

    @Test
    public void setAccountPassword() {
        //Sets accounts' password to an valid input AccountEditor's method setAccountPassword(String password)
        //which in turn gets passed down to AccountValidityChecker's checkPassword (String password)
        accountFacade.setAccountPassword(password);
        assertEquals(account.getPassword(), password);

        //Sets accounts' password to an invalid input --> will not pass
        accountFacade.setAccountPassword(empty);
        assertNotEquals(account.getPassword(), empty);

    }


}
