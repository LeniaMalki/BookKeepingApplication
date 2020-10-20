package Controller.MainControllers;


import Controller.StatisticsController.StatisticsDetailController;
import Service.PaneFactory;
import View.MainViews.MainView;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * The main controller in the program. Shows different pages
 *
 * @author Oscar
 */

public class MainController {

    MainView mainView = MainView.getInstance();

    //______________________________________________ METHODS ___________________________________________________________

    /**
     * A function that assigns variables with different initialized pages that later can be shown in our program by
     * using the function showPage();
     */
    public void init() {
        mainView.signUpPopUp = PaneFactory.initSignUpPopUp();
        mainView.deleteAccountPopUp = PaneFactory.initDelAccPopup();
        mainView.logInPage = PaneFactory.initLoginPane();
        mainView.firstPage = PaneFactory.initFirstPane();
        mainView.accountPage = PaneFactory.initAccountPane();
        mainView.entryPage = PaneFactory.initEntryPane();
        mainView.goalsPage = PaneFactory.initGoalsPane();
        mainView.budgetCharPage = PaneFactory.initBudgetCharPane();
        mainView.budgetPage = PaneFactory.initBudgetPane();
        mainView.changePasswordPopUp = PaneFactory.initChangePasswordPopUp();
        mainView.overviewStatistics = PaneFactory.initStatisticsOverviewPane();
        mainView.detailStatistics = PaneFactory.initStatisticsDetailPane();
        showLogInPage();
    }

    /**
     * A function that shows us our desired AnchorPane
     *
     * @param pane an AnchorPane that is one of our visible pages in our program
     */
    public void showPage(AnchorPane pane) {
        mainView.mainAnchor.getChildren().clear();
        mainView.mainAnchor.getChildren().add(pane);
        mainView.mainAnchor.toFront();
    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showGoalsPage() {
        showPage(mainView.goalsPage);
    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showStatisticsOverviewPage() {
        showPage(mainView.overviewStatistics);
    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showBudgetCharPage() {
        showPage(mainView.budgetCharPage);
    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane. Takes in a string and uses a
     * controller to set a label on that specific AnchorPane.
     */


    public void showStatisticsDetailPage(String text) {
        StatisticsDetailController statisticsDetailController = new StatisticsDetailController();
        statisticsDetailController.setLabelPieChart(text);
        showPage(mainView.detailStatistics);

    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showAccountPage() {
        showPage(mainView.accountPage);
    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showEntryPage() {
        showPage(mainView.entryPage);
    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showBudgetPage() {
        showPage(mainView.budgetPage);
    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showLogInPage() {
        showPage(mainView.logInPage);
    }

    /**
     * A function that uses the function "showPage" to show us a specific AnchorPane
     */
    public void showFirstPage() {
        showPage(mainView.firstPage);
    }

    //____________________________________________ GETTERS / SETTERS ___________________________________________________

    public AnchorPane getSignUpPopUp() {
        return mainView.signUpPopUp;
    }

    public AnchorPane getDeleteAccountPopUp() {
        return mainView.deleteAccountPopUp;
    }

    public Node getChangePasswordPopUp() {
        return mainView.changePasswordPopUp;
    }


}



