package View.AccountView;//NOPMD

import View.Interfaces.iPane;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
/**
 * @author : Lenia Malki
 * Responsibility: In charge of displaying the pop up for deleting an account
 * Used by: DeleteAccountController, PaneFactory, deleteAccountPopUp.fxml
 * Uses: iPane interface, MainController, JavaFX, MainView
 */
public class DeleteAccountView implements iPane {

    //________________________________________________ Variables _______________________________________________________
    private static DeleteAccountView deleteAccountView;
    @FXML
    public PasswordField password;
    @FXML
    public Text textMessage;
    public MainView parent;
    @FXML
    public Button deleteAccountButton;//NOPMD

    //________________________________________________ Methods _________________________________________________________
    /**
     * constructor
     */
    public DeleteAccountView() {
        deleteAccountView = this;
    }

    /**
     * Singleton pattern for getting an view of delete account pop up
     * @return instance of view
     */
    public static DeleteAccountView getInstance() {
        if (deleteAccountView == null) {
            synchronized (DeleteAccountView.class) {
            deleteAccountView = new DeleteAccountView();}
        }
        return deleteAccountView;
    }

    /**
     * initialized this pane
     */
    public void initPane(final MainView parent) {
        this.parent = parent;
    }

    /**
     * Sets error message on view
     */
    public void setMessage() {
        textMessage.setText("Password is incorrect! Try again.");
    }
}
