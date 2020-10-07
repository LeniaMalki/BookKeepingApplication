package Controller;

import Model.*;
import Model.Interfaces.EntryObserver;
import Controller.Interfaces.iPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 * A controller class for handling the page for detail statistics.
 * It listens to what happens to entries by implementing EntryObserver
 *
 * @author Oscar
 */
public class DetailStatisticsController implements iPane, EntryObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    EntryHandler entryHandler = EntryHandler.getInstance();
    boolean listItemPink = false;

    //__________________________________________________ FXML __________________________________________________________

    @FXML
    private ScrollPane statisticsScrollPane;

    @FXML
    private FlowPane flowpaneStat;

    @FXML
    private Text labelPieChart;

    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private AnchorPane chartPane;
    DounutChart chart;

    //_________________________________________________ METHODS ________________________________________________________

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        EntrySubject.add(this);

        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    /**
     * A function that gets the appropriate text for our different timespans for statistics
     *
     * @param labelPieChart a string that is either "Daily", "Weekly", "Monthly"
     */
    public void setLabelPieChart(String labelPieChart) {
        this.labelPieChart.setText(labelPieChart);
    }

    @Override
    public void update(String category, String type, double Value) {
        //TODO whatever this is intended to do? @Artin

    }

    @Override
    public void update(Entry entry) {
        updateStatistics(entry);
    }

    /**
     * A function that creates a new PieChart by the use of an EntryHandler that has access to entries.
     *
     * @param entry an entry that is used to create a new EntryListItemController. This makes it possible to get
     *              every other row pink and every other row white.
     */
    private void updateStatistics(Entry entry) {

        flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
        listItemPink = !listItemPink;


        entryHandler.updateGraph();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount()),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount()),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount()),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount()),
                new PieChart.Data("Other", entryHandler.getOtherAmount()));
        if (chart == null) {
            chart = new DounutChart(pieChartData);
            chartPane.getChildren().add(chart);
        } else chart.setData(pieChartData);

    }

    /**
     * A general function that is used to decrease code duplication. It goes through all entries and checks if some
     * entries match the given one. In that case, we add it to our FlowPane.
     *
     * @param category a string that represents the category of a certain entry.
     */
    private void entriesCategory(String category) {
        flowpaneStat.getChildren().clear();
        for (Entry entry : entryHandler.getEntries()) {
            if (entry.getCategory().equals(category)) {
                flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
                listItemPink = !listItemPink;
            }
        }
    }

    @FXML
    private void food(ActionEvent event) {
        entriesCategory("Food");
    }

    @FXML
    private void transport(ActionEvent event) {
        entriesCategory("Transportation");
    }

    @FXML
    private void other(ActionEvent event) {
        entriesCategory("Other");
    }

    @FXML
    private void shopping(ActionEvent event) {
        entriesCategory("Shopping");
    }

    @FXML
    private void household(ActionEvent event) {
        entriesCategory("Household");
    }
}