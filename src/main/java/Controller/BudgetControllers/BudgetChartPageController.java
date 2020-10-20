package Controller.BudgetControllers;

import Controller.Interfaces.ControllerInterface;
import Interfaces.iEntryHandler;
import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.EntryLogic.iEntry;
import Model.EntryLogic.EntryHandler;
import Model.EntryLogic.EntrySubject;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;
import View.BudgetView.BudgetChartView;
import javafx.collections.FXCollections;
import java.io.IOException;
import java.util.Arrays;
import javafx.scene.chart.XYChart;

/**
 * Controller for the budget chart
 *
 * @author viktoriawelzel
 */
public class BudgetChartPageController implements EntryObserver, BudgetObserver, ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________


    private final Budget budget = new Budget(2,3,2,5,2,1,"25");
    private final iEntryHandler entryHandler = EntryHandler.getInstance();

    private final XYChart.Series<String, Number> series2 = new XYChart.Series<>();
    private final BudgetChartView budgetChartView = BudgetChartView.getInstance();

    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Controller of the Budget Chart Page.
     */

    public BudgetChartPageController(){
        setAllViewListeners();
        EntrySubject.add(this);
        BudgetSubject.add(this);
        budgetChartView.xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Food", "Household", "Shopping", "Transport", "Other", "General Saving")));
    }

    @Override
    public void setAllViewListeners (){
        budgetChartView.addNewBudgetButton.setOnAction(a -> addNewBudgetButton());
        budgetChartView.editBudgetButton.setOnAction(a -> editBudgetButton());
    }

    /**
     * Sets the values that need to be added at the start of the program when pressing on the addNewBudget button
     * //@param event if something is pressed an ActionEvent is fired and tells the system what happened
     * @throws IOException
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
     * //@param event if something is pressed an ActionEvent is fired and tells the system what happened
     * @throws IOException
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
     * //@param entry an Entry that is added to the FlowPane of entries.
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

    public void updateGostGraph(final Budget budget){
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
    public void update(iEntry entry) {
        updateCharts();

    }

    @Override
    public void update(final Budget budget) {
        updateGostGraph(budget);
    }
}
