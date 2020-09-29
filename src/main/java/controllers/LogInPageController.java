package controllers;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.iPane;
import Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class LogInPageController implements iPane, AccountObserver {

    @FXML
    public AnchorPane pos_for_popUp_on_LogInPage;
    MainController parent;
    User user = User.getInstance();
    @FXML
    private AnchorPane back;
    @FXML
    private PasswordField logInField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button logInButton;

    @FXML
    private Text userExistanceText;

    @FXML
    private AnchorPane logInPage;

    @FXML
    private AnchorPane logInContent;

    @FXML
    private Line passwordLine;

    @FXML
    private Line userNameLine;


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
    private void loadFirstPage() {

        int caseNumber = logInCaseChecker();

        switch (caseNumber) {

            case 0 -> {
                userExistanceText.setText("No user registered!");
                userNameLine.setStroke(Color.RED);
                passwordLine.setStroke(Color.RED);
            }

            case 1 -> {
                userNameLine.setStroke(Color.GREEN);
                passwordLine.setStroke(Color.RED);
                userExistanceText.setText("Incorrect password! ");
            }
            case 2 -> {
                userNameLine.setStroke(Color.RED);
                passwordLine.setStroke(Color.GREEN);
                userExistanceText.setText("Incorrect username! ");
            }

            case 3 -> {
                userNameLine.setStroke(Color.GREEN);
                passwordLine.setStroke(Color.GREEN);
                parent.showFirstPage();
            }

        }

    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        user.add(this);
    }

    @Override
    public void update() {
        if (User.getInstance() != null) {

            hidePopUp();
        }
    }

    @FXML
    private void hidePopUp() {

        back.setVisible(false);
        pos_for_popUp_on_LogInPage.setVisible(false);
        logInContent.toFront();

    }


    private int logInCaseChecker() {

        int caseNumber = 0;

        if (user.getName() == null) {
            return caseNumber;
        }

        if (user.getUsername().equals(usernameField.getText())) {
            caseNumber++;
        }
        if (user.getPassword().equals(logInField.getText())) {
            caseNumber = caseNumber + 2;
        }

        return caseNumber;
    }

}
