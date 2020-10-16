package View.AccountView;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class LogInView implements iPane {

    public static LogInView logInView;

    @FXML
    public AnchorPane pos_for_popUp_on_LogInPage;
    @FXML
    public AnchorPane back;
    @FXML
    public AnchorPane logInContent;
    public MainController parent;
    @FXML
    public TextField logInField;
    @FXML
    public TextField usernameField;
    @FXML
    public Text testMessage;
    @FXML
    public Hyperlink signUpLink;
    @FXML
    public Button logInButton;

    public static LogInView getInstance() {
        if (logInView == null) {
            logInView = new LogInView();
        }
        return logInView;
    }

    public LogInView() {
        logInView = this;
    }

    /**
     * initialized this pane
     */
    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
    }

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

    public void setMessage(String message) {
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
