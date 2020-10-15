package Controller.BudgetControllers;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.Interfaces.BudgetObserver;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.util.converter.NumberStringConverter;

import java.util.ArrayList;


public class BudgetPageController implements iPane, BudgetObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    private ArrayList<Budget> budgetList = new ArrayList<Budget>();
    int i = 1;
    int selected = 0;
    //int prevSelected = -1;
    Budget budget;
    //__________________________________________________ FXML __________________________________________________________

    @FXML
    private TextField enterIncomeTextField;
    @FXML
    private Button saveButton;
    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private ComboBox previousBudgetComboBox;
    @FXML
    private Label moneyLeft;
    @FXML
    private Label totalMoney;

    @FXML
    private Slider foodSlider;
    @FXML
    private Slider householdSlider;
    @FXML
    private Slider shoppingSlider;
    @FXML
    private Slider transportSlider;
    @FXML
    private Slider otherSlider;
    @FXML
    private Slider savingsSlider;

    @FXML
    private TextField foodTextField;
    @FXML
    private TextField householdTextField;
    @FXML
    private TextField shoppingTextField;
    @FXML
    private TextField transportTextField;
    @FXML
    private TextField otherTextField;
    @FXML
    private TextField savingsTextField;

    @FXML
    private ProgressBar foodProgressBar;
    @FXML
    private ProgressBar householdProgressBar;
    @FXML
    private ProgressBar shoppingProgressBar;
    @FXML
    private ProgressBar transportProgressBar;
    @FXML
    private ProgressBar otherProgressBar;
    @FXML
    private ProgressBar savingsProgressBar;

    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Initializes the pane when the program starts also adds the header with a change listner
     *
     * @param parent the main controller
     */

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        BudgetSubject.add(this);
        listeningToChanges();
        connectingTextFieldsAndSliders();
        stylingSlidersAndProgressBars();
        budget = new Budget(0, 0, 0, 0, 0, 0, null);
        updateAllValues();
    }

    /**
     * Listener that changes the progressbar according to the value of the slider
     */

    private void listeningToChanges(){
        ChangeListener<Number> changeListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {

                selected = 0;
                int income = 0;
                income = Integer.parseInt(enterIncomeTextField.getText());
                    foodProgressBar.setProgress(foodSlider.getValue() / income);
                    householdProgressBar.setProgress(householdSlider.getValue() / income);
                    shoppingProgressBar.setProgress(shoppingSlider.getValue() / income);
                    transportProgressBar.setProgress(transportSlider.getValue() / income);
                    otherProgressBar.setProgress(otherSlider.getValue() / income);
                    savingsProgressBar.setProgress(savingsSlider.getValue() / income);
                }
        };

        foodSlider.valueProperty().addListener(changeListener);
        householdSlider.valueProperty().addListener(changeListener);
        shoppingSlider.valueProperty().addListener(changeListener);
        transportSlider.valueProperty().addListener(changeListener);
        otherSlider.valueProperty().addListener(changeListener);
        savingsSlider.valueProperty().addListener(changeListener);
    }

    /**
     * Binds the sliders and the textFields
     */

    private void connectingTextFieldsAndSliders(){
        foodTextField.textProperty().bindBidirectional(foodSlider.valueProperty(), new NumberStringConverter());
        householdTextField.textProperty().bindBidirectional(householdSlider.valueProperty(), new NumberStringConverter());
        shoppingTextField.textProperty().bindBidirectional(shoppingSlider.valueProperty(), new NumberStringConverter());
        transportTextField.textProperty().bindBidirectional(transportSlider.valueProperty(), new NumberStringConverter());
        otherTextField.textProperty().bindBidirectional(otherSlider.valueProperty(), new NumberStringConverter());
        savingsTextField.textProperty().bindBidirectional(savingsSlider.valueProperty(), new NumberStringConverter());
    }

    /**
     * Sets style of sliders and progress bars
     */

    private void stylingSlidersAndProgressBars(){
        foodSlider.setStyle("-fx-control-inner-background: null");
        foodProgressBar.setStyle("-fx-accent: #F66A80");
        householdSlider.setStyle("-fx-control-inner-background: null");
        householdProgressBar.setStyle("-fx-accent: #F66A80");
        shoppingSlider.setStyle("-fx-control-inner-background: null");
        shoppingProgressBar.setStyle("-fx-accent: #F66A80");
        transportSlider.setStyle("-fx-control-inner-background: null");
        transportProgressBar.setStyle("-fx-accent: #F66A80");
        otherSlider.setStyle("-fx-control-inner-background: null");
        otherProgressBar.setStyle("-fx-accent: #F66A80");
        savingsSlider.setStyle("-fx-control-inner-background: null");
        savingsProgressBar.setStyle("-fx-accent: #F66A80");
    }

    /**
     * Adds a new budget to the list
     * @param i the current budgetnumber
     */
    private void addingMenuItem(int i) {
        previousBudgetComboBox.getItems().add("Budget " + i);
        budgetList.add(new Budget((int) foodSlider.getValue(),(int) householdSlider.getValue(),
                (int) shoppingSlider.getValue(),(int) transportSlider.getValue(),(int) savingsSlider.getValue(),
                (int) otherSlider.getValue(), enterIncomeTextField.getText()));
    }

    /**
     * Handles selection of the ComboBox for the previous budgets
     */

    @FXML
    private void comboSelector() {
        // selected index in ComboBox
        selected = previousBudgetComboBox.getSelectionModel().getSelectedIndex();

        budget.setIncome((budgetList.get(selected).getIncome()));
        //String i = this.budgetList.get(selected).getIncome();
        //int inc = Integer.parseInt(i);

        budget.setFoodCost(budgetList.get(selected).getFoodCost());
        budget.setHouseholdCost(budgetList.get(selected).getHouseholdCost());
        budget.setShoppingCost(budgetList.get(selected).getShoppingCost());
        budget.setTransportCost(budgetList.get(selected).getTransportCost());
        budget.setSavingsCost(budgetList.get(selected).getSavingsCost());
        budget.setOtherCost(budgetList.get(selected).getOtherCost());

        budget.notifyBudgetListeners();
        setMaxOnSlider();
        updateProgress();

        //budget.setFoodCost((int) foodSlider.getValue());

        // set all sliders and fields to right value
        /*enterIncomeTextField.setText(budgetList.get(selected).getIncome());
        String i = this.budgetList.get(selected).getIncome();
        int inc = Integer.parseInt(i);

        foodSlider.setValue(budgetList.get(selected).getFoodCost());
        householdSlider.setValue(budgetList.get(selected).getHouseholdCost());
        shoppingSlider.setValue(budgetList.get(selected).getShoppingCost());
        savingsSlider.setValue(budgetList.get(selected).getSavingsCost());
        transportSlider.setValue(budgetList.get(selected).getTransportCost());
        otherSlider.setValue(budgetList.get(selected).getOtherCost());
        budget.setFoodCost((int) foodSlider.getValue());*/
    }

    /**
     * Saves all the values
     */

    @FXML
    private void onSaveButtonPressed(){
        budget.setFoodCost((int) foodSlider.getValue());
        budget.setHouseholdCost((int) householdSlider.getValue());
        budget.setShoppingCost((int) shoppingSlider.getValue());
        budget.setTransportCost((int) transportSlider.getValue());
        budget.setSavingsCost((int) savingsSlider.getValue());
        budget.setOtherCost((int) otherSlider.getValue());
        budget.setIncome(enterIncomeTextField.getText());

        updatingMoneyLeft();
        //budgetList.add(budget);
        if(selected != -1) {
            addingMenuItem(i);
            i++;
            selected = -1;
        }
        budget.notifyBudgetListeners();
        parent.showBudgetCharPage();
    }

    /**
     * Sets the maxValues of the sliders according to the income
     */

    @FXML
    private void setMaxOnSlider(){
        int income = Integer.parseInt(enterIncomeTextField.getText());
            foodSlider.setMax(income);
            householdSlider.setMax(income);
            shoppingSlider.setMax(income);
            transportSlider.setMax(income);
            savingsSlider.setMax(income);
            otherSlider.setMax(income);
        foodProgressBar.setProgress(foodSlider.getValue() / income);
        householdProgressBar.setProgress(householdSlider.getValue() / income);
        shoppingProgressBar.setProgress(shoppingSlider.getValue() / income);
        transportProgressBar.setProgress(transportSlider.getValue() / income);
        otherProgressBar.setProgress(otherSlider.getValue() / income);
        savingsProgressBar.setProgress(savingsSlider.getValue() / income);

    }

    /**
     * Updates the money left and total sum labels
     */

    @FXML
    private void updatingMoneyLeft(){

        moneyLeft.setText("0");

        int income = 0;
        income = Integer.parseInt(enterIncomeTextField.getText());

        if(enterIncomeTextField.equals(null)) {
            income = 0;
        }

        int totalSum = (int) (foodSlider.getValue() + householdSlider.getValue()
                + shoppingSlider.getValue() + transportSlider.getValue() + otherSlider.getValue() + savingsSlider.getValue());

        totalMoney.setText(String.valueOf(totalSum));

        int difference = income - totalSum;
        if(difference >= 0) {
            moneyLeft.setText(String.valueOf(difference));
            moneyLeft.setStyle("-fx-text-fill: green");

        } else {
            moneyLeft.setText(String.valueOf(difference));
            moneyLeft.setStyle("-fx-text-fill: red");
        }
    }

    private void updateProgress(){
        int income = Integer.parseInt(enterIncomeTextField.getText());
        foodProgressBar.setProgress(foodSlider.getValue() / income);
        householdProgressBar.setProgress(householdSlider.getValue() / income);
        shoppingProgressBar.setProgress(shoppingSlider.getValue() / income);
        transportProgressBar.setProgress(transportSlider.getValue() / income);
        otherProgressBar.setProgress(otherSlider.getValue() / income);
        savingsProgressBar.setProgress(savingsSlider.getValue() / income);
    }

    /**
     * Updates the sliders and textFields
     */

    private void updateAllValues(){
        foodSlider.setValue(budget.getFoodCost());
        householdSlider.setValue(budget.getHouseholdCost());
        shoppingSlider.setValue(budget.getShoppingCost());
        transportSlider.setValue(budget.getTransportCost());
        otherSlider.setValue(budget.getOtherCost());
        savingsSlider.setValue(budget.getSavingsCost());
        enterIncomeTextField.setText(budget.getIncome());
        //listeningToChanges();
    }

    @Override
    public void update(Budget b) {
        budget = b;
        updateAllValues();
    }
}




