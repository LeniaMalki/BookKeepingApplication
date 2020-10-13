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
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FirstPageController implements iPane, EntryObserver, BudgetObserver {
    MainController parent;
    Budget budget ;
    EntryHandler entryHandler = EntryHandler.getInstance();


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
    private ProgressBar barOther;






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
    }

    private void loadingProgressBar(Entry entry){
        entryHandler.updateGraph();
        foodBar.setProgress(entryHandler.getFoodAmount());
        householdBar.setProgress(entryHandler.getHouseholdAmount());
        shoppingBar.setProgress(entryHandler.getShoppingAmount());
        transportBar.setProgress(entryHandler.getTransportationAmount());
        //barOther.setProgress(entryHandler.getOtherAmount());
    }


    private void updateAllBudgets(){

        //Todo set budget to label


    }
    private void changeProgress(){
        //Todo update progressbar and text
        if(budget!=null){
        entryHandler.updateGraph();
        foodBar.setProgress(entryHandler.getFoodAmount() / budget.getFoodCost());
        householdBar.setProgress(entryHandler.getHouseholdAmount() / budget.getHouseholdCost());
        shoppingBar.setProgress(entryHandler.getShoppingAmount() / budget.getShoppingCost());
        transportBar.setProgress(entryHandler.getTransportationAmount() / budget.getTransportCost());
        barOther.setProgress(entryHandler.getOtherAmount() / budget.getOtherCost());

        updateAllBudgets();}
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
        budget=b;
        updateAllBudgets();

    }
}
