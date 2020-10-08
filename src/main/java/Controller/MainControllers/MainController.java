package Controller.MainControllers;


import Controller.StatisticsController.StatisticsDetailController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
/**
 * The main controller in the program. Shows different pages
 *
 * @author Oscar
 */

public class MainController {

    //________________________________________________ VARIABLES _______________________________________________________
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
    private StatisticsDetailController detailStatisticsController;

    //________________________________________________ FXML ____________________________________________________________
    @FXML
    private AnchorPane mainAnchor;

    //______________________________________________ METHODS ___________________________________________________________
    /**
     * A function that assigns variables with different initialized pages that later can be shown in our program by
     * using the function showPage();
     */
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
        PaneFactory.Pane<StatisticsDetailController> detailPane = PaneFactory.initStatisticsDetailPane();
        detailStatistics = detailPane.anchorPane;
        detailStatisticsController = detailPane.controller;
        showPage(logInPage);
    }

    /**
     * A function that shows us our desired AnchorPane
     *
     * @param pane an AnchorPane that is one of our visible pages in our program
     */
    private void showPage(AnchorPane pane) {
        mainAnchor.getChildren().clear();
        mainAnchor.getChildren().add(pane);
        mainAnchor.toFront();
    }

    void showGoalsPage() {
        showPage(goalsPage);
    }

    void showStatisticsOverviewPage() {
        showPage(statisticsOverviewPage);
    }

    void showBudgetCharPage() {
        showPage(budgetCharPage);
    }

    public void showStatisticsDetailPage(String text) {     //TODO PUBLIC????
        detailStatisticsController.setLabelPieChart(text);
        showPage(detailStatistics);
    }

    public void showAccountPage() {     //TODO PUBLIC????
        showPage(accountPage);
    }

    public void showEntryPage() {
        showPage(entryPage);            //TODO PUBLIC????
    }

    public void showBudgetPage() {      //TODO PUBLIC????
        showPage(budgetPage);
    }

    public void showLogInPage() {
        showPage(logInPage);            //TODO PUBLIC????
    }

    public void showFirstPage() {
        showPage(firstPage);            //TODO PUBLIC????
    }

    //____________________________________________ GETTERS / SETTERS ___________________________________________________

    public AnchorPane getSignUpPopUp() {
        return signUpPopUp;
    }

    public AnchorPane getDeleteAccountPopUp() {
        return deleteAccountPopUp;
    }

    public Node getChangePasswordPopUp() {
        return changePasswordPopUp;
    }


}



