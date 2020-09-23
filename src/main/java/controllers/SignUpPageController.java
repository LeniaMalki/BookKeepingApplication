package controllers;

import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SignUpPageController {

    public AnchorPane signUpPopUp;

    MainController parent;
    User user = User.getInstance();

    @FXML
    private TextField signUpName;

    @FXML
    private TextField signUpUsername;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private PasswordField signUpConfirmPassword;

    @FXML
    private TextField signUpEmail;

    @FXML
    private Button createAccount;

    public void initPane(MainController parent) {
        this.parent = parent;
    }


    @FXML
    private void handleCreateAccountAction(ActionEvent event) {
        user.setName(signUpName.getText());
        user.setUsername(signUpUsername.getText());
        user.setEmailAddress(signUpEmail.getText());
        user.setPassword(signUpPassword.getText());
        user.setConfirmPassword(signUpConfirmPassword.getText());

        if (user.isAllFieldsEntered()) {

            if (user.doesPasswordMatch(user.getConfirmPassword())) {
                System.out.println("all fields entered: " + user.getName() + " " + user.getUsername() + " " + user.getEmailAddress() + " " + user.getPassword());
                parent.showFirstPage();
            }

            else  {System.out.println("Password does not match!");


            }
        }

        else System.out.println("fields missing");


    }


}

