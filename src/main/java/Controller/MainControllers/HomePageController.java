package Controller.MainControllers;

import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import Model.EntryLogic.EntrySubject;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;
import View.MainViews.HomeView;

public class HomePageController implements EntryObserver, BudgetObserver {

    private final HomeView homeView = HomeView.getInstance();
    Budget budget;
    EntryHandler entryHandler = EntryHandler.getInstance();


    public HomePageController() {
        BudgetSubject.add(this);
        EntrySubject.add(this);
        budget = new Budget(0, 0, 0, 0, 0, 0, "0");
        updateAllBudgets();
    }

    private void updateAllBudgets() {
        homeView.foodLabel.setText((int) entryHandler.getFoodAmount() + " kr of " + budget.getFoodCost() + " kr");
        homeView.householdLabel.setText((int) entryHandler.getHouseholdAmount() + " kr of " + budget.getHouseholdCost() + " kr");
        homeView.shoppingLabel.setText((int) entryHandler.getShoppingAmount() + " kr of " + budget.getShoppingCost() + " kr");
        homeView.transportLabel.setText((int) entryHandler.getTransportationAmount() + " kr of " + budget.getTransportCost() + " kr");
        homeView.otherLabel.setText((int) entryHandler.getOtherAmount() + " kr of " + budget.getOtherCost() + " kr");
    }

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
    public void update(Entry entry) {
        changeProgress();
    }

    @Override
    public void update(Budget b) {
        budget = b;
        updateAllBudgets();
    }
}
