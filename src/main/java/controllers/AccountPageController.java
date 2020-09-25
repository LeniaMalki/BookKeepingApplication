package controllers;

import Model.AccountHandler;
import Model.Interfaces.AccountObserver;
import Model.Interfaces.iPane;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class AccountPageController implements iPane, AccountObserver {

    User user = User.getInstance();
    MainController parent;

    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private AnchorPane pos_for_popUp_on_accountPage;
    @FXML
    private AnchorPane back;
    @FXML
    private TextField usernameSetting;
    @FXML
    private TextField nameSetting;
    @FXML
    private TextField emailSetting;
    @FXML
    private Button submitChangesButton;

    @FXML
    private void onDeleteAccountLinkPressed(ActionEvent event) throws IOException {

        popUpOpener();
        pos_for_popUp_on_accountPage.getChildren().add(parent.getDeleteAccountPopUp());
    }

    @FXML
    private void onChangePasswordLinkPressed(ActionEvent event) throws IOException {
        popUpOpener();
        pos_for_popUp_on_accountPage.getChildren().add(parent.getChangePasswordPopUp());
    }

    /**
     * Handles image view for opening a pop up on account page
     */
    private void popUpOpener() {
        pos_for_popUp_on_accountPage.getChildren().clear();
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        pos_for_popUp_on_accountPage.toFront();
    }

    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());

        user.add(this);

    }

    public void setAccountFields() {
        usernameSetting.setText(user.getUsername());
        nameSetting.setText(user.getName());
        emailSetting.setText(user.getEmailAddress());
    }

    @Override
    public void update() {
        setAccountFields();

    }

    public void onUsernameEdited() {
        user.setUsername(usernameSetting.getText());
        System.out.println("username  " + user.getUsername());
    }

    public void onNameEdited() {

        user.setName(nameSetting.getText());
        System.out.println("name:  " + user.getName());

    }

    public void onEmailEdited() {
        user.setEmailAddress(emailSetting.getText());
        System.out.println("email address:  " + user.getEmailAddress());
    }

    private boolean changeAccountTextFields() {

        int numError = 0;

        AccountHandler accountHandler = new AccountHandler() {
            @Override
            public boolean isValidEmail(String email) {
                return super.isValidEmail(email);
            }

            @Override
            public boolean isValidName(String name) {
                return super.isValidName(name);
            }
        };

        if (!accountHandler.isValidEmail(emailSetting.getText())) {

            emailSetting.getStyleClass().add("confirmationButtonRed");
            numError++;
        }
        if (!accountHandler.isValidName(nameSetting.getText())) {

            nameSetting.getStyleClass().add("confirmationButtonRed");
            numError++;
        }
        if (usernameSetting.getText().length() == 0) {
            usernameSetting.getStyleClass().add("confirmationButtonRed");
            numError++;
        }

        if (accountHandler.isValidName(nameSetting.getText()) && accountHandler.isValidEmail(emailSetting.getText()) && !(usernameSetting.getText().length() == 0)) {

            nameSetting.getStyleClass().remove("confirmationButtonRed");
            emailSetting.getStyleClass().remove("confirmationButtonRed");
            usernameSetting.getStyleClass().remove("confirmationButtonRed");
            nameSetting.getStyleClass().add("confirmationButtonGreen");
            emailSetting.getStyleClass().add("confirmationButtonGreen");
            usernameSetting.getStyleClass().add("confirmationButtonGreen");
        }

        return numError == 0;
    }


    @FXML
    private void onActionSubmitChangesButton() {

        if (changeAccountTextFields()) {
            onUsernameEdited();
            onEmailEdited();
            onNameEdited();
        }

        submitChangesButton.getStyleClass().add("confirmationButtonRed");


    }

}