package Controller.MainControllers;

import Controller.Interfaces.iPane;
import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import Model.EntryLogic.EntrySubject;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FirstPageController implements iPane, EntryObserver, BudgetObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    Budget budget;
    EntryHandler entryHandler = EntryHandler.getInstance();

    //__________________________________________________ FXML __________________________________________________________

    @FXML
    private Button newEntryButton;
    @FXML
    private Button newBudgetButton;
    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private ProgressBar foodBar;
    @FXML
    private ProgressBar householdBar;
    @FXML
    private ProgressBar shoppingBar;
    @FXML
    private ProgressBar transportBar;
    @FXML
    private ProgressBar otherbar;

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

    //_________________________________________________ METHODS ________________________________________________________

    @FXML
    private void loadEntryPage(ActionEvent event) throws IOException {
        parent.showEntryPage();
    }


    @FXML
    private void goToBudgetButton(ActionEvent event) throws IOException {
        parent.showBudgetPage();
    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        BudgetSubject.add(this);
        EntrySubject.add(this);
        budget = new Budget(0, 0, 0, 0, 0, 0, "0");
        updateAllBudgets();
    }


    private void updateAllBudgets() {

        foodLabel.setText((int) entryHandler.getFoodAmount() + " kr of " + budget.getFoodCost() + " kr");
        householdLabel.setText((int) entryHandler.getHouseholdAmount() + " kr of " + budget.getHouseholdCost() + " kr");
        shoppingLabel.setText((int) entryHandler.getShoppingAmount() + " kr of " + budget.getShoppingCost() + " kr");
        transportLabel.setText((int) entryHandler.getTransportationAmount() + " kr of " + budget.getTransportCost() + " kr");
        otherLabel.setText((int) entryHandler.getOtherAmount() + " kr of " + budget.getOtherCost() + " kr");
    }

    private void changeProgress() {
        if (budget != null) {
            entryHandler.updateTotalCategoryValues();
            foodBar.setProgress(entryHandler.getFoodAmount() / budget.getFoodCost());
            householdBar.setProgress(entryHandler.getHouseholdAmount() / budget.getHouseholdCost());
            shoppingBar.setProgress(entryHandler.getShoppingAmount() / budget.getShoppingCost());
            transportBar.setProgress(entryHandler.getTransportationAmount() / budget.getTransportCost());
            otherbar.setProgress(entryHandler.getOtherAmount() / budget.getOtherCost());
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
