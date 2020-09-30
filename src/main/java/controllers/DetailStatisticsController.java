package controllers;

import Model.Entry;
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
        double foodAmount = 0;
        double transportationAmount = 0;
        double householdAmount = 0;
        double shoppingAmount = 0;
        double otherAmount = 0;
        for (Entry entry : user.getEntries()) {
            flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
            listItemPink = !listItemPink;
            if (entry.getCategory().equals("Food")) {
                foodAmount += entry.getAmount();
            }
            if (entry.getCategory().equals("Transportation")) {
                transportationAmount += entry.getAmount();
            }
            if (entry.getCategory().equals("Household")) {
                householdAmount += entry.getAmount();
            }
            if (entry.getCategory().equals("Shopping")) {
                shoppingAmount += entry.getAmount();
            }
            if (entry.getCategory().equals("Other")) {
                otherAmount += entry.getAmount();
            }
        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Food", foodAmount),
                new PieChart.Data("Transportation", transportationAmount),
                new PieChart.Data("Household", householdAmount),
                new PieChart.Data("Shopping", shoppingAmount),
                new PieChart.Data("Other", otherAmount));
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



    @FXML
    private void food(ActionEvent event) {
        flowpaneStat.getChildren().clear();
        for (Entry entry : user.getEntries()) {
            if (entry.getCategory().equals("Food")) {
                flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
                listItemPink = !listItemPink;
            }
        }
    }

    @FXML
    private void transport(ActionEvent event) {
        flowpaneStat.getChildren().clear();
        for (Entry entry : user.getEntries()) {
            if (entry.getCategory().equals("Transportation")) {
                flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
                listItemPink = !listItemPink;
            }
        }
    }

    @FXML
    private void other(ActionEvent event) {
        flowpaneStat.getChildren().clear();
        for (Entry entry : user.getEntries()) {
            if (entry.getCategory().equals("Other")) {
                flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
                listItemPink = !listItemPink;
            }
        }
    }

    @FXML
    private void shopping(ActionEvent event) {
        flowpaneStat.getChildren().clear();
        for (Entry entry : user.getEntries()) {
            if (entry.getCategory().equals("Shopping")) {
                flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
                listItemPink = !listItemPink;
            }
        }
    }

    @FXML
    private void household(ActionEvent event) {
        flowpaneStat.getChildren().clear();
        for (Entry entry : user.getEntries()) {
            if (entry.getCategory().equals("Household")) {
                flowpaneStat.getChildren().add(new EntryListItemController(entry, listItemPink));
                listItemPink = !listItemPink;
            }
        }
    }
}
