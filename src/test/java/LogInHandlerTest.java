import Model.AccountLogic.Account;
import Model.AccountLogic.LogInHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogInHandlerTest {

    Account account = Account.getInstance();

    @Test
    void logIn() {

        final LogInHandler logInHandler = new LogInHandler() {
            /**
             * handles the actual login
             * @param accountName is the variables obtained from logInTextField on logIn controller
             * @param password is the variables obtained from logInTextField on logIn controller
             */
            @Override
            public boolean logIn(final String accountName, final String password) {
                return super.logIn(accountName, password);
            }
        };
        account.setUsername("lenia");
        account.setPassword("12345678");
        assertTrue(logInHandler.logIn(account.getUsername(), account.getPassword()));

        assertFalse(logInHandler.logIn("", ""));


    }
}