package controllers;

import Model.Budget;
import com.sun.javafx.scene.control.IntegerField;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;



import javafx.beans.property.*;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

import javafx.util.StringConverter;
import javafx.beans.property.IntegerProperty;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.scene.layout.StackPane;





public class budgetPageController implements ChildPane {

    mainController parent;
    @Override
    public void initPane(mainController parent) {
        this.parent=parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());

// TODO -- when writing a value into the textfield the slider showed adjust accordingly
        //TODO -- values on slider not that specfic round to 10/100

        //transportAmountLabel.setText(String.valueOf(Math.round(Float.parseFloat(transportSlider.getValue() + ""))));

        ChangeListener<Number> changeListener = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number oldValue, Number newValue) {

                foodProgressBar.setProgress(foodSlider.getValue() / 100);
                householdProgressBar.setProgress(householdSlider.getValue() / 100);
                shoppingProgressBar.setProgress(shoppingSlider.getValue() / 100);
                transportProgressBar.setProgress(transportSlider.getValue() / 100);
                otherProgressBar.setProgress(otherSlider.getValue() / 100);
                savingsProgressBar.setProgress(savingsSlider.getValue() / 100);


                /*foodAmountLabel.setText(new Integer((int) foodSlider.getValue()) + " kr");
                householdAmountLabel.setText(new Integer((int) householdSlider.getValue()) + " kr");
                shoppingAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                transportAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                otherAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                savingsAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");*/

                //transportTextField.setText(new Integer((int) transportSlider.getValue()) + " kr");
                /*String typed = transportTextField.getText();
                int value = Integer.parseInt(typed);
                foodSlider.setValue(value);*/

                System.out.println("R,G,B = " + foodSlider.getValue() + "," + householdSlider.getValue() + "," + shoppingSlider.getValue());
            }
        };


     /*   foodSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                foodProgressBar.setProgress(new_val.doubleValue() / 100);
            }
        });*/

        foodProgressBar.setLayoutX(foodSlider.getLayoutX());
        foodProgressBar.setLayoutY(foodSlider.getLayoutY());
        householdProgressBar.setLayoutX(householdSlider.getLayoutX());
        householdProgressBar.setLayoutY(householdSlider.getLayoutY());
        shoppingProgressBar.setLayoutX(shoppingSlider.getLayoutX());
        shoppingProgressBar.setLayoutY(shoppingSlider.getLayoutY());
        transportProgressBar.setLayoutX(transportSlider.getLayoutX());
        transportProgressBar.setLayoutY(transportSlider.getLayoutY());
        otherProgressBar.setLayoutX(otherSlider.getLayoutX());
        otherProgressBar.setLayoutY(otherSlider.getLayoutY());
        savingsProgressBar.setLayoutX(savingsSlider.getLayoutX());
        savingsProgressBar.setLayoutY(savingsSlider.getLayoutY());


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

        foodTextField.setText("0");
        householdTextField.setText("0");
        shoppingTextField.setText("0");
        transportTextField.setText("0");
        otherTextField.setText("0");
        savingsTextField.setText("0");



        



        transportTextField.textProperty().bindBidirectional(transportSlider.valueProperty(), new NumberStringConverter()
        {
            public String toString(int t)
            {
                int value = (int) Math.floor(t);
                return String.valueOf(value);
            }

            @Override
            public Integer fromString(String string)
            {
                return Integer.parseInt(string);
            }

        });

    }

    @FXML
    private void bindShoppingText() {
        double x = Double.parseDouble(transportTextField.getText());
        transportSlider.setValue(x);
    }

    @FXML
    private void bindShoppingSlider() {
        String value = Double.toString(transportSlider.getValue()).format("%.2f", transportSlider.getValue()); //.format("%.2f", transportSlider.getValue()
        transportTextField.setText(value); //transportSlider.valueProperty()); //new StringConverter<Number>()
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

    @FXML
    private TextField foodTextField;

    @FXML
    private TextField householdTextField;

    @FXML
    private TextField shoppingTextField;

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


}



/*
        Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");

        UnaryOperator<TextFormatter.Change> filter = c -> {
            String text = c.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return c ;
            } else {
                return null ;
            }
        };
        StringConverter<Double> converter = new StringConverter<Double>() {

            @Override
            public Double fromString(String s) {
                if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
                    return 0.0 ;
                } else {
                    return Double.valueOf(s);
                }
            }


            @Override
            public String toString(Double d) {
                return d.toString();
            }
        };

        TextFormatter<Double> textFormatter = new TextFormatter<>(converter, 0.0, filter);
        transportTextField.setTextFormatter(textFormatter);*/










//

      /*  int total = (int) (foodSlider.getValue() + householdSlider.getValue() + shoppingSlider.getValue()
                + transportSlider.getValue() + otherSlider.getValue() + savingsSlider.getValue());

        if (total == enterIncomeTextField.getText()){
            foodSlider.blockIncrementProperty(foodSlider.getValue());

        }*/




    /*    foodSlider.valueProperty().addListener(changeListener);
        householdSlider.valueProperty().addListener(changeListener);
        shoppingSlider.valueProperty().addListener(changeListener);
        transportSlider.valueProperty().addListener(changeListener);
        otherSlider.valueProperty().addListener(changeListener);
        savingsSlider.valueProperty().addListener(changeListener);*/

//foodSlider.setStyle("-fx-base: #F66A80");
       /* householdSlider.setStyle("-fx-base: #F66A80");
        shoppingSlider.setStyle("-fx-base: #F66A80");
        transportSlider.setStyle("-fx-base: #F66A80");
        otherSlider.setStyle("-fx-base: #F66A80");
        savingsSlider.setStyle("-fx-base: #F66A80");
*/
//foodSlider.setStyle("-fx-base: #F66A80");
//foodSlider.setStyle("-fx-control-inner-background: null);

        /*foodSlider.setStyle("-fx-control-inner-background: null");
        foodProgressBar.setStyle("-fx-accent: #F66A80");*/


//foodSlider.setStyle("-fx-background-color: linear-gradient(to right, #2D819D 20%, #969696 20%)");

//-fx-background-color: linear-gradient(to right, #2D819D 20%, #969696 20%)

/*z
    @FXML
    private void bindShoppingSlider() {
        String value = Double.toString(transportSlider.getValue()).format("%.2f", transportSlider.getValue()); //.format("%.2f", transportSlider.getValue()
        transportTextField.setText(value); //transportSlider.valueProperty()); //new StringConverter<Number>()*/

    /* {

            @Override
            public String toString(Number t)
            {
                return t.toString();
            }

            @Override
            public Number fromString(String string)
            {
                return Double.parseDouble(string);
            }


        });*/
    
