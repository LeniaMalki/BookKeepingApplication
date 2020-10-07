package Controller;

import Model.AccountFacade;
import Model.Interfaces.AccountObserver;
import Controller.Interfaces.iPane;
import Model.LogInHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LogInPageController implements iPane, AccountObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    AccountFacade accountFacade = AccountFacade.getInstance();

    //________________________________________________ FXML VARIABLES __________________________________________________
    @FXML
    public AnchorPane pos_for_popUp_on_LogInPage;
    @FXML
    public AnchorPane back;
    @FXML
    public AnchorPane logInContent;
    private MainController parent;
    @FXML
    private PasswordField logInField;
    @FXML
    private TextField usernameField;
    @FXML
    private Text message;

    //________________________________________________ Methods _________________________________________________________
    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        accountFacade.add(this);
    }

    @FXML
    private void signUpButton() {

        back.setVisible(true);
        pos_for_popUp_on_LogInPage.setVisible(true);

        pos_for_popUp_on_LogInPage.getChildren().clear();
        pos_for_popUp_on_LogInPage.getChildren().add(parent.getSignUpPopUp());
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        pos_for_popUp_on_LogInPage.toFront();
    }


    @FXML
    private void onLoginClicked() {

        LogInHandler logInHandler = new LogInHandler() {
            @Override
            public boolean logIn(TextField usernameField, TextField logInField) {
                return super.logIn(usernameField, logInField);
            }
        };

        boolean caseNumber = logInHandler.logIn(usernameField, logInField);

        if (caseNumber) {
            message.setFill(Color.WHITE);
            usernameField.clear();
            logInField.clear();
            parent.showFirstPage();

        } else {
            message.setFill(Color.RED);
        }
    }

    @FXML
    private void hidePopUp() {
        back.setVisible(false);
        pos_for_popUp_on_LogInPage.setVisible(false);
        logInContent.toFront();
    }

    @Override
    public void update() {
        hidePopUp();
    }
}
