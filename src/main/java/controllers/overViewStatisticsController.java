package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class overViewStatisticsController {

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


    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("statisticsOverviewPage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
