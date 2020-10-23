package View.MainViews;

import View.Interfaces.iPane;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
/**
 * @author : Oscar Forsberg, Lenia Malki, Artin Abiri
 * Responsibility: In charge of displaying the page for the detail statistics page.
 * Used by: HeaderController, PaneFactory
 * Uses: iPane, JavaFX, MainView
 **/
public class HeaderView implements iPane {

    //________________________________________________ VARIABLES _______________________________________________________

    static HeaderView headerView;
    @FXML
    public Hyperlink accountPageButton;
    @FXML
    public Hyperlink logo;
    @FXML
    public Hyperlink homeButton;
    @FXML
    public Hyperlink entryButton;
    @FXML
    public Hyperlink statisticsButton;
    @FXML
    public Hyperlink budgetButton;
    @FXML
    public Hyperlink goalButton;
    private MainView parent;

    //______________________________________________ METHODS ___________________________________________________________

    /**
     * Singleton pattern for getting an instance of this class
     *
     * @return instance of view
     */
    public static HeaderView getInstance() {
        if (headerView == null) {
            headerView = new HeaderView();
        }
        return headerView;
    }
    /**
     * Constructor for HeaderView
     */
    public HeaderView(){
        headerView = this;
    }
    /**
     * Method that shows the "FirstPage" of our program
     */
    public void showFirstPage() {
        parent.showFirstPage();
    }
    /**
     * Method that shows the "BudgetPage" of our program
     */
    public void showBudgetCharPage() {
        parent.showBudgetCharPage();
    }
    /**
     * Method that shows the "EntryPage" of our program
     */
    public void showEntryPage() {
        parent.showEntryPage();
    }
    /**
     * Method that shows the "StatisticsOverviewPage" of our program
     */
    public void showStatisticsOverviewPage() {
        parent.showStatisticsOverviewPage();
    }
    /**
     * Method that shows the "AccountPage" of our program
     */
    public void showAccountPage() {
        parent.showAccountPage();
    }
    /**
     * Method that shows the "GoalsPage" of our program
     */
    public void showGoalsPage() {
        parent.showGoalsPage();
    }
    /**
     * initializes this pane
     * @param parent a MainView
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
    }

}
