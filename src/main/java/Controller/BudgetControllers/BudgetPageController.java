package Controller.BudgetControllers;

import Controller.Interfaces.ControllerInterface;
import Model.BudgetLogic.Budget;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.BudgetSubject;
import StairwayInterfaces.iBudget;
import View.BudgetView.BudgetView;
import javafx.scene.control.Slider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : viktoriawelzel
 * Responsibility: Updates and handles the BudgetPage
 * Used by: PaneFactory
 * Uses: ControllerInterface, BudgetObserver, iBudget, BudgetSliderController
 */
public class BudgetPageController implements BudgetObserver, ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________

    private final List<iBudget> budgetList = new ArrayList<>();
    private int menuItemNumber = 1;
    private int selected = 0;
    private iBudget budget;
    private final BudgetView budgetView = BudgetView.getInstance();
    private final BudgetSliderController bugetSliderController = new BudgetSliderController();
    private final List<Slider> allSliders = new ArrayList<>() {{
        add(budgetView.foodSlider);
        add(budgetView.householdSlider);
        add(budgetView.shoppingSlider);
        add(budgetView.transportSlider);
        add(budgetView.otherSlider);
        add(budgetView.savingsSlider);
    }};
    private int income = 0;


    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Constructor.
     */
    public BudgetPageController() {
        setAllViewListeners();
        budget = new Budget(0, 0, 0, 0, 0, 0, null);
        BudgetSubject.add(this);
        bugetSliderController.listeningToChanges();
        bugetSliderController.connectingTextFieldsAndSliders();
        updateAllValues();
        disableSlider();
    }

    /**
     * Sets all the controller's view components to listeners.
     */
    @Override
    public void setAllViewListeners() {
        budgetView.saveButton.setOnAction(a -> onSaveButtonPressed());
        budgetView.checkButton.setOnAction(a -> onIncomeTyped());
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
     * Handles the oder of operations to be done.
     */
    private void onIncomeTyped(){
        setIncome();
        checkIfValidIncome();
        updateAllValues();
        updatingMoneyLeft();
        bugetSliderController.setMaxOnSlider(income);
        budgetView.enterIncomeTextField.setText(String.valueOf(income));
    }

    /**
     * Handles color of "Enter Income" textField
     */
    private void setIncome() {
        try{
            income = Integer.parseInt(budgetView.enterIncomeTextField.getText());
            budgetView.setIncomeToGrey();
        }catch (Exception e){
            budgetView.setIncomeToRed();
        }

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
     * Handles selection of the ComboBox for the previous budgets.
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
        bugetSliderController.setMaxOnSlider(income);
        bugetSliderController.updateProgress();
    }

    /**
     * Saves all the values.
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
     * Updates the money left and total sum labels.
     */
    private void updatingMoneyLeft() {
        budgetView.setMoneyLeft("0");


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
     * Handles the enabling of the sliders.
     */
    private void enableSlider() {
        for (final Slider slider:allSliders
        ) {
            slider.setDisable(false);
        }
    }

    /**
     * Handles the disabling of the sliders.
     */
    private void disableSlider(){
        for (final Slider slider:allSliders
        ) {
            slider.setDisable(true);
        }
    }

    /**
     * Checks if the income is valid.
     */
    public void checkIfValidIncome() {
        if ("".equals(budgetView.enterIncomeTextField.getText())){
            income=0;
        }
        if (income!=0) {
            enableSlider();
        }else {
           disableSlider();
        }
    }

    /**
     * Updates the sliders and textFields.
     */
    private void updateAllValues() {
        final int foodBudget = budget.getFoodCost();
        final int houseHoldBudget = budget.getFoodCost();
        final int shoppingBudget = budget.getFoodCost();
        final int transportBudget = budget.getFoodCost();
        final int otherBudget = budget.getFoodCost();
        final int savingBudget = budget.getFoodCost();
        final String incomeBudget = budget.getIncome();
        budgetView.updateSlidersWithBudget(foodBudget, houseHoldBudget, shoppingBudget, transportBudget, otherBudget, savingBudget, incomeBudget);
    }

    @Override
    public void update(final iBudget budget2) {
        budget = budget2;
        updateAllValues();
    }


}





