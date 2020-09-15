package controllers;


import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class mainController {

    private AnchorPane logInPage;
    private AnchorPane firstPage;
    private AnchorPane entryPage;
    private AnchorPane statisticsOverviewPage;
    private AnchorPane budgetOverviewPage;
    private AnchorPane budgetPage;
    private AnchorPane budgetCharPage;
    private AnchorPane accountPage;
    private AnchorPane goalsPage;

    @FXML
    private AnchorPane mainAnchor;


    public void init() {
        logInPage = PaneFactory.initLoginPane();
        firstPage = PaneFactory.initFirstPane();
        accountPage = PaneFactory.initAccountPane();
        entryPage = PaneFactory.initEntryPane();
        budgetPage = PaneFactory.initBudgetPane();
        budgetCharPage = PaneFactory.initBudgetCharPane();
        statisticsOverviewPage = PaneFactory.initStatisticsOverviewPane();
        //goalsPage = loadPage.ini DO THIS
        //TODO add all main anchopanes



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

    void showStatisticsOverviewPage(){
        showPage(statisticsOverviewPage);
    }

    void showStatisticsDetailPage(String text){
        PaneFactory.Pane<detailStatisticsController> pane = PaneFactory.initStatisticsDetailPane();
        showPage(pane.anchorPane);
        pane.controller.setLabelPieChart(text);

    }

    void showBudgetCharPage() {
        showPage(budgetCharPage);
    }

    private void showPage(AnchorPane pane) {
        mainAnchor.getChildren().clear();
        mainAnchor.getChildren().add(pane);
        mainAnchor.toFront();
    }
}
