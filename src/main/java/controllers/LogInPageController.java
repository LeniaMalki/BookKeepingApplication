package controllers;

import Model.Interfaces.iPane;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class LogInPageController implements iPane {

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
    private void signUpButton(ActionEvent event) throws IOException {
        pos_for_popUp_on_LogInPage.getChildren().clear();
        pos_for_popUp_on_LogInPage.getChildren().add(parent.getSignUpPopUp());
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        pos_for_popUp_on_LogInPage.toFront();
    }

    @FXML
    private void loadFirstPage(ActionEvent event) throws IOException {

       /* if (user.getName() != null) {

            if (!user.getUsername().equals(usernameField.toString())) {

                usernameField.getStyleClass().add("confirmationButtonRed");
                System.out.println("Incorrect Username ");
            }

            if (!user.getPassword().equals(logInField.toString())) {

                logInField.getStyleClass().add("confirmationButtonRed");

                System.out.println("Password ");
            } else if (user.getUsername() != null && user.getPassword() != null) {


        */
                parent.showFirstPage();
                System.out.println("Correct log in");
                logInButton.getStyleClass().add("confirmationButtonGreen");

     /*       }
        } else {
            userExistanceText.setText("No user registered!");

        }
*/

    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
    }
}



