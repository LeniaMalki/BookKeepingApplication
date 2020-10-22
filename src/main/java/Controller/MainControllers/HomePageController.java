package Controller.MainControllers;

import Controller.Interfaces.RemoveItemObserver;
import Controller.Interfaces.RemoveItemSubject;
import StairwayInterfaces.iBudget;
import StairwayInterfaces.iEntry;
import StairwayInterfaces.iEntryHandler;
import Model.BudgetLogic.Budget;
import Model.Interfaces.BudgetSubject;
import Model.EntryLogic.EntryHandler;
import Model.Interfaces.EntrySubject;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;
import View.EntryView.EntryListItemView;
import View.MainViews.HomeView;

public class HomePageController implements EntryObserver, BudgetObserver, RemoveItemObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    private iBudget budget;
    private final iEntryHandler entryHandler = EntryHandler.getInstance();
    private final HomeView homeView = HomeView.getInstance();


    public HomePageController() {
        BudgetSubject.add(this);
        EntrySubject.add(this);
        budget = new Budget(0, 0, 0, 0, 0, 0, "0");
        updateAllBudgets();
        RemoveItemSubject.add(this);
    }

    //_________________________________________________ METHODS ________________________________________________________


    /**
     * Updates all the labels according to the entries and budgets.
     */
    private void updateAllBudgets() {
        homeView.setTextLabel((int) entryHandler.getFoodAmount() + " kr of " + budget.getFoodCost() + " kr","Food");
        homeView.setTextLabel((int) entryHandler.getHouseholdAmount() + " kr of " + budget.getHouseholdCost() + " kr", "Household");
        homeView.setTextLabel((int) entryHandler.getShoppingAmount() + " kr of " + budget.getShoppingCost() + " kr", "Shopping");
        homeView.setTextLabel((int) entryHandler.getTransportationAmount() + " kr of " + budget.getTransportCost() + " kr", "Transport");
        homeView.setTextLabel((int) entryHandler.getOtherAmount() + " kr of " + budget.getOtherCost() + " kr", "Other");
    }

    /**
     * Updates the progress bars according to the entries.
     */

    private void changeProgress() {
        if (budget != null) {
            entryHandler.updateTotalCategoryValues();
            homeView.setProgressBar( entryHandler.getFoodAmount()/budget.getFoodCost(), "Food");
            homeView.setProgressBar(entryHandler.getHouseholdAmount()/budget.getHouseholdCost(), "Household");
            homeView.setProgressBar( entryHandler.getShoppingAmount()/budget.getShoppingCost(), "Shopping");
            homeView.setProgressBar( entryHandler.getTransportationAmount() / budget.getTransportCost(), "Transport");
            homeView.setProgressBar( entryHandler.getOtherAmount() / budget.getOtherCost(), "Other");
            updateAllBudgets();
        }
    }

    @Override
    public void update(final String category, final String type, final double Value) {
    }

    @Override
    public void update(final iEntry entry) {
        changeProgress();
    }

    @Override
    public void update(final iBudget budget1) {
        budget = budget1;
        updateAllBudgets();
    }


    @Override
    public void update(final iEntry entry, final EntryListItemView controller) {
        entryHandler.getEntries().remove(entry);
        updateAllBudgets();
        changeProgress();
    }
}
