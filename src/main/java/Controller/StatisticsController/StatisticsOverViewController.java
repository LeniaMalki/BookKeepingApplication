package Controller.StatisticsController;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import Model.EntryLogic.EntrySubject;
import Model.Interfaces.EntryObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

/**
 * A controller that handles the overview statistics page
 * It listens to what happens to entries by implementing EntryObserver
 *
 * @author Oscar
 */
public class StatisticsOverViewController implements iPane, EntryObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    EntryHandler entryHandler = EntryHandler.getInstance();
    PieChart chart1;
    PieChart chart2;
    PieChart chart3;
    //__________________________________________________ FXML __________________________________________________________

    @FXML
    private AnchorPane dailyAnchor;

    @FXML
    private AnchorPane weeklyAnchor;

    @FXML
    private AnchorPane monthlyAnchor;

    @FXML
    private AnchorPane headerAnchorPane;

    //_________________________________________________ METHODS ________________________________________________________

    @FXML
    void toDailyStatistics(ActionEvent event) {
        detailedStatistics("Daily");
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

    //__________ THIS PART IS NOT IMPLEMENTED YET, JUST SOME HARD CODED EXAMPLES TO ILLUSTRATE IN OUR PROGRAM __________

    private void updateStatisticsPiechart(Entry entry) {
        entryHandler.updateTotalCategoryValues();
        updateDailyStatistics();
        updateWeeklyStatistics();
        updateMonthlyStatistics();
    }
    private void updateDailyStatistics(){
        ObservableList<PieChart.Data> pieChartData1 = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount()),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount()),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount()),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount()),
                new PieChart.Data("Other", entryHandler.getOtherAmount()));
        if (chart1 == null) {
            chart1 = new PieChart(pieChartData1);
            dailyAnchor.getChildren().add(chart1);
        } else chart1.setData(pieChartData1);
    }

    private void updateWeeklyStatistics(){
        ObservableList<PieChart.Data> pieChartData2 = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount()+205),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount()+200),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount()+50),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount()+10),
                new PieChart.Data("Other", entryHandler.getOtherAmount()+222));
        if (chart2 == null) {
            chart2 = new PieChart(pieChartData2);
            weeklyAnchor.getChildren().add(chart2);
        } else chart2.setData(pieChartData2);
    }

    private void updateMonthlyStatistics(){
        ObservableList<PieChart.Data> pieChartData3 = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount()+115),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount()+10),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount()+50),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount()+20),
                new PieChart.Data("Other", entryHandler.getOtherAmount()+100));
        if (chart3 == null) {
            chart3 = new PieChart(pieChartData3);
            monthlyAnchor.getChildren().add(chart3);
        } else chart3.setData(pieChartData3);
    }
    //__________________________________________________________________________________________________________________

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        EntrySubject.add(this);
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    @Override
    public void update(String category, String type, double Value) {

    }

    @Override
    public void update(Entry entry) {
        updateStatisticsPiechart(entry);

    }

}
