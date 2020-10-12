package Controller.BudgetControllers;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.BudgetLogic.Budget;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class BudgetPageController implements iPane {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    Budget budget = new Budget(0,0,0,0,0,0,"0");
    private ArrayList<Budget> budgetList = new ArrayList<Budget>();
   // private int [] previousBudgets = {32000, 5000, 3000, 3500, 1500, 2000, 17000};
    int i = 1;
    int selected = 0;
    int prevSelected = -1;

    //__________________________________________________ FXML __________________________________________________________

    @FXML
    private MenuButton previousBudgetButton;
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
     * Initialisation method with a change listener
     *
     * @param parent the main controller
     */

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());

       // foodSlider.setValue(0);
       // householdSlider.setValue(0);
      //  shoppingSlider.setValue(0);
      //  transportSlider.setValue(0);
      //  otherSlider.setValue(0);
      //  savingsSlider.setValue(0);
     //   enterIncomeTextField.setText("0");


        //transportAmountLabel.setText(String.valueOf(Math.round(Float.parseFloat(transportSlider.getValue() + ""))));

        ChangeListener<Number> changeListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {

                /*foodSlider.setValue(newValue.intValue());
                householdSlider.setValue(newValue.intValue());
                shoppingSlider.setValue(newValue.intValue());
                transportSlider.setValue(newValue.intValue());
                otherSlider.setValue(newValue.intValue());
                savingsSlider.setValue(newValue.intValue());*/

                int income = 0;
                selected = 0;
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

        transportTextField.textProperty().bindBidirectional(transportSlider.valueProperty(), new NumberStringConverter());
        foodTextField.textProperty().bindBidirectional(foodSlider.valueProperty(), new NumberStringConverter());
        householdTextField.textProperty().bindBidirectional(householdSlider.valueProperty(), new NumberStringConverter());
        shoppingTextField.textProperty().bindBidirectional(shoppingSlider.valueProperty(), new NumberStringConverter());
        otherTextField.textProperty().bindBidirectional(otherSlider.valueProperty(), new NumberStringConverter());
        savingsTextField.textProperty().bindBidirectional(savingsSlider.valueProperty(), new NumberStringConverter());
    }


//TODO-- FIX THIS METHOD -----------------------------------------------------------------------------------

    /**
     * Adds a new budget to the list
     * @param i the current budgetnumber
     */
    private void addingMenuItem(int i) {
        /*RadioMenuItem radioMenuItem = new RadioMenuItem("Budget" + i);
        ToggleGroup toggleGroup = new ToggleGroup();
        radioMenuItem.setToggleGroup(toggleGroup);
        radioMenuItem.setSelected(true);
        previousBudgetButton.getItems().add(radioMenuItem);
        i++;*/

        previousBudgetComboBox.getItems().add("Budget " + i);
        budgetList.add(new Budget((int) foodSlider.getValue(),(int) householdSlider.getValue(),(int) shoppingSlider.getValue(),(int) transportSlider.getValue(),(int) savingsSlider.getValue(),(int) otherSlider.getValue(), enterIncomeTextField.getText()));
         
    }

    /**
     * Handles selection of the ComboBox for the previous budgets
     */
    @FXML
    private void comboSelector() {

        // selected index in ComboBox
        selected = previousBudgetComboBox.getSelectionModel().getSelectedIndex();

        // set all sliders and fields to right value
        enterIncomeTextField.setText(budgetList.get(selected).getIncome());
        String i = this.budgetList.get(selected).getIncome();
        int inc = Integer.parseInt(i);

        foodSlider.setValue(budgetList.get(selected).getFoodCost());
        householdSlider.setValue(budgetList.get(selected).getHouseholdCost());
        shoppingSlider.setValue(budgetList.get(selected).getShoppingCost());
        savingsSlider.setValue(budgetList.get(selected).getSavingsCost());
        transportSlider.setValue(budgetList.get(selected).getTransportCost());
        otherSlider.setValue(budgetList.get(selected).getOtherCost());
        
        
    }

   private void updateComboItems() {
        budgetList.remove(prevSelected);
        budgetList.add(prevSelected, new Budget((int) foodSlider.getValue(),(int) householdSlider.getValue(),(int) shoppingSlider.getValue(),(int) transportSlider.getValue(),(int) savingsSlider.getValue(),(int) otherSlider.getValue(), enterIncomeTextField.getText()));
        prevSelected = -1;


            //  prevSelected = selected;
    }       //  selected = -1;
    

    /**
     * Saves all the values
     *
     * @param event if something is pressed an ActionEvent is fired and tells the system what happened
     */

    @FXML
    private void onSaveButtonPressed(ActionEvent event) throws IOException {
        budget.setFoodCost((int) foodSlider.getValue());
        budget.setHouseholdCost((int) householdSlider.getValue());
        budget.setShoppingCost((int) shoppingSlider.getValue());
        budget.setTransportCost((int) transportSlider.getValue());
        budget.setSavingsCost((int) savingsSlider.getValue());
        budget.setOtherCost((int) otherSlider.getValue());
        budget.setIncome(enterIncomeTextField.getText());
        updatingMoneyLeft();

        if(selected != -1) {
            addingMenuItem(i);
            i++;
            selected = -1;
        }
        //else {
           // updateComboItems();
       // }

        
    }

    /**
     * Sets the maxValues of the sliders according to the income
     */

    @FXML
    private void setMaxOnSlider(){
       // int income = 0;
        int income = Integer.parseInt(enterIncomeTextField.getText());

        foodSlider.setMax(income);
        householdSlider.setMax(income);
        shoppingSlider.setMax(income);
        transportSlider.setMax(income);
        savingsSlider.setMax(income);
        otherSlider.setMax(income);
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

   /* private void previousBudgetPressed(){*/
   /*         int i = 0;*/
   /*         enterIncomeTextField.setText(String.valueOf(previousBudgets[i]));*/
   /*         i++;*/
   /*         foodSlider.setValue(previousBudgets[i]);*/
   /*         i++;*/
   /*         householdSlider.setValue(previousBudgets[i]);*/
   /*         i++;*/
   /*         shoppingSlider.setValue(previousBudgets[i]);*/
   /*         i++;*/
   /*         transportSlider.setValue(previousBudgets[i]);*/
   /*         i++;*/
   /*         otherSlider.setValue(previousBudgets[i]);*/
   /*         i++;*/
   /*         savingsSlider.setValue(previousBudgets[i]);*/

  //  }


}




