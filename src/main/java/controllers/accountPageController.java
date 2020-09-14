package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class accountPageController {
    @FXML
    private ImageView editUsername;

    @FXML
    private ImageView editName;

    @FXML
    private ImageView editEmail;

    @FXML
    private Hyperlink changePasswordLink;

    @FXML
    private Hyperlink deleteAccountLink;

    @FXML
    private ImageView changeLanguage;

    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("accountPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
