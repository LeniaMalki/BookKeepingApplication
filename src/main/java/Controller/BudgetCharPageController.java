package Controller;

import Controller.Interfaces.iPane;
import Model.Budget;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.StackedBarChart;

import javafx.collections.FXCollections;

import java.util.Arrays;

public class BudgetCharPageController implements iPane {


    MainController parent;

    Budget budget;

    @FXML
    private Button editBudgetButton;

    @FXML
    private Button addNewBudgetButton;

    @FXML
    private AnchorPane headerAnchorPane;

    @FXML
    private StackedBarChart sb;

    @FXML
    private CategoryAxis categoryAxis;


    @FXML
    private void addNewBudgetButton(ActionEvent event) throws IOException {
        parent.showBudgetPage();
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

        categoryAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Food", "Household", "Shopping", "Transport", "Other", "Savings")));

        //categoryAxis.getCategories().addAll("Food", "Household", "Shopping", "Transport", "Other", "Savings");

        //categoryAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList ("Africa", "America", "Asia", "Europe", "Oceania")));

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Budget");

        series1.getData().add(new XYChart.Data<>("Food", 0));
        series1.getData().add(new XYChart.Data<>("Household", 0));
        series1.getData().add(new XYChart.Data<>("Shopping", 0));
        series1.getData().add(new XYChart.Data<>("Transport", 0));
        series1.getData().add(new XYChart.Data<>("Other", 0));
        series1.getData().add(new XYChart.Data<>("Savings", 0));


        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("1900");
        series2.getData().add(new XYChart.Data<>("Food", 133));
        series2.getData().add(new XYChart.Data<>("Household", 156));
        series2.getData().add(new XYChart.Data<>("Shopping", 947));
        series2.getData().add(new XYChart.Data<>("Transport", 408));
        series1.getData().add(new XYChart.Data<>("Other", 6));

        sb.getData().addAll(series1, series2);

    }

}
