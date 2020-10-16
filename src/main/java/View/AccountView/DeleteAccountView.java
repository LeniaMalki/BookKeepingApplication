package View.AccountView;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

public class DeleteAccountView implements iPane {

    public static DeleteAccountView deleteAccountView;

    @FXML
    public PasswordField password;
    @FXML
    public Text textMessage;
    public MainController parent;
    @FXML
    public Button deleteAccountButton;


    public DeleteAccountView() {
        deleteAccountView = this;
    }

    public static DeleteAccountView getInstance() {
        if (deleteAccountView == null) {
            deleteAccountView = new DeleteAccountView();
        }
        return deleteAccountView;
    }

    /**
     * initialized this pane
     */
    public void initPane(MainController parent) {
        this.parent = parent;
    }

    public void setMessage() {
        textMessage.setText("Password is incorrect! Try again.");
    }
}
