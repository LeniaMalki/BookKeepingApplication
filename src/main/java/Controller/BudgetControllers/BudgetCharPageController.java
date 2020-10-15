package Controller.BudgetControllers;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import Model.EntryLogic.EntrySubject;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Arrays;

import javafx.scene.chart.XYChart;

public class BudgetCharPageController implements iPane, EntryObserver, BudgetObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    Budget budget = new Budget(2,3,2,5,2,1,"25");
    EntryHandler entryHandler = EntryHandler.getInstance();


    //__________________________________________________ FXML __________________________________________________________

    @FXML
    private Button editBudgetButton;
    @FXML
    private Button addNewBudgetButton;
    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    public BarChart barChart;
    @FXML
    private CategoryAxis categoryAxis;
    @FXML
    AnchorPane rootAnchorPane;
    @FXML
    private CategoryAxis xAxis;


    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Sets the values that need to be added at the start of the program when pressing on the addNewBudget button
     * @param event if something is pressed an ActionEvent is fired and tells the system what happened
     * @throws IOException
     */

    @FXML
    private void addNewBudgetButton(ActionEvent event) throws IOException {
        parent.showBudgetPage();
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
     * @param event if something is pressed an ActionEvent is fired and tells the system what happened
     * @throws IOException
     */

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

    /**
     * Initializes the pane when the program starts also adds the header
     * @param parent the main controller
     */
    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        EntrySubject.add(this);
        BudgetSubject.add(this);
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Food", "Household", "Shopping", "Transport", "Other", "Savings")));

    }

    /**
     * Adds the entry to the visual list of entries in our program and updates the values of a Stacked bar chart.
     * @param entry an Entry that is added to the FlowPane of entries.
     */

    private void updateCharts(Entry entry) {
        entryHandler.updateTotalCategoryValues();
        updatingStackedBarChart();
    }

    /**
     * Creates/updates a Stacked bar chart by the use of an EntryHandler that has access to entries.
     */
    private void updatingStackedBarChart() {
        //categoryAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList("Food", "Household", "Shopping", "Transport", "Other", "Savings")));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Expenses");
        series2.getData().add(new XYChart.Data<>("Food", entryHandler.getFoodAmount()));
        series2.getData().add(new XYChart.Data<>("Household", entryHandler.getHouseholdAmount()));
        series2.getData().add(new XYChart.Data<>("Shopping", entryHandler.getShoppingAmount()));
        series2.getData().add(new XYChart.Data<>("Transport", entryHandler.getTransportationAmount()));
        series2.getData().add(new XYChart.Data<>("Other", entryHandler.getOtherAmount()));
        barChart.getData().addAll(series2);

    }
    public void updateGostGraph(Budget budget){
        XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
        series1.setName("Budget");
        series1.getData().add(new XYChart.Data<>("Food", budget.getFoodCost()));
        series1.getData().add(new XYChart.Data<>("Household", budget.getHouseholdCost()));
        series1.getData().add(new XYChart.Data<>("Shopping", budget.getShoppingCost()));
        series1.getData().add(new XYChart.Data<>("Transport", budget.getTransportCost()));
        series1.getData().add(new XYChart.Data<>("Other", budget.getOtherCost()));
        series1.getData().add(new XYChart.Data<>("Savings", budget.getSavingsCost()));
        barChart.getData().setAll(series1);


    }

    @Override
    public void update(String category, String type, double Value) {
    }

    @Override
    public void update(Entry entry) {
        updateCharts(entry);
    }

    @Override
    public void update(Budget b) {
        updateGostGraph(b);
    }
}
