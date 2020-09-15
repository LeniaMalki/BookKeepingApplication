package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class overViewStatisticsController implements ChildPane {

    mainController parent;

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

    @FXML
    void toDailyStatistics(ActionEvent event) {
        parent.showStatisticsDetailPage();  //TODO DIVERSIFY FOR WEEKLY / DAILY / MONTHLY, TEXT AND PIECHART NEEDS TO
                                                //UPDATE DEPENDING ON WHICH BUTTON YOU PRESS
    }

    @FXML
    void toMonthlyStatistics(ActionEvent event) {
        parent.showStatisticsDetailPage();
    }

    @FXML
    void toWeeklyStatistics(ActionEvent event) {
        parent.showStatisticsDetailPage();
    }

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
