package Controller.StatisticsController;

import Controller.EntryControllers.EntryListItemController;
import Controller.Interfaces.RemoveItemObserver;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 * A controller class for handling the page for detail statistics.
 * It listens to what happens to entries by implementing EntryObserver
 *
 * @author Oscar
 */
public class StatisticsDetailController implements iPane, EntryObserver, RemoveItemObserver {

    MainController parent;
    EntryHandler entryHandler = EntryHandler.getInstance();
    boolean allEntries;

    //__________________________________________________ FXML __________________________________________________________

    @FXML
    private FlowPane flowpaneStat;

    @FXML
    private Text labelPieChart;

    @FXML
    private AnchorPane headerAnchorPane;

    @FXML
    private AnchorPane chartPane;

    PieChart chart;

    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Initializes the pane when the program starts also adds the header
     * @param parent is the main controller
     */
    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        EntrySubject.add(this);
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        allEntries = true;
    }

    /**
     * A function (when button pressed) removeEntry that iterates through the lists of entries and removes the entry
     * if its selected.
     */
    public void update(Entry entry, EntryListItemController controller){
        entryHandler.getEntries().remove(entry);
        flowpaneStat.getChildren().remove(controller);
        updatePieChart();
        for (Entry e: entryHandler.getEntries()) {
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
        this.labelPieChart.setText(labelPieChart);
    }



    /**
     * A function that adds the entry to the visual list of entries in our program and updates the values of a PieChart.
     *
     * @param entry an Entry that is added to the FlowPane of entries. U
     */
    private void updateStatistics(Entry entry) {
        addEntryToFlowPane(entry);
        updatePieChart();

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
        if (chart == null) {
            chart = new PieChart(pieChartData);
            chartPane.getChildren().add(chart);
        } else chart.setData(pieChartData);
    }

    /**
     * A general function that is used to decrease code duplication. It goes through all entries and checks if some
     * entries match the given one. In that case, we add it to our FlowPane.
     *
     * @param category a string that represents the category of a certain entry.
     */
    private void entriesCheckCategory(String category) {
        flowpaneStat.getChildren().clear();
        for (Entry entry : entryHandler.getEntries()) {
            if (category.equals("") || entry.getCategory().equals(category)) {
                addEntryToFlowPane(entry);
            }
        }
        allEntries = category.equals("");
    }

    private void addEntryToFlowPane(Entry entry) {
        EntryListItemController entryListItemController = new EntryListItemController(entry);
        flowpaneStat.getChildren().add(entryListItemController);
        entryListItemController.add(this);
    }

    @FXML
    private void food(ActionEvent event) {
        entriesCheckCategory("Food");
    }

    @FXML
    private void transport(ActionEvent event) {
        entriesCheckCategory("Transportation");
    }

    @FXML
    private void other(ActionEvent event) {
        entriesCheckCategory("Other");

    }

    @FXML
    private void shopping(ActionEvent event) {
        entriesCheckCategory("Shopping");
    }

    @FXML
    private void household(ActionEvent event) {
        entriesCheckCategory("Household");
    }

    @FXML
    private void allEntries(ActionEvent event) {
        entriesCheckCategory("");
    }


    @Override
    public void update(String category, String type, double Value) {
    }

    @Override
    public void update(Entry entry) {
        updateStatistics(entry);
    }

}

