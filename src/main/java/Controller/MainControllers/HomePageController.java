package Controller.MainControllers;

import StairwayInterfaces.iBudget;
import StairwayInterfaces.iEntry;
import StairwayInterfaces.iEntryHandler;
import Model.BudgetLogic.Budget;
import Model.Interfaces.BudgetSubject;
import Model.EntryLogic.EntryHandler;
import Model.Interfaces.EntrySubject;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;
import View.MainViews.HomeView;

public class HomePageController implements EntryObserver, BudgetObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    private iBudget budget;
    private final iEntryHandler entryHandler = EntryHandler.getInstance();
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
        homeView.setTextLabelFood((int) entryHandler.getFoodAmount() + " kr of " + budget.getFoodCost() + " kr");
        homeView.setTextLabelHousehold((int) entryHandler.getHouseholdAmount() + " kr of " + budget.getHouseholdCost() + " kr");
        homeView.setTextLabelShopping((int) entryHandler.getShoppingAmount() + " kr of " + budget.getShoppingCost() + " kr");
        homeView.setTextLabelTransport((int) entryHandler.getTransportationAmount() + " kr of " + budget.getTransportCost() + " kr");
        homeView.setTextLabelOther((int) entryHandler.getOtherAmount() + " kr of " + budget.getOtherCost() + " kr");
    }

    /**
     * Updates the progress bars according to the entries.
     */

    private void changeProgress() {
        if (budget != null) {
            entryHandler.updateTotalCategoryValues();
            homeView.setProgressBarFood((int) (entryHandler.getFoodAmount()/budget.getFoodCost()));
            homeView.setProgressBarHousehold((int) (entryHandler.getHouseholdAmount()/budget.getHouseholdCost()));
            homeView.setProgressBarShopping((int) (entryHandler.getShoppingAmount()/budget.getShoppingCost()));
            homeView.setProgressBarTransport((int) (entryHandler.getTransportationAmount() / budget.getTransportCost()));
            homeView.setProgressBarOther((int) (entryHandler.getOtherAmount() / budget.getOtherCost()));
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
}
