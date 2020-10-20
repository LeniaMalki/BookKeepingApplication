package View.StatisticsView;

import View.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Service.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class StatisticsOverviewView implements iPane {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;

    static StatisticsOverviewView statisticsOverviewView;

    @FXML
    public AnchorPane dailyAnchor;

    @FXML
    public AnchorPane weeklyAnchor;

    @FXML
    public AnchorPane monthlyAnchor;

    @FXML
    public AnchorPane headerAnchorPane;

    @FXML
    public Button toDailyStatistics;

    @FXML
    public Button toWeeklyStatistics;

    @FXML
    public Button toMonthlyStatistics;

    public PieChart chart1;

    public PieChart chart2;

    public PieChart chart3;

    //_________________________________________________ METHODS ________________________________________________________

    public StatisticsOverviewView() {
        statisticsOverviewView = this;
    }

    public static StatisticsOverviewView getInstance() {
        if (statisticsOverviewView == null) {
            statisticsOverviewView = new StatisticsOverviewView();
        }
        return statisticsOverviewView;
    }

    public void showDetailStatisticsPage(final String text) {
        parent.showStatisticsDetailPage(text);
    }

    @Override
    public void initPane(final MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());

    }
}
