package controllers;

import Model.*;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.iPane;
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
    EntryHandler entryHandler=EntryHandler.getInstance();

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
    @FXML
    private AnchorPane chartPane;
    DounutChart chart;

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        EntrySubject.add(this);

        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

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
        if (chart==null){
            chart = new DounutChart(pieChartData);
            chartPane.getChildren().add(chart);
        }else chart.setData(pieChartData);

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
