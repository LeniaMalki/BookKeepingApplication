package controllers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class detailStatisticsController {

        @FXML
        private Hyperlink logo;

        @FXML
        private Hyperlink homeButton;

        @FXML
        private Hyperlink entryButton;

        @FXML
        private Hyperlink statisticsButton;

        @FXML
        private Hyperlink budgetButton;

        @FXML
        private Hyperlink goalsButton;

        @FXML
        private ScrollPane statisticsScrollPane;

        @FXML
        private Button statisticsButtonFood;

        @FXML
        private Button statisticsButtonHousehold;

        @FXML
        private Button statisticsButtonOther;

        @FXML
        private Button statisticsButtonShopping;

        @FXML
        private Button statisticsButtonTransport;

        @FXML
        private Text detailPageLabel;


    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("statisticsDetailPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
