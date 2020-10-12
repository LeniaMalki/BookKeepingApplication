package Controller.BudgetControllers;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.BudgetLogic.Budget;
import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import Model.EntryLogic.EntrySubject;
import Model.Interfaces.EntryObserver;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.StackedBarChart;

import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BudgetCharPageController implements iPane, EntryObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    Budget budget;
    EntryHandler entryHandler = EntryHandler.getInstance();

    //__________________________________________________ FXML __________________________________________________________

    @FXML
    private Button editBudgetButton;
    @FXML
    private Button addNewBudgetButton;
    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private StackedBarChart stackedBarChart;
    @FXML
    private CategoryAxis categoryAxis;

    //_________________________________________________ METHODS ________________________________________________________

    @FXML
    private void addNewBudgetButton(ActionEvent event) throws IOException {
        parent.showBudgetPage();
        budget.setIncome("0");
        budget.setFoodCost(0);
        budget.setHouseholdCost(0);
        budget.setShoppingCost(0);
        budget.setTransportCost(0);
        budget.setOtherCost(0);
        budget.setSavingsCost(0);
    }

    @FXML
    private void editBudgetButton(ActionEvent event) throws IOException {
        parent.showBudgetPage();
        budget.getIncome();
        budget.getFoodCost();
        budget.getHouseholdCost();
        budget.getShoppingCost();
        budget.getTransportCost();
        budget.getOtherCost();
        budget.getSavingsCost();
    }


    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        EntrySubject.add(this);
    }

    private void updateCharts(Entry entry) {
        entryHandler.updateGraph();
        updatingStackedBarChart();
    }


    private void updatingStackedBarChart() {
        //categoryAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Food", "Household", "Shopping", "Transport", "Other", "Savings")));

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Budget");
        series1.getData().add(new XYChart.Data<>("Food", budget.getFoodCost()));
        series1.getData().add(new XYChart.Data<>("Household", 0));
        series1.getData().add(new XYChart.Data<>("Shopping", 0));
        series1.getData().add(new XYChart.Data<>("Transport", 0));
        series1.getData().add(new XYChart.Data<>("Other", 0));
        series1.getData().add(new XYChart.Data<>("Savings", 0));


        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Expenses");
        series2.getData().add(new XYChart.Data<>("Food", entryHandler.getFoodAmount()));
        series2.getData().add(new XYChart.Data<>("Household", entryHandler.getHouseholdAmount()));
        series2.getData().add(new XYChart.Data<>("Shopping", entryHandler.getShoppingAmount()));
        series2.getData().add(new XYChart.Data<>("Transport", entryHandler.getTransportationAmount()));
        series2.getData().add(new XYChart.Data<>("Other", entryHandler.getOtherAmount()));

        //stackedBarChart.getData().addAll(series2);

        stackedBarChart.getData().setAll(series2, series1);

    }

    @Override
    public void update(String category, String type, double Value) {

    }

    @Override
    public void update(Entry entry) {
        updateCharts(entry);
    }
}
