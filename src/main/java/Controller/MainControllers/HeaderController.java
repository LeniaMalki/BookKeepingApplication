package Controller.MainControllers;

import Controller.Interfaces.ControllerInterface;
import View.MainViews.HeaderView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HeaderController implements ControllerInterface {

    private final HeaderView headerView = HeaderView.getInstance();

    public HeaderController() {
        setAllViewListeners();
    }

    //________________________________________________ Methods _________________________________________________________

    public void setAllViewListeners() {
        headerView.budgetButton.setOnAction(a->headerView.showBudgetCharPage());
        headerView.homeButton.setOnAction(a->headerView.showFirstPage());
        headerView.accountPageButton.setOnAction(a->headerView.showAccountPage());
        headerView.goalButton.setOnAction(a->headerView.showGoalsPage());
        headerView.statisticsButton.setOnAction(a->headerView.showStatisticsOverviewPage());
        headerView.logo.setOnAction(a->headerView.showFirstPage());
        headerView.entryButton.setOnAction(a->headerView.showEntryPage());
    }
}


