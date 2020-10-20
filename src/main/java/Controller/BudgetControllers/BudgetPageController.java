package Controller.BudgetControllers;

import Controller.Interfaces.ControllerInterface;
import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.Interfaces.BudgetObserver;
import View.BudgetView.BudgetView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.converter.NumberStringConverter;
import java.util.ArrayList;

/**
 * Controller for the budget page
 *
 * @author viktoriawelzel
 */
public class BudgetPageController implements BudgetObserver, ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________

    private ArrayList<Budget> budgetList = new ArrayList<Budget>();
    int i = 1;
    int selected = 0;
    Budget budget;
    BudgetView budgetView = BudgetView.getInstance();

    //_________________________________________________ METHODS ________________________________________________________

    public BudgetPageController() {
        setAllViewListeners();
        budget = new Budget(0, 0, 0, 0, 0, 0, null);
        BudgetSubject.add(this);
        listeningToChanges();
        connectingTextFieldsAndSliders();
        updateAllValues();
    }

    @Override
    public void setAllViewListeners() {
        budgetView.saveButton.setOnAction(a -> onSaveButtonPressed());
        budgetView.enterIncomeTextField.setOnAction(a -> updatingMoneyLeft());
        budgetView.enterIncomeTextField.setOnMouseExited(a -> setMaxOnSlider());
        budgetView.previousBudgetComboBox.setOnAction(a -> comboSelector());

        budgetView.foodSlider.setOnMouseDragged(a -> updatingMoneyLeft());
        budgetView.householdSlider.setOnMouseDragged(a -> updatingMoneyLeft());
        budgetView.shoppingSlider.setOnMouseDragged(a -> updatingMoneyLeft());
        budgetView.transportSlider.setOnMouseDragged(a -> updatingMoneyLeft());
        budgetView.otherSlider.setOnMouseDragged(a -> updatingMoneyLeft());
        budgetView.savingsSlider.setOnMouseDragged(a -> updatingMoneyLeft());

        budgetView.foodTextField.setOnKeyTyped(a -> updatingMoneyLeft());
        budgetView.householdTextField.setOnKeyTyped(a -> updatingMoneyLeft());
        budgetView.shoppingTextField.setOnKeyTyped(a -> updatingMoneyLeft());
        budgetView.transportTextField.setOnKeyTyped(a -> updatingMoneyLeft());
        budgetView.otherTextField.setOnKeyTyped(a -> updatingMoneyLeft());
        budgetView.savingsTextField.setOnKeyTyped(a -> updatingMoneyLeft());
    }

    /**
     * Listener that changes the progressbar according to the value of the slider
     */

    private void listeningToChanges() {
        ChangeListener<Number> changeListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                selected = 0;
                updateProgress();
            }
        };

        budgetView.foodSlider.valueProperty().addListener(changeListener);
        budgetView.householdSlider.valueProperty().addListener(changeListener);
        budgetView.shoppingSlider.valueProperty().addListener(changeListener);
        budgetView.transportSlider.valueProperty().addListener(changeListener);
        budgetView.otherSlider.valueProperty().addListener(changeListener);
        budgetView.savingsSlider.valueProperty().addListener(changeListener);
    }

    /**
     * Binds the sliders and the textFields
     */

    private void connectingTextFieldsAndSliders() {
        budgetView.foodTextField.textProperty().bindBidirectional(budgetView.foodSlider.valueProperty(), new NumberStringConverter());
        budgetView.householdTextField.textProperty().bindBidirectional(budgetView.householdSlider.valueProperty(), new NumberStringConverter());
        budgetView.shoppingTextField.textProperty().bindBidirectional(budgetView.shoppingSlider.valueProperty(), new NumberStringConverter());
        budgetView.transportTextField.textProperty().bindBidirectional(budgetView.transportSlider.valueProperty(), new NumberStringConverter());
        budgetView.otherTextField.textProperty().bindBidirectional(budgetView.otherSlider.valueProperty(), new NumberStringConverter());
        budgetView.savingsTextField.textProperty().bindBidirectional(budgetView.savingsSlider.valueProperty(), new NumberStringConverter());
    }

    /**
     * Adds a new budget to the list
     *
     * @param i the current budgetnumber
     */

    private void addingMenuItem(int i) {
        budgetView.previousBudgetComboBox.getItems().add("Budget " + i);
        budgetList.add(new Budget((int) budgetView.foodSlider.getValue(), (int) budgetView.householdSlider.getValue(),
                (int) budgetView.shoppingSlider.getValue(), (int) budgetView.transportSlider.getValue(), (int) budgetView.savingsSlider.getValue(),
                (int) budgetView.otherSlider.getValue(), budgetView.enterIncomeTextField.getText()));
    }

    /**
     * Handles selection of the ComboBox for the previous budgets
     */

    private void comboSelector() {
        selected = budgetView.previousBudgetComboBox.getSelectionModel().getSelectedIndex();
        budget.setIncome((budgetList.get(selected).getIncome()));
        budget.setFoodCost(budgetList.get(selected).getFoodCost());
        budget.setHouseholdCost(budgetList.get(selected).getHouseholdCost());
        budget.setShoppingCost(budgetList.get(selected).getShoppingCost());
        budget.setTransportCost(budgetList.get(selected).getTransportCost());
        budget.setSavingsCost(budgetList.get(selected).getSavingsCost());
        budget.setOtherCost(budgetList.get(selected).getOtherCost());
        budget.notifyBudgetListeners();
        setMaxOnSlider();
        updateProgress();
    }

    /**
     * Saves all the values
     */

    private void onSaveButtonPressed() {
        budget.setFoodCost((int) budgetView.foodSlider.getValue());
        budget.setHouseholdCost((int) budgetView.householdSlider.getValue());
        budget.setShoppingCost((int) budgetView.shoppingSlider.getValue());
        budget.setTransportCost((int) budgetView.transportSlider.getValue());
        budget.setSavingsCost((int) budgetView.savingsSlider.getValue());
        budget.setOtherCost((int) budgetView.otherSlider.getValue());
        budget.setIncome(budgetView.enterIncomeTextField.getText());

        updatingMoneyLeft();
        if (selected != -1) {
            addingMenuItem(i);
            i++;
            selected = -1;
        }
        budgetView.setTotalMoney("0");
        budget.notifyBudgetListeners();
        budgetView.showBudgetChartPage();
    }



    /**
     * Sets the maxValues of the sliders according to the income
     */

    private void setMaxOnSlider() {
        int income = Integer.parseInt(budgetView.enterIncomeTextField.getText());
        budgetView.setSliders((int)income);
        updateProgress();
    }

    /**
     * Updates the money left and total sum labels
     */

    private void updatingMoneyLeft() {
        budgetView.setMoneyLeft("0");
        int income = 0;
        income = Integer.parseInt(budgetView.enterIncomeTextField.getText()); //view

        if (budgetView.enterIncomeTextField.equals(null)) {
            income = 0;
        }

        int totalSum = (int) (budgetView.foodSlider.getValue() + budgetView.householdSlider.getValue()
                + budgetView.shoppingSlider.getValue() + budgetView.transportSlider.getValue() + budgetView.otherSlider.getValue() + budgetView.savingsSlider.getValue());

        budgetView.setTotalMoney(String.valueOf(totalSum));

        int difference = income - totalSum;
        if (difference >= 0) {
            budgetView.setMoneyLeft(String.valueOf(difference));
            budgetView.setMoneyLeftToGreen();

        } else {
            budgetView.setMoneyLeft(String.valueOf(difference));
            budgetView.setMoneyLeftToRed();
        }
    }

    private void updateProgress() {
        int income = Integer.parseInt(budgetView.enterIncomeTextField.getText());
        double foodSlider = budgetView.foodSlider.getValue();
        double houseHoldSlider = budgetView.householdSlider.getValue();
        double shoppingSlider = budgetView.shoppingSlider.getValue();
        double transportSlider = budgetView.transportSlider.getValue();
        double otherSlider = budgetView.otherSlider.getValue();
        double savingsSlider = budgetView.savingsSlider.getValue();
        budgetView.setProgressBar(income,foodSlider,houseHoldSlider,shoppingSlider,transportSlider,otherSlider,savingsSlider);
    }


    /**
     * Updates the sliders and textFields
     */

    private void updateAllValues() {
        int foodBudget = budget.getFoodCost();
        int houseHoldBudget = budget.getFoodCost();
        int shoppingBudget = budget.getFoodCost();
        int transportBudget = budget.getFoodCost();
        int otherBudget = budget.getFoodCost();
        int savingBudget = budget.getFoodCost();
        String incomeBudget = budget.getIncome();
        budgetView.updateSlidersWithBudget(foodBudget,houseHoldBudget,shoppingBudget,transportBudget,otherBudget,savingBudget,incomeBudget);
    }

    @Override
    public void update(Budget b) {
        budget = b;
        updateAllValues();
    }


}




