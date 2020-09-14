package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class overViewStatisticsController implements Initializable {

        @FXML
        private Button toDailyStatisticsButton;

        @FXML
        private Button toMonthlyStatisticsButton;

        @FXML
        private Button toWeeklyStatisticsButton;

        @FXML
        private PieChart dailyOverviewPieChart;

        @FXML
        private PieChart weeklyOverviewPieChart;

        @FXML
        private PieChart monthlyOverviewPieChart;

        @FXML
        private Text overviewDailyPieChartText;

        @FXML
        private Text overviewWeeklyPieChartText;

        @FXML
        private Text overviewMonthlyPieChartText;

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
