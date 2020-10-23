package Controller.BudgetControllers;

import Controller.Interfaces.ControllerInterface;
import Controller.Interfaces.RemoveItemObserver;
import Controller.Interfaces.RemoveItemSubject;
import StairwayInterfaces.iBudget;
import StairwayInterfaces.iEntry;
import StairwayInterfaces.iEntryHandler;
import Model.BudgetLogic.Budget;
import Model.Interfaces.BudgetSubject;
import Model.EntryLogic.EntryHandler;
import Model.Interfaces.EntrySubject;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;
import View.BudgetView.BudgetChartView;
import View.EntryView.EntryListItemView;
import javafx.collections.FXCollections;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author : viktoriawelzel
 * Responsibility: Updates and handles the BudgetChartPage
 * Used by: PaneFactory
 * Uses: ControllerInterface, EntryObserver, BudgetObserver, RemoveItemObserver, iBudget, iEntryHandler
 */
public class BudgetChartPageController implements EntryObserver, BudgetObserver, ControllerInterface, RemoveItemObserver {

    //________________________________________________ VARIABLES _______________________________________________________


    private final iBudget budget = new Budget(2,3,2,5,2,1,"25");
    private final iEntryHandler entryHandler = EntryHandler.getInstance();

    private final BudgetChartView budgetChartView = BudgetChartView.getInstance();
    final XYChart.Series<String, Number> series2 = new XYChart.Series<>();


    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Constructor.
     */
    public BudgetChartPageController(){
        setAllViewListeners();
        EntrySubject.add(this);
        BudgetSubject.add(this);
        RemoveItemSubject.add(this);
        budgetChartView.xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Food", "Household", "Shopping", "Transport", "Other", "General Saving")));
    }

    /**
     * Sets all the controller's view components to listeners.
     */
    @Override
    public void setAllViewListeners (){
        budgetChartView.addNewBudgetButton.setOnAction(a -> addNewBudgetButton());
        budgetChartView.editBudgetButton.setOnAction(a -> editBudgetButton());
    }

    /**
     * Sets the values that need to be added at the start of the program when pressing on the addNewBudget button.
     */
    private void addNewBudgetButton() {
        budgetChartView.showBudgetPage();
        budget.setIncome(null);
        budget.setFoodCost(0);
        budget.setHouseholdCost(0);
        budget.setShoppingCost(0);
        budget.setTransportCost(0);
        budget.setOtherCost(0);
        budget.setSavingsCost(0);
        budget.notifyBudgetListeners();
    }

    /**
     * Gets the values that need to be added at the start of the program when pressing on the editBudgetButton button
     */
    private void editBudgetButton() {
        budgetChartView.showBudgetPage();
        budget.getIncome();
        budget.getFoodCost();
        budget.getHouseholdCost();
        budget.getShoppingCost();
        budget.getTransportCost();
        budget.getOtherCost();
        budget.getSavingsCost();
    }

    /**
     * Adds the entry to the visual list of entries in our program and updates the values of a Stacked bar chart.
     */
    private void updateCharts() {
        entryHandler.updateTotalCategoryValues();
        updatingStackedBarChart();
    }

    /**
     * Creates/updates a Stacked bar chart by the use of an EntryHandler that has access to entries.
     */
    private void updatingStackedBarChart() {
        series2.setName("Expenses");
        series2.getData().add(new XYChart.Data<>("Food", entryHandler.getFoodAmount()));
        series2.getData().add(new XYChart.Data<>("Household", entryHandler.getHouseholdAmount()));
        series2.getData().add(new XYChart.Data<>("Shopping", entryHandler.getShoppingAmount()));
        series2.getData().add(new XYChart.Data<>("Transport", entryHandler.getTransportationAmount()));
        series2.getData().add(new XYChart.Data<>("Other", entryHandler.getOtherAmount()));
        series2.getData().add(new XYChart.Data<>("General Saving", entryHandler.getGeneralSaving()));
        budgetChartView.barChart.getData().add(series2);

    }

    /**
     * Creates/updates a Stacked bar chart with the budget values.
     */
    public void updateCostGraph(final iBudget budget){
        final XYChart.Series<String, Integer> series1 = new XYChart.Series<>();
        series1.setName("Budget");
        series1.getData().add(new XYChart.Data<>("Food", budget.getFoodCost()));
        series1.getData().add(new XYChart.Data<>("Household", budget.getHouseholdCost()));
        series1.getData().add(new XYChart.Data<>("Shopping", budget.getShoppingCost()));
        series1.getData().add(new XYChart.Data<>("Transport", budget.getTransportCost()));
        series1.getData().add(new XYChart.Data<>("Other", budget.getOtherCost()));
        series1.getData().add(new XYChart.Data<>("General Saving", budget.getSavingsCost()));
        budgetChartView.barChart.getData().setAll(series1);
    }

    @Override
    public void update(final String category, final String type, final double Value) {
    }

    @Override
    public void update(final iEntry entry) {
        updateCharts();
    }

    @Override
    public void update(final iBudget budget) {
        updateCostGraph(budget);
    }

    @Override
    public void update(final iEntry entry, final EntryListItemView controller) {
        updateCharts();
    }
}
