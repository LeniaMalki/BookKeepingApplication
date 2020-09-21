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
                foodAmountLabel.setText(new Integer((int) foodSlider.getValue()) + " kr");
                householdAmountLabel.setText(new Integer((int) householdSlider.getValue()) + " kr");
                shoppingAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                transportAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                otherAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");
                savingsAmountLabel.setText(new Integer((int) shoppingSlider.getValue()) + " kr");

                //transportTextField.setText(new Integer((int) transportSlider.getValue()) + " kr");
                /*String typed = transportTextField.getText();
                int value = Integer.parseInt(typed);
                foodSlider.setValue(value);*/

                System.out.println("R,G,B = " + foodSlider.getValue() + "," + householdSlider.getValue() + "," + shoppingSlider.getValue());
            }
        };


        foodSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                foodProgressBar.setProgress(new_val.doubleValue() / 100);
                foodProgressIndicator.setProgress(new_val.doubleValue() / 100);
            }
        });

        foodProgressBar.setLayoutX(foodSlider.getLayoutX());
        foodProgressBar.setLayoutY(foodSlider.getLayoutY());






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
        transportTextField.setTextFormatter(textFormatter);


*/









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
        householdSlider.setStyle("-fx-base: #F66A80");
        shoppingSlider.setStyle("-fx-base: #F66A80");
        transportSlider.setStyle("-fx-base: #F66A80");
        otherSlider.setStyle("-fx-base: #F66A80");
        savingsSlider.setStyle("-fx-base: #F66A80");

        //foodSlider.setStyle("-fx-base: null");
        //foodSlider.setStyle("-fx-control-inner-background: null);

        foodSlider.setStyle("-fx-control-inner-background: null");

        //foodSlider.setStyle("-fx-background-color: linear-gradient(to right, #2D819D 20%, #969696 20%)");

        //-fx-background-color: linear-gradient(to right, #2D819D 20%, #969696 20%)


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
    private void bindShoppingText() {
        double x = Double.parseDouble(transportTextField.getText());
        transportSlider.setValue(x);
    }

    @FXML
    private void bindShoppingSlider() {
        String value = Double.toString(transportSlider.getValue()).format("%.2f", transportSlider.getValue()); //.format("%.2f", transportSlider.getValue()
        transportTextField.setText(value); //transportSlider.valueProperty()); //new StringConverter<Number>()

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

    @FXML
    private ProgressBar foodProgressBar;

    @FXML
    private ProgressIndicator foodProgressIndicator;

}
