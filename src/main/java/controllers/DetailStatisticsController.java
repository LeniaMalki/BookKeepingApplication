package controllers;

import Model.Entry;
import Model.EntryHandler;
import Model.EntrySubject;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.iPane;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class DetailStatisticsController implements iPane, EntryObserver {

    MainController parent;
    EntryHandler entryHandler;
    User user = User.getInstance();
    boolean listItemPink = false;

    @FXML
    private PieChart statisticsPieChart;

    @FXML
    private ScrollPane statisticsScrollPane;

    @FXML
    private FlowPane flowpaneStat;

    @FXML
    private Text labelPieChart;

    @FXML
    private AnchorPane headerAnchorPane;


    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        user.add(this);
        entryHandler = user.getEntryHandler();
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    public void setLabelPieChart(String labelPieChart) {
        this.labelPieChart.setText(labelPieChart);
    }

    @Override
    public void update() {
        updateStatistics();
    }

    private void updateStatistics() {
        flowpaneStat.getChildren().clear();

        for (Entry entry : entryHandler.getEntries()) {
            flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
            listItemPink = !listItemPink;

        }
        entryHandler.update();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Food", entryHandler.getFoodAmount()),
                new PieChart.Data("Transportation", entryHandler.getTransportationAmount()),
                new PieChart.Data("Household", entryHandler.getHouseholdAmount()),
                new PieChart.Data("Shopping", entryHandler.getShoppingAmount()),
                new PieChart.Data("Other", entryHandler.getOtherAmount()));
        statisticsPieChart.setData(pieChartData);
    }

    /*@FXML
    void deleteEntry(ActionEvent event) {

        final int selectedTodo = todoListView.getSelectionModel().getSelectedIndex();
        if (selectedTodo != -1) {
            // TodoEntry itemToRemove = todoListView.getSelectionModel().getSelectedItem();
            final int newSelectedTodo = (selectedTodo == todoListView.getItems().size() - 1) ? selectedTodo - 1 : selectedTodo;

            todoListView.getItems().remove(selectedTodo);
            todoListView.getSelectionModel().select(newSelectedTodo);

        }
    }*/

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
