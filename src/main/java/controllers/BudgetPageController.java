package controllers;

import Model.Interfaces.iPane;
import Model.Budget;
import com.sun.javafx.scene.control.IntegerField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class BudgetPageController implements iPane {
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.util.converter.NumberStringConverter;

import java.io.IOException;


public class budgetPageController implements ChildPane {

    MainController parent;
    mainController parent;
    Budget budget;

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());


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

                foodSlider.setValue(newValue.intValue());


                foodProgressBar.setProgress(foodSlider.getValue() / 100);
                householdProgressBar.setProgress(householdSlider.getValue() / 100);
                shoppingProgressBar.setProgress(shoppingSlider.getValue() / 100);
                transportProgressBar.setProgress(transportSlider.getValue() / 100);
                otherProgressBar.setProgress(otherSlider.getValue() / 100);
                savingsProgressBar.setProgress(savingsSlider.getValue() / 100);
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


//TODO-- fix this method; probably have to launch(arg) or something

    private void addingMenuItem() {
        int i = 1;
        RadioMenuItem radioMenuItem = new RadioMenuItem("Budget" + i);
        ToggleGroup toggleGroup = new ToggleGroup();
        radioMenuItem.setToggleGroup(toggleGroup);
        radioMenuItem.setSelected(true);
        previousBudgetButton.getItems().add(radioMenuItem);
        i++;
    }


    @FXML
    private Label foodLabel;
    private void onSaveButtonPressed(ActionEvent event) throws IOException {
        budget.setFoodCost((int) foodSlider.getValue());
        budget.setHouseholdCost((int) householdSlider.getValue());
        budget.setShoppingCost((int) shoppingSlider.getValue());
        budget.setTransportCost((int) transportSlider.getValue());
        budget.setSavingsCost((int) savingsSlider.getValue());
        budget.setOtherCost((int) otherSlider.getValue());


    }

    @FXML
    private Label householdLabel;
    private void canDrag(ActionEvent event) {
        int income = 150;
        int currentIncome = 0;
        sumOfAllSliders(foodSlider, income, currentIncome);
        sumOfAllSliders(householdSlider, income, currentIncome);
        sumOfAllSliders(transportSlider, income, currentIncome);
        sumOfAllSliders(shoppingSlider, income, currentIncome);
        sumOfAllSliders(otherSlider, income, currentIncome);
        sumOfAllSliders(savingsSlider, income, currentIncome);
        System.out.println(currentIncome);

    }


    private int sumOfAllSliders(Slider slider, int maxTotal, int currentTotal) {
        if (slider.getValue() > (maxTotal - currentTotal)) {
            slider.setValue(maxTotal - currentTotal);

            currentTotal = (int) (foodSlider.getValue() + householdSlider.getValue()
                    + shoppingSlider.getValue() + transportSlider.getValue() + otherSlider.getValue() + savingsSlider.getValue());
        } else {
            currentTotal = (int) (foodSlider.getValue() + householdSlider.getValue()
                    + shoppingSlider.getValue() + transportSlider.getValue() + otherSlider.getValue() + savingsSlider.getValue());
        }
        return currentTotal;
    }


    @FXML
    private Label shoppingLabel;
    private Slider foodSlider;

    @FXML
    private Label transportLabel;
    private Slider householdSlider;

    @FXML
    private Label otherLabel;
    private Slider shoppingSlider;

    @FXML
    private Label savingsLabel;
    private Slider transportSlider;

    @FXML
    private Label foodAmountLabel;
    private Slider otherSlider;

    @FXML
    private Label householdAmountLabel;
    private Slider savingsSlider;

    @FXML
    private Label shoppingAmountLabel;
    private Button saveButton;

    @FXML
    private MenuButton previousBudgetButton;

    @FXML
    private Label transportAmountLabel;
    private CheckMenuItem checkMenuItem1;

    @FXML
    private Label otherAmountLabel;
    private CheckMenuItem checkMenuItem2;

    @FXML
    private Label savingsAmountLabel;
    private AnchorPane headerAnchorPane;

    @FXML
    private Slider foodSlider;
    private TextField enterIncomeTextField;

    @FXML
    private Slider householdSlider;
    private TextField transportTextField;

    @FXML
    private Slider shoppingSlider;
    private TextField foodTextField;

    @FXML
    private Slider transportSlider;
    private TextField householdTextField;

    @FXML
    private Slider otherSlider;
    private TextField shoppingTextField;

    @FXML
    private Slider savingsSlider;
    private TextField otherTextField;

    @FXML
    private Button saveButton;
    private TextField savingsTextField;

    @FXML
    private Button enterIncomeButton;
    private ProgressBar foodProgressBar;

    @FXML
    private MenuButton previousBudgetButton;
    private ProgressBar householdProgressBar;

    @FXML
    private CheckMenuItem checkMenuItem1;
    private ProgressBar shoppingProgressBar;

    @FXML
    private CheckMenuItem checkMenuItem2;
    private ProgressBar transportProgressBar;

    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
    private ProgressBar otherProgressBar;

    @FXML
    private ProgressBar savingsProgressBar;
}




