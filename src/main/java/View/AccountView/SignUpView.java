package View.AccountView;

import View.Interfaces.iPane;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lenia Malki
 * Responsibility: Holds the relevant JavaFX variables of signing up and holds methods directly
 * related to view
 * Used by: SignUpPageController, PaneFactory, signUpPopUp.fxml
 * Uses: iPane interface, MainController, JavaFX
 */
public class SignUpView implements iPane {
    //________________________________________________ Variables _______________________________________________________
    private static SignUpView signUpView;
    @FXML
    public TextField signUpName;
    @FXML
    public TextField signUpUsername;
    @FXML
    public PasswordField signUpPassword;
    @FXML
    public PasswordField signUpConfirmPassword;
    @FXML
    public TextField signUpEmail;
    @FXML
    private Text textMessage;
    @FXML
    public Button createAccount;


    MainView parent;
    private final List<TextField> textFields = new ArrayList<>() {};

    //---------------------------------------------------- METHODS -----------------------------------------------------

    /**
     * Constructor
     */
    public SignUpView() {
        signUpView = this;
    }

    /**
     * Singleton pattern for getting an instance of this class
     * @return instance of view
     */
    public static SignUpView getInstance() {
        if (signUpView == null) {
            synchronized (SignUpView.class) {
            signUpView = new SignUpView();}
        }
        return signUpView;
    }

    /**
     * Initializes the pane
     * @param parent parent
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;

        textFields.add(signUpName);
        textFields.add(signUpUsername);
        textFields.add(signUpPassword);
        textFields.add(signUpConfirmPassword);
        textFields.add(signUpEmail);

    }
    /**
     * Sets message on view
     * @param message obtained from controller
     */
    public void setMessage(final String message) {
        textMessage.setText(message);

    }

    /**
     * Resets all border colors and texts of the sign up page text fields.
     */
    public void clearTextFields() {

        for (final TextField t : textFields) {
            t.clear();
            t.setStyle("-fx-text-box-border: #FFFFFF;");
        }
    }

}
