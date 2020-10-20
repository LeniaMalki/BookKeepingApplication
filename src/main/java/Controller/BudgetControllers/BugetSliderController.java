package Controller.BudgetControllers;

import View.BudgetView.BudgetView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.converter.NumberStringConverter;

/**
 * Controller for the sliders and progress bars of the Budget Page.
 *
 * @author viktoriawelzel
 */

public class BugetSliderController {

    private final BudgetView budgetView = BudgetView.getInstance();
    public int selected = 0;

    /**
     * Listener that changes the progressbar according to the value of the slider.
     */

    protected void listeningToChanges() {
        final ChangeListener<Number> changeListener = new ChangeListener<Number>() {
            @Override
            public void changed(final ObservableValue<? extends Number> observable,
                                final Number oldValue, final Number newValue) {
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
     * Binds the sliders and the textFields.
     */

    protected void connectingTextFieldsAndSliders() {
        budgetView.foodTextField.textProperty().bindBidirectional(budgetView.foodSlider.valueProperty(), new NumberStringConverter());
        budgetView.householdTextField.textProperty().bindBidirectional(budgetView.householdSlider.valueProperty(), new NumberStringConverter());
        budgetView.shoppingTextField.textProperty().bindBidirectional(budgetView.shoppingSlider.valueProperty(), new NumberStringConverter());
        budgetView.transportTextField.textProperty().bindBidirectional(budgetView.transportSlider.valueProperty(), new NumberStringConverter());
        budgetView.otherTextField.textProperty().bindBidirectional(budgetView.otherSlider.valueProperty(), new NumberStringConverter());
        budgetView.savingsTextField.textProperty().bindBidirectional(budgetView.savingsSlider.valueProperty(), new NumberStringConverter());
    }

    /**
     * Sets the maxValues of the sliders according to the income.
     */

    protected void setMaxOnSlider() {
        final int income = Integer.parseInt(budgetView.enterIncomeTextField.getText());
        budgetView.setSliders((int)income);
        updateProgress();
    }

    /**
     * Updates the progress bars.
     */

    protected void updateProgress() {
        final int income = Integer.parseInt(budgetView.enterIncomeTextField.getText());
        final double foodSlider = budgetView.foodSlider.getValue();
        final double houseHoldSlider = budgetView.householdSlider.getValue();
        final double shoppingSlider = budgetView.shoppingSlider.getValue();
        final double transportSlider = budgetView.transportSlider.getValue();
        final double otherSlider = budgetView.otherSlider.getValue();
        final double savingsSlider = budgetView.savingsSlider.getValue();
        budgetView.setProgressBar(income,foodSlider,houseHoldSlider,shoppingSlider,transportSlider,otherSlider,savingsSlider);
    }

}

