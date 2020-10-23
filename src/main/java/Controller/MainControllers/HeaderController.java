package Controller.MainControllers;

import Controller.Interfaces.ControllerInterface;
import View.MainViews.HeaderView;
/**
 * @author : Oscar Forsberg, Artin Abiri, Lenia Malki
 * Responsibility: Works as a header which takes us to different pages
 * Used by: PaneFactory
 * Uses: ControllerInterface, HeaderView
 */
public class HeaderController implements ControllerInterface {

    //________________________________________________ VARIABLES _______________________________________________________

    private final HeaderView headerView = HeaderView.getInstance();

    //________________________________________________ Methods _________________________________________________________

    /**
     * Constructor
     */
    public HeaderController() {
        setAllViewListeners();
    }

    /**
     * Method that says what should happen when pressing different buttons. Sends that information to the view.
     */
    @Override
    public void setAllViewListeners() {
        headerView.budgetButton.setOnAction(a->headerView.showBudgetCharPage());
        headerView.homeButton.setOnAction(a->headerView.showFirstPage());
        headerView.accountPageButton.setOnAction(a->headerView.showAccountPage());
        headerView.goalButton.setOnAction(a->headerView.showGoalsPage());
        headerView.statisticsButton.setOnAction(a->headerView.showStatisticsOverviewPage());
        headerView.logo.setOnAction(a->headerView.showFirstPage());
        headerView.entryButton.setOnAction(a->headerView.showEntryPage());
    }
}


