package Controller.BudgetControllers;

import Controller.Interfaces.ControllerInterface;
import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.Interfaces.BudgetObserver;
import View.BudgetView.BudgetView;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the budget page
 *
 * @author viktoriawelzel
 */
public class BudgetPageController implements BudgetObserver, ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________

    private final List<Budget> budgetList = new ArrayList<>();
    private int menuItemNumber = 1;
    private int selected = 0;
    private Budget budget;
    private final BudgetView budgetView = BudgetView.getInstance();
    private final BugetSliderController bugetSliderController = new BugetSliderController();

    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Controller of Budget page.
     */
    public BudgetPageController() {
        setAllViewListeners();
        budget = new Budget(0, 0, 0, 0, 0, 0, null);
        BudgetSubject.add(this);
        bugetSliderController.listeningToChanges();
        bugetSliderController.connectingTextFieldsAndSliders();
        updateAllValues();
    }

    @Override
    public void setAllViewListeners() {
        budgetView.saveButton.setOnAction(a -> onSaveButtonPressed());
        budgetView.enterIncomeTextField.setOnAction(a -> updatingMoneyLeft());
        budgetView.enterIncomeTextField.setOnMouseExited(a -> bugetSliderController.setMaxOnSlider());
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
     * Adds a new budget to the list
     *
     * @param menuItemNumber the current budgetnumber
     */

    private void addingMenuItem(final int menuItemNumber) {
        budgetView.previousBudgetComboBox.getItems().add("Budget " + menuItemNumber);
        budgetList.add(new Budget((int) budgetView.foodSlider.getValue(), (int) budgetView.householdSlider.getValue(),
                (int) budgetView.shoppingSlider.getValue(), (int) budgetView.transportSlider.getValue(), (int) budgetView.savingsSlider.getValue(),
                (int) budgetView.otherSlider.getValue(), budgetView.enterIncomeTextField.getText()));
    }

    /**
     * Handles selection of the ComboBox for the previous budgets
     */

    private void comboSelector() {
        selected = budgetView.previousBudgetComboBox.getSelectionModel().getSelectedIndex();
        budget.setIncome(budgetList.get(selected).getIncome());
        budget.setFoodCost(budgetList.get(selected).getFoodCost());
        budget.setHouseholdCost(budgetList.get(selected).getHouseholdCost());
        budget.setShoppingCost(budgetList.get(selected).getShoppingCost());
        budget.setTransportCost(budgetList.get(selected).getTransportCost());
        budget.setSavingsCost(budgetList.get(selected).getSavingsCost());
        budget.setOtherCost(budgetList.get(selected).getOtherCost());
        budget.notifyBudgetListeners();
        bugetSliderController.setMaxOnSlider();
        bugetSliderController.updateProgress();
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
            addingMenuItem(menuItemNumber);
            menuItemNumber++;
            selected = -1;
        }
        budgetView.setTotalMoney("0");
        budget.notifyBudgetListeners();
        budgetView.showBudgetChartPage();
    }


    /**
     * Updates the money left and total sum labels
     */

    private void updatingMoneyLeft() {
        budgetView.setMoneyLeft("0");
        int income;
        income = Integer.parseInt(budgetView.enterIncomeTextField.getText());

        /*if (budgetView.enterIncomeTextField.equals(null)) {
            income = 0;
        } //används aldrig så kan tas bort*/

        final int totalSum = (int) (budgetView.foodSlider.getValue() + budgetView.householdSlider.getValue()
                + budgetView.shoppingSlider.getValue() + budgetView.transportSlider.getValue() + budgetView.otherSlider.getValue() + budgetView.savingsSlider.getValue());

        budgetView.setTotalMoney(String.valueOf(totalSum));

        final int difference = income - totalSum;
        if (difference >= 0) {
            budgetView.setMoneyLeft(String.valueOf(difference));
            budgetView.setMoneyLeftToGreen();

        } else {
            budgetView.setMoneyLeft(String.valueOf(difference));
            budgetView.setMoneyLeftToRed();
        }
    }

    /**
     * Updates the sliders and textFields
     */

    private void updateAllValues() {
        final int foodBudget = budget.getFoodCost();
        final int houseHoldBudget = budget.getFoodCost();
        final int shoppingBudget = budget.getFoodCost();
        final int transportBudget = budget.getFoodCost();
        final int otherBudget = budget.getFoodCost();
        final int savingBudget = budget.getFoodCost();
        final String incomeBudget = budget.getIncome();
        budgetView.updateSlidersWithBudget(foodBudget,houseHoldBudget,shoppingBudget,transportBudget,otherBudget,savingBudget,incomeBudget);
    }

    @Override
    public void update(final Budget budget2) {
        budget = budget2;
        updateAllValues();
    }


}





