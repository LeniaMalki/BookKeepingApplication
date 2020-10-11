import Model.AccountLogic.Account;
import Model.AccountLogic.AccountExistenceManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAccountExistenceManager {
/*
    AccountExistenceManager accountExistenceManager = AccountExistenceManager.getInstance();
    Account account = Account.getInstance();

    String name = "lenia";
    String username = "lenia98";
    String password = "12345678";
    String confirmPassword = "12345678";
    String email = "lea@hotm.com";


    String empty = "";

    @Test
    public void testCreateAccount() {

        //creates an account
        //goes though signUpFieldChecker() first then to assignUserFields()
        Account validAccount = accountExistenceManager.createAccount(name, username, password, confirmPassword, email);
        assertEquals(validAccount, account);

        Account unValidAccount = accountExistenceManager.createAccount(empty, username, password, confirmPassword,
                                                                       email);
        assertNull(unValidAccount);
    }

    @Test
    public void testAssignUserFields() {

        accountExistenceManager.assignUserFields(name, username, password, confirmPassword, email);
        assertEquals(account.getName(), name);
        assertEquals(account.getUsername(), username);
        assertEquals(account.getPassword(), password);
        assertEquals(account.getEmailAddress(), email);

        assertNotEquals(account.getName(), username);
    }

    @Test
    public void testSignupFieldsChecker() {
        int x = accountExistenceManager.signUpFieldsChecker(name, username, password, confirmPassword, email);
        assertEquals(x, 0);

        int y = accountExistenceManager.signUpFieldsChecker(username, empty, password, confirmPassword, email);
        assertEquals(y, 2);

        int z = accountExistenceManager.signUpFieldsChecker(name, username, password, empty, name);
        assertEquals(z, 2);

        int a = accountExistenceManager.signUpFieldsChecker(name, username, email, confirmPassword, email);
        assertEquals(a, 1);
    }

    @Test
    public void testCheckPassword () {

        boolean bool = accountExistenceManager.checkPassword(password);
        assertTrue(bool);

        boolean buul = accountExistenceManager.checkPassword(empty);
        assertFalse (buul);
    }

    @Test
    public void deleteAccount() {
        Account validAccount = accountExistenceManager.createAccount(name, username, password, confirmPassword, email);
        assertEquals(validAccount, account);

        assertEquals(account.getName(), name);

        accountExistenceManager.deleteAccount();
        assertNull(account.getName());
    }


 */

}
