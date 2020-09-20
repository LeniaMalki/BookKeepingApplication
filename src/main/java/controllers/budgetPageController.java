package controllers;

import Model.Budget;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class budgetPageController implements ChildPane {

    mainController parent;
    @Override
    public void initPane(mainController parent) {
        this.parent=parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());

// TODO -- when writing a value into the textfield the slider showed adjust accordingly
        //TODO -- values on slider not that specfic round to 10/100

        ChangeListener<Number> changeListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {
                foodAmountLabel.setText(new Integer((int) foodSlider.getValue()) + " kr");
                householdAmountLabel.setText(new Integer((int) householdSlider.getValue()) + " kr");
                shoppingAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                transportAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                otherAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                savingsAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");

                //transportTextField.setText(new Integer((int) transportSlider.getValue()) + " kr");
                String typed = transportTextField.getText();
                int value = Integer.parseInt(typed);
                foodSlider.setValue(value);

                System.out.println("R,G,B = " + foodSlider.getValue() + "," + householdSlider.getValue() + "," + shoppingSlider.getValue());
            }
        };
        //

      /*  int total = (int) (foodSlider.getValue() + householdSlider.getValue() + shoppingSlider.getValue()
                + transportSlider.getValue() + otherSlider.getValue() + savingsSlider.getValue());

        if (total == enterIncomeTextField.getText()){
            foodSlider.blockIncrementProperty(foodSlider.getValue());

        }*/



        foodSlider.valueProperty().addListener(changeListener);
        householdSlider.valueProperty().addListener(changeListener);
        shoppingSlider.valueProperty().addListener(changeListener);
        transportSlider.valueProperty().addListener(changeListener);
        otherSlider.valueProperty().addListener(changeListener);
        savingsSlider.valueProperty().addListener(changeListener);

        //foodSlider.setStyle("-fx-base: #F66A80");
        householdSlider.setStyle("-fx-base: #F66A80");
        shoppingSlider.setStyle("-fx-base: #F66A80");
        transportSlider.setStyle("-fx-base: #F66A80");
        otherSlider.setStyle("-fx-base: #F66A80");
        savingsSlider.setStyle("-fx-base: #F66A80");

        foodSlider.setStyle("-fx-control-inner-background: #F66A80");


        foodAmountLabel.setText("0 kr");
        householdAmountLabel.setText("0 kr");
        shoppingAmountLabel.setText("0 kr");
        transportAmountLabel.setText("0 kr");
        otherAmountLabel.setText("0 kr");
        savingsAmountLabel.setText("0 kr");

    }

    private void onSaveButtonPressed(){
        //budget.setFood(foodTextField.getText);

    }

    @FXML
    private Label foodLabel;

    @FXML
    private Label householdLabel;

    @FXML
    private Label shoppingLabel;

    @FXML
    private Label transportLabel;

    @FXML
    private Label otherLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private Label foodAmountLabel;

    @FXML
    private Label householdAmountLabel;

    @FXML
    private Label shoppingAmountLabel;

    @FXML
    private Label transportAmountLabel;

    @FXML
    private Label otherAmountLabel;

    @FXML
    private Label savingsAmountLabel;

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
    private Button saveButton;

    @FXML
    private Button enterIncomeButton;

    @FXML
    private MenuButton previousBudgetButton;

    @FXML
    private CheckMenuItem checkMenuItem1;

    @FXML
    private CheckMenuItem checkMenuItem2;

    @FXML
    private AnchorPane headerAnchorPane;

    @FXML
    private TextField enterIncomeTextField;

    @FXML
    private TextField transportTextField;


}
