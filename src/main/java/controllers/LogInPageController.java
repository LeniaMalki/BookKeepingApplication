package controllers;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.iPane;
import Model.LogInHandler;
import Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LogInPageController implements iPane, AccountObserver {

    @FXML
    public AnchorPane pos_for_popUp_on_LogInPage;
    @FXML
    public AnchorPane back;
    @FXML
    public AnchorPane logInContent;
    private MainController parent;
    private User user = User.getInstance();
    @FXML
    private PasswordField logInField;
    @FXML
    private TextField usernameField;
    @FXML
    private Text userExistanceText;

    //Initialize
    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        user.add(this);
    }

    //Button actions
    @FXML

            private void signUpButton() {

                if (!(user.doesUserExist()) ) {
                    back.setVisible(true);
                    pos_for_popUp_on_LogInPage.setVisible(true);

                    pos_for_popUp_on_LogInPage.getChildren().clear();
                    pos_for_popUp_on_LogInPage.getChildren().add(parent.getSignUpPopUp());
                    back.toFront();
                    back.setStyle("-fx-background-color: #000000");
                    back.setOpacity(0.5);
                    pos_for_popUp_on_LogInPage.toFront();
                }
                else {userExistanceText.setText("A user already exits!");
            userExistanceText.setFill(Color.RED); }

    }

    @FXML
    private void onLoginClicked() {
        parent.showFirstPage();

        LogInHandler logInHandler = new LogInHandler() {
            @Override
            public boolean logIn(TextField usernameField, TextField logInField) {
                return super.logIn(usernameField, logInField);
            }
        };

        boolean caseNumber = logInHandler.logIn(usernameField, logInField);

        if (caseNumber) {
            userExistanceText.setFill(Color.WHITE);
            usernameField.clear();
            logInField.clear();
            parent.showFirstPage();

        } else {
            userExistanceText.setFill(Color.RED);
        }
    }


    @FXML
    private void hidePopUp() {
        back.setVisible(false);
        pos_for_popUp_on_LogInPage.setVisible(false);
        logInContent.toFront();
    }

    //Observer-pattern methods
    @Override
    public void update() {
        if (User.getInstance() != null) {

            hidePopUp();
        }
    }


}
