package Controller;

import Model.AccountFacade;
import Model.Interfaces.AccountObserver;
import Controller.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

public class HeaderController implements iPane, AccountObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    MainController parent;
    AccountFacade accountFacade = AccountFacade.getInstance();

    //________________________________________________ FXML ____________________________________________________________

    @FXML
    private Hyperlink accountPageButton;
    @FXML
    private Hyperlink logo;
    @FXML
    private Hyperlink homeButton;
    @FXML
    private Hyperlink entryButton;
    @FXML
    private Hyperlink statisticsButton;
    @FXML
    private Hyperlink budgetButton;
    @FXML
    private Hyperlink goalButton;

    //________________________________________________ Methods _________________________________________________________

    @FXML
    private void clickHeader(ActionEvent event) {
        if (homeButton.equals(event.getTarget()) || logo.equals(event.getTarget())) {
            parent.showFirstPage();
        } else if (budgetButton.equals(event.getTarget())) {
            parent.showBudgetCharPage();
        } else if (entryButton.equals(event.getTarget())) {
            parent.showEntryPage();
        } else if (statisticsButton.equals(event.getTarget())) {
            parent.showStatisticsOverviewPage();
        } else if (accountPageButton.equals((event.getTarget()))) {
            parent.showAccountPage();
        } else if (goalButton.equals(event.getTarget())) {
            parent.showGoalsPage();
        }
    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        accountFacade.add(this);
    }

    @Override
    public void update() {
        accountPageButton.setText(accountFacade.getAccountName());
    }
}


