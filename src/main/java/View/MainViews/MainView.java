package View.MainViews;

import Controller.StatisticsController.StatisticsDetailController;
import Service.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * @author : Oscar Forsberg
 * Responsibility: In charge of initalizing all pages and ables them to actually be shown
 * Used by: ChangePasswordView, DeleteAccountView, LogInView, ProfilPageView, SignUpView, BudgetChartView, BudgetView,
 *          EntryView, GoalsView, HeaderView, HomeView, StatisticsDetailView, StatisticsOverviewView, iPane, PaneFactory
 * Uses: JavaFX, PaneFactory, StatisticsDetailController, PaneFactory
 */

public class MainView{

    //________________________________________________ VARIABLES _______________________________________________________

    static MainView mainView;

    @FXML
    public AnchorPane logInPage;
    @FXML
    public AnchorPane firstPage;
    @FXML
    public AnchorPane entryPage;
    @FXML
    public AnchorPane budgetPage;
    @FXML
    public AnchorPane budgetCharPage;
    @FXML
    public AnchorPane accountPage;
    @FXML
    public AnchorPane goalsPage;
    @FXML
    public AnchorPane signUpPopUp;
    @FXML
    public AnchorPane deleteAccountPopUp;
    @FXML
    public AnchorPane changePasswordPopUp;
    @FXML
    public AnchorPane detailStatistics;
    @FXML
    public AnchorPane overviewStatistics;
    @FXML
    public AnchorPane mainAnchor;

    //______________________________________________ METHODS ___________________________________________________________

    /**
     * Constructor for MainView
     */
    public MainView() {
        mainView = this;;
    }

    /**
     * Singleton pattern for getting an instance of this class
     * @return instance of view
     */
    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

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
    public void showPage(final AnchorPane pane) {
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
    public void showStatisticsDetailPage(final String text) {
        final StatisticsDetailController statisticsDetailController = new StatisticsDetailController();
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

    /**
     * A getter for retrieving the AnchorPane, a pop-up screen, for when you sign up
     */
    public AnchorPane getSignUpPopUp() {
        return mainView.signUpPopUp;
    }
    /**
     * A getter for retrieving the AnchorPane, a pop-up screen, for when you delete your account
     */
    public AnchorPane getDeleteAccountPopUp() {
        return mainView.deleteAccountPopUp;
    }

    /**
     * A getter for retrieving the Node for when you change your password
     */
    public Node getChangePasswordPopUp() {
        return mainView.changePasswordPopUp;
    }

}
