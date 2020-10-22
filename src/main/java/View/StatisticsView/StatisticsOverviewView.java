package View.StatisticsView;

import View.Interfaces.iPane;
import Service.PaneFactory;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
/**
 * @author : Oscar Forsberg
 * Responsibility: In charge of displaying the page for the overview statistics page.
 * Used by: StatisticsOverviewController, PaneFactory
 * Uses: iPane, JavaFX, MainView, PaneFactory
 */

public class StatisticsOverviewView implements iPane {

    //________________________________________________ VARIABLES _______________________________________________________

    MainView parent;

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
    /**
     * Constructor
     */
    public StatisticsOverviewView() {
        statisticsOverviewView = this;
    }
    /**
     * Singleton pattern for getting an instance of this class
     * @return instance of view
     */
    public static StatisticsOverviewView getInstance() {
        if (statisticsOverviewView == null) {
            statisticsOverviewView = new StatisticsOverviewView();
        }
        return statisticsOverviewView;
    }
    /**
     * Constructor
     */
    public void showDetailStatisticsPage(final String text) {
        parent.showStatisticsDetailPage(text);
    }

    /**
     * initialized this pane and sets header
     * @param parent a MainView
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());

    }
}
