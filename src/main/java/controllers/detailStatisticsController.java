package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class detailStatisticsController implements Initializable {

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

    @FXML
    private AnchorPane headerAnchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/header.fxml"));
            headerAnchorPane.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
