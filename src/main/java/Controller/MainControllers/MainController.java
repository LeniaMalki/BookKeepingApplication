package Controller.MainControllers;


import Controller.StatisticsController.StatisticsDetailController;
import Controller.StatisticsController.StatisticsOverViewController;
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
    private AnchorPane budgetPage;
    private AnchorPane budgetCharPage;
    private AnchorPane accountPage;
    private AnchorPane goalsPage;
    private AnchorPane signUpPopUp;
    private AnchorPane deleteAccountPopUp;
    private AnchorPane changePasswordPopUp;
    private AnchorPane detailStatistics;
    private AnchorPane overviewStatistics;


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
        changePasswordPopUp = PaneFactory.initChangePasswordPopUp();
        overviewStatistics = PaneFactory.initStatisticsOverviewPane();
        detailStatistics = PaneFactory.initStatisticsDetailPane();
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
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    void showGoalsPage() {
        showPage(goalsPage);
    }
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    void showStatisticsOverviewPage() {
        showPage(overviewStatistics);
    }
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showBudgetCharPage() {
        showPage(budgetCharPage);
    }
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane.
     * Takes in a string and uses a controller to set a label on that specific AnchorPane.
     */


    public void showStatisticsDetailPage(String text) {
        StatisticsDetailController statisticsDetailController =  new StatisticsDetailController();
        statisticsDetailController.setLabelPieChart(text);
        showPage(detailStatistics);

    }
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showAccountPage() {
        showPage(accountPage);
    }
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showEntryPage() {
        showPage(entryPage);
    }
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showBudgetPage() {
        showPage(budgetPage);
    }
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showLogInPage() {
        showPage(logInPage);
    }
    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showFirstPage() {
        showPage(firstPage);
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



