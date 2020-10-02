package controllers;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class MainController {

    private AnchorPane logInPage;
    private AnchorPane firstPage;
    private AnchorPane entryPage;
    private AnchorPane statisticsOverviewPage;
    private AnchorPane budgetOverviewPage;
    private AnchorPane budgetPage;
    private AnchorPane budgetCharPage;
    private AnchorPane accountPage;
    private AnchorPane goalsPage;
    private AnchorPane signUpPopUp;
    private AnchorPane deleteAccountPopUp;
    private AnchorPane changePasswordPopUp;
    private AnchorPane detailStatistics;
    private DetailStatisticsController detailStatisticsController;


    @FXML
    private AnchorPane mainAnchor;

    public void init() {
        signUpPopUp = PaneFactory.initSignUpPopUp();
        deleteAccountPopUp = PaneFactory.initDelAccPopup();
        logInPage = PaneFactory.initLoginPane();
        firstPage = PaneFactory.initFirstPane();
        accountPage = PaneFactory.initAccountPane();
        entryPage = PaneFactory.initEntryPane();
        goalsPage = PaneFactory.initGoalsPane();
        budgetCharPage = PaneFactory.initBudgetCharPane();
        budgetPage = PaneFactory.initBudgetPane();
        statisticsOverviewPage = PaneFactory.initStatisticsOverviewPane();
        changePasswordPopUp = PaneFactory.initChangePasswordPopUp();
        PaneFactory.Pane<DetailStatisticsController> detailPane = PaneFactory.initStatisticsDetailPane();
        detailStatistics = detailPane.anchorPane;
        detailStatisticsController = detailPane.controller;
        showPage(logInPage);
    }


    // TODO make one for each anchopane
    void showLogInPage() {
        showPage(logInPage);
    }

    void showFirstPage() {
        showPage(firstPage);
    }

    void showAccountPage() {
        showPage(accountPage);

    }

    void showEntryPage() {
        showPage(entryPage);
    }

    void showBudgetPage() {
        showPage(budgetPage);
    }

    void showGoalsPage() {
        showPage(goalsPage);
    }


    void showStatisticsOverviewPage() {
        showPage(statisticsOverviewPage);
    }

    void showStatisticsDetailPage(String text) {
        detailStatisticsController.setLabelPieChart(text);
        showPage(detailStatistics);
    }

    void showBudgetCharPage() {
        showPage(budgetCharPage);
    }

    private void showPage(AnchorPane pane) {
        mainAnchor.getChildren().clear();
        mainAnchor.getChildren().add(pane);
        mainAnchor.toFront();
    }

    /**
     * Getters and setters
     */
    AnchorPane getSignUpPopUp() {
        return signUpPopUp;
    }

    AnchorPane getLogInPage() {
        return logInPage;
    }

    AnchorPane getAccountPage() {
        return accountPage;
    }

    AnchorPane getDeleteAccountPopUp() {
        return deleteAccountPopUp;
    }

    public Node getChangePasswordPopUp() {
        return changePasswordPopUp;
    }


}



