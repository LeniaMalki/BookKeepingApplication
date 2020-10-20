package Controller.MainControllers;

import View.MainViews.HeaderView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HeaderController {

    private final HeaderView headerView = HeaderView.getInstance();

    public HeaderController() {
    }

    //________________________________________________ Methods _________________________________________________________
    @FXML
    private void clickHeader(ActionEvent event) {
        if (headerView.homeButton.equals(event.getTarget()) || headerView.logo.equals(event.getTarget())) {
            headerView.showFirstPage();
        } else if (headerView.budgetButton.equals(event.getTarget())) {
            headerView.showBudgetCharPage();
        } else if (headerView.entryButton.equals(event.getTarget())) {
            headerView.showEntryPage();
        } else if (headerView.statisticsButton.equals(event.getTarget())) {
            headerView.showStatisticsOverviewPage();
        } else if (headerView.accountPageButton.equals((event.getTarget()))) {
            headerView.showAccountPage();
        } else if (headerView.goalButton.equals(event.getTarget())) {
            headerView.showGoalsPage();
        }
    }
}


