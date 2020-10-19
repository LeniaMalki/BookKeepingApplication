package Controller.StatisticsController;

import Controller.EntryControllers.EntryListItemController;
import Controller.Interfaces.RemoveItemObserver;
import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import Model.EntryLogic.EntrySubject;
import Model.Interfaces.ControllerInterface;
import Model.Interfaces.EntryObserver;
import View.EntryView.EntryListItemView;
import View.StatisticsView.StatisticsDetailView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 * A controller class for handling the page for detail statistics.
 * It listens to what happens to entries by implementing EntryObserver
 *
 * @author Oscar
 */
public class StatisticsDetailController implements EntryObserver, RemoveItemObserver, ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________

    EntryHandler entryHandler = EntryHandler.getInstance();
    boolean allEntries;
    private StatisticsDetailView statisticsDetailView = StatisticsDetailView.getInstance();

    //_________________________________________________ METHODS ________________________________________________________

    public StatisticsDetailController() {
        setAllViewListeners();
        EntrySubject.add(this);
    }


    /**
     * A function (when button pressed) removeEntry that iterates through the lists of entries and removes the entry
     * if its selected.
     */
    public void update(Entry entry, EntryListItemView controller) {
        entryHandler.getEntries().remove(entry);
        statisticsDetailView.flowpaneStat.getChildren().remove(controller);
        updatePieChart();
        for (Entry e : entryHandler.getEntries()) {
            if (!allEntries) {
                entriesCheckCategory(e.getCategory());
            } else {
                entriesCheckCategory("");
            }
        }
    }


    /**
     * A function that gets the appropriate text for our different time-spans of statistics
     *
     * @param labelPieChart a string that is either "Daily", "Weekly", "Monthly"
     */
    public void setLabelPieChart(String labelPieChart) {
        statisticsDetailView.setLabel(labelPieChart);
    }


    /**
     * A function that creates/updates a PieChart by the use of an EntryHandler that has access to entries.
     */
    private void updatePieChart() {
        entryHandler.updateTotalCategoryValues();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount()),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount()),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount()),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount()),
                new PieChart.Data("Other", entryHandler.getOtherAmount()));
        if (statisticsDetailView.chart == null) {
            statisticsDetailView.chart = new PieChart(pieChartData);
            statisticsDetailView.chartPane.getChildren().add(statisticsDetailView.chart);
        } else statisticsDetailView.chart.setData(pieChartData);
    }

    /**
     * A general function that is used to decrease code duplication. It goes through all entries and checks if some
     * entries match the given one. In that case, we add it to our FlowPane.
     *
     * @param category a string that represents the category of a certain entry.
     * @return
     */
    private void entriesCheckCategory(String category) {
        statisticsDetailView.flowpaneStat.getChildren().clear();
        for (Entry entry : entryHandler.getEntries()) {
            if (category.equals("") || entry.getCategory().equals(category)) {
                addEntryToFlowPane(entry);
            }
        }
        allEntries = category.equals("");
    }

    /**
     * A function that adds an entry to a FlowPane
     *
     * @param entry is a an entry that we add to our EntryListItemController.
     */
    private void addEntryToFlowPane(Entry entry) {
        EntryListItemController entryListItemController = new EntryListItemController(entry);
        statisticsDetailView.flowpaneStat.getChildren().add(entryListItemController.getView());
        entryListItemController.add(this);
    }

    @Override
    public void setAllViewListeners() {
        statisticsDetailView.statisticsButtonAllEntries.setOnAction(a -> entriesCheckCategory(""));
        statisticsDetailView.statisticsButtonOther.setOnAction(a -> entriesCheckCategory("Other"));
        statisticsDetailView.statisticsButtonHousehold.setOnAction(a -> entriesCheckCategory("Household"));
        statisticsDetailView.statisticsButtonTransport.setOnAction(a -> entriesCheckCategory("Transportation"));
        statisticsDetailView.statisticsButtonShopping.setOnAction(a -> entriesCheckCategory("Shopping"));
        statisticsDetailView.statisticsButtonFood.setOnAction(a -> entriesCheckCategory("Food"));

    }

    @Override
    public void update(String category, String type, double Value) {
    }

    @Override
    public void update(Entry entry) {
        entriesCheckCategory("");
        updatePieChart();
    }

}

