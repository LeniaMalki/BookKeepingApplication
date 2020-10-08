package controllers;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.iPane;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

import java.io.IOException;

public class HeaderController implements iPane, AccountObserver {


    MainController parent;

    @FXML
    Hyperlink accountPageButton;
    User user = User.getInstance();
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

    @FXML
    private void clickHeader(ActionEvent event) throws IOException {
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
        user.add(this);
    }

    @Override
    public void update() {
        this.accountPageButton.setText(user.getName());
    }
}

