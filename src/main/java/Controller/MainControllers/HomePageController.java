package Controller.MainControllers;

import Interfaces.iBudget;
import Interfaces.iEntry;
import Interfaces.iEntryHandler;
import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.EntryLogic.Entry;
import Service.PaneFactory;
import Model.EntryLogic.EntryHandler;
import Model.EntryLogic.EntrySubject;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;
import View.MainViews.HomeView;
import View.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomePageController implements EntryObserver, BudgetObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    iBudget budget;
    iEntryHandler entryHandler = EntryHandler.getInstance();
    private final HomeView homeView = HomeView.getInstance();



    public HomePageController() {
        BudgetSubject.add(this);
        EntrySubject.add(this);
        budget = new Budget(0, 0, 0, 0, 0, 0, "0");
        updateAllBudgets();
    }

    //_________________________________________________ METHODS ________________________________________________________


    /**
     * Updates all the labels according to the entries and budgets.
     */
    private void updateAllBudgets() {
        homeView.foodLabel.setText((int) entryHandler.getFoodAmount() + " kr of " + budget.getFoodCost() + " kr");
        homeView.householdLabel.setText((int) entryHandler.getHouseholdAmount() + " kr of " + budget.getHouseholdCost() + " kr");
        homeView.shoppingLabel.setText((int) entryHandler.getShoppingAmount() + " kr of " + budget.getShoppingCost() + " kr");
        homeView.transportLabel.setText((int) entryHandler.getTransportationAmount() + " kr of " + budget.getTransportCost() + " kr");
        homeView.otherLabel.setText((int) entryHandler.getOtherAmount() + " kr of " + budget.getOtherCost() + " kr");
    }

    /**
     * Updates the progress bars according to the entries.
     */

    private void changeProgress() {
        if (budget != null) {
            entryHandler.updateTotalCategoryValues();
            homeView.foodBar.setProgress(entryHandler.getFoodAmount() / budget.getFoodCost());
            homeView.householdBar.setProgress(entryHandler.getHouseholdAmount() / budget.getHouseholdCost());
            homeView.shoppingBar.setProgress(entryHandler.getShoppingAmount() / budget.getShoppingCost());
            homeView.transportBar.setProgress(entryHandler.getTransportationAmount() / budget.getTransportCost());
            homeView.otherbar.setProgress(entryHandler.getOtherAmount() / budget.getOtherCost());
            updateAllBudgets();
        }
    }

    @Override
    public void update(String category, String type, double Value) {
    }

    @Override
    public void update(iEntry entry) {
        changeProgress();
    }

    @Override
    public void update(iBudget b) {
        budget = b;
        updateAllBudgets();
    }
}
