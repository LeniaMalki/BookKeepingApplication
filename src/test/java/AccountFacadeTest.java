import Model.AccountLogic.Account;
import Model.AccountLogic.AccountFacade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountFacadeTest {

    AccountFacade accountFacade = AccountFacade.getInstance();
    Account account = Account.getInstance();

    String name = "lenia";
    String username = "lenia98";
    String password = "12345678";
    String confirmPassword = "12345678";
    String email = "lea@hotm.com";

    String empty = "";

    @Test
    void updateAccountPassword() {
        //Sets accounts' password to an valid input AccountEditor's method updateAccountPassword(String password)
        //which in turn gets passed down to AccountValidityChecker's isValidPasswordFormat (String password)
        accountFacade.updateAccountPassword(password);
        assertEquals(account.getPassword(), password);

        //Sets accounts' password to an invalid input --> will not pass
        accountFacade.updateAccountPassword(empty);
        assertNotEquals(account.getPassword(), empty);
    }

    @Test
    void createAccount() {
          /*
        Creates an account
        Goes through accountExistenceManager.createAccount() which passes  signUpFieldsChecker() and assignUserFields()
        in AccountExistenceManager
         */
        final boolean validAccount = accountFacade.createAccount(name, username, password, confirmPassword, email);
        assertTrue(validAccount);

        assertEquals(account.getName(), name);
        assertEquals(account.getUsername(), username);
        assertEquals(account.getPassword(), password);
        assertEquals(account.getEmailAddress(), email);

        assertNotEquals(account.getName(), empty);

        //creates an invalid account by leaving the field for name blank, will thus return null, i.e. no account
        final boolean inValidAccount = accountFacade.createAccount(empty, username, password, confirmPassword,
                                                             email);
        assertFalse(inValidAccount);

    }

    @Test
    void deleteAccount() {

            /*
        Creates an account and assigns values to account variables
         */
        final boolean validAccount = accountFacade.createAccount(name, username, password, confirmPassword, email);
        assertTrue(validAccount);
        assertEquals(account.getName(), name);

        //Deletes the created account by setting all its' variables to null
        accountFacade.deleteAccount();
        assertNotEquals(account.getName(), name);
        assertNotEquals(account.getUsername(), username);
        assertNotEquals(account.getPassword(), password);
        assertNotEquals(account.getEmailAddress(), email);
    }

    @Test
    void handleAccountChanges() {

        //Old inputs
        account.setUsername(username);
        account.setName(name);
        account.setEmailAddress(email);

        //New inputs
         String newUsername = "newUsername";
         String newName = "newName";
         String newEmail = "newEmail@hot.com";


        final int i = accountFacade.handleAccountChanges(newUsername, newName, newEmail);
        final int x = accountFacade.handleAccountChanges(account.getUsername(), account.getName(), account.getEmailAddress());
        final int y = accountFacade.handleAccountChanges("", account.getName(), account.getEmailAddress());

        assertEquals(i, 1);
        assertEquals(x, 0);
        assertEquals(y, 3);

    }

    @Test
    void updateAccountFields() {

        accountFacade.updateAccountFields("myUsername", "myName", "myEmail@hot.com");
        assertEquals(account.getName(), "myName");
        assertEquals(account.getUsername(), "myUsername");
        assertEquals(account.getEmailAddress(), "myEmail@hot.com");
        accountFacade.updateAccountFields("", "myName", "myEmail");
        assertNotEquals(account.getName(), "");
    }

    @Test
    void doesPasswordMatchWithAccount() {
         /* Checks whether the inputted password matches that of the existing account.
        Goes through AccountExistenceManager's doesPasswordMatchWithAccount(String inputPassword).
         */
        account.setPassword(password);

        boolean bool = accountFacade.doesPasswordMatchWithAccount(confirmPassword);
        assertTrue(bool);

        bool = accountFacade.doesPasswordMatchWithAccount(empty);
        assertFalse(bool);

        bool = accountFacade.doesPasswordMatchWithAccount(name);
        assertFalse(bool);
    }

    @Test
    void isValidPasswordFormat() {

        assertTrue(accountFacade.isValidPasswordFormat(password));
        assertFalse(accountFacade.isValidPasswordFormat(empty));

    }
}