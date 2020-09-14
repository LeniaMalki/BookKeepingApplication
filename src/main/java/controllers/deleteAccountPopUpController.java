package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class deleteAccountPopUpController {

    @FXML
    private AnchorPane deleteAccountPopUp;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private ImageView closeButtom;

    @FXML
    private PasswordField enterDeletePasswordField;

    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("deleteAcountPopUp.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
