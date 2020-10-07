package Controller;

import Controller.Interfaces.iPane;
import Model.Entry;
import Model.Interfaces.EntryObserver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
/**
 * A controller that handles the overview statistics page
 * It listens to what happens to entries by implementing EntryObserver
 *
 * @author Oscar
 */
public class StatisticsOverViewController implements iPane, EntryObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;

    //__________________________________________________ FXML __________________________________________________________

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

    //_________________________________________________ METHODS ________________________________________________________

    @FXML
    void toDailyStatistics(ActionEvent event) {
        detailedStatistics("Daily");  //TODO DIVERSIFY FOR WEEKLY / DAILY / MONTHLY, TEXT AND PIECHART NEEDS TO
    }
    @FXML
    void toWeeklyStatistics(ActionEvent event) {
        detailedStatistics("Weekly");
    }
    @FXML
    void toMonthlyStatistics(ActionEvent event) {
        detailedStatistics("Monthly");
    }

    /**
     * A function that shows different texts on the detailStatisticsPage depending on which button you press
     *
     * @param text that is either "Daily", "Monthly" or "Weekly"
     */
    private void detailedStatistics(String text) {
        parent.showStatisticsDetailPage(text);
    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    @Override
    public void update(String category, String type, double Value) {

    }

    @Override
    public void update(Entry entry) {

    }
}
