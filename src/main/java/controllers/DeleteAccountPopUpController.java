package controllers;

import Model.AccountHandler;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class DeleteAccountPopUpController {

    @FXML
    public AnchorPane delAccPopUp;
    MainController parent;
    User user = User.getInstance();

    @FXML
    private Button deleteAccountButton;
    @FXML
    private ImageView exitButton;
    @FXML
    private PasswordField enterPasswordToDelete;
    @FXML
    private Text passwordIncorrectMessage;


    public void initPane(MainController parent) {
        this.parent = parent;
    }


    @FXML
    public void deleteAccountConfirm(ActionEvent actionEvent) {


        AccountHandler accountHandler = new AccountHandler() {
            @Override
            public boolean doesPasswordMatch(String userPassword, String confirmPassword) {
                return super.doesPasswordMatch(userPassword, confirmPassword);
            }
        };

        if (accountHandler.doesPasswordMatch(user.getPassword(), enterPasswordToDelete.getText())) {
            parent.showLogInPage();

        } else {
            passwordIncorrectMessage.setText("Password is incorrect! Try again.");
            enterPasswordToDelete.getStyleClass().add("confirmationButtonRed");
        }


    }

}