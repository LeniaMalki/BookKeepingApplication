package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class accountPageController {

    @FXML
    private AnchorPane darkBack;

    @FXML
    private ImageView editUsername;

    @FXML
    private ImageView editName;

    @FXML
    private ImageView editEmail;

    @FXML
    private Hyperlink changePasswordHyperLink;

    @FXML
    private Hyperlink deleteAccountHyperLink;

    @FXML
    private ImageView changeLanguage;

    @FXML
    private AnchorPane positionOfPopUp;

    @FXML
    private AnchorPane headerAnchorPane;

    //Loads account page
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("accountPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //Loads the default header header.fxml and anchors it to top of page
    @FXML
    private void loadHeader() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/header.fxml"));
        headerAnchorPane.getChildren().setAll(pane);
    }

    //opens up deleteAccountPopUp.fxml when clicking on "Delete Account" hyperlink and positions it in the specified anchor
    @FXML
    void deleteAccountHyperLink_CLICKED(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/deleteAccountPopUp.fxml"));
        positionOfPopUp.getChildren().setAll(pane);
        //darkBack.toFront();
        positionOfPopUp.toFront();

    }

    //opens up changePasswordPopUp.fxml when clicking on "Change password" hyperlink and positions it in the specified anchor
    @FXML
    public void changePasswordHyperLink_CLICKED(ActionEvent actionEvent) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/changePasswordPopUp.fxml"));
        positionOfPopUp.getChildren().setAll(pane);
        positionOfPopUp.toFront();


    }
}

