package View.AccountView;

import View.Interfaces.iPane;
import Controller.MainControllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
/**
 * @author : Lenia Malki
 * Responsibility: Holds the relevant JavaFX variables of the login and holds methods directly related to view
 * Used by: LogInController, PaneFactory, logInPage.fxml
 * Uses: iPane interface, MainController, JavaFX
 */
public class LogInView implements iPane {
    //________________________________________________ Variables _______________________________________________________
    private static LogInView logInView;
    public MainController parent;
    @FXML
    private AnchorPane pos_for_popUp_on_LogInPage;
    @FXML
    private AnchorPane back;
    @FXML
    private AnchorPane logInContent;
    @FXML
    public TextField logInField;
    @FXML
    public TextField usernameField;
    @FXML
    private Text testMessage;
    @FXML
    public Hyperlink signUpLink;
    @FXML
    public Button logInButton;
    @FXML
    public Hyperlink forgotPassword;

    //---------------------------------------------------- METHODS -----------------------------------------------------
    /**
     * Constructor
     */
    public LogInView() {
        logInView = this;
    }

    /**
     * Singleton pattern for getting an instance of this class
     * @return instance of view
     */
    public static LogInView getInstance() {
        if (logInView == null) {
            synchronized (LogInView.class) {
            logInView = new LogInView();}
        }
        return logInView;
    }

    /**
     * initialized this pane
     */
    @Override
    public void initPane(final MainController parent) {
        this.parent = parent;
    }

    /**
     * Opens the signUpPopUp
     */
    public void showSignUpPopUp() {

        back.setVisible(true);
        pos_for_popUp_on_LogInPage.setVisible(true);

        pos_for_popUp_on_LogInPage.getChildren().clear();
        pos_for_popUp_on_LogInPage.getChildren().add(parent.getSignUpPopUp());
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        pos_for_popUp_on_LogInPage.toFront();
    }

    /**
     * Shows message on view
     * @param message sent in by controller
     */
    public void setMessage(final String message) {
        testMessage.setText(message);
    }

    /**
     * Graphic method to hide pop ups
     */
    @FXML
    public void hidePopUp() {
        back.setVisible(false);
        pos_for_popUp_on_LogInPage.setVisible(false);
        logInContent.toFront();
    }

    /**
     * Clears all textFields on Login page pop up
     */
    public void clearLogInFields() {
        this.usernameField.clear();
        this.logInField.clear();
    }


}
