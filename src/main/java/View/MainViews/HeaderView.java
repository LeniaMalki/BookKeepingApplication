package View.MainViews;

import View.Interfaces.iPane;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;

public class HeaderView implements iPane {

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

    public static HeaderView getInstance() {
        if (headerView == null) {
            headerView = new HeaderView();
        }
        return headerView;
    }

    public HeaderView(){
        headerView = this;
    }

    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
    }

    public void showFirstPage() {
        parent.showFirstPage();
    }

    public void showBudgetCharPage() {
        parent.showBudgetCharPage();
    }

    public void showEntryPage() {
        parent.showEntryPage();
    }

    public void showStatisticsOverviewPage() {
        parent.showStatisticsOverviewPage();
    }

    public void showAccountPage() {
        parent.showAccountPage();
    }

    public void showGoalsPage() {
        parent.showGoalsPage();
    }

}
