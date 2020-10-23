package View.GoalsView;

import View.Interfaces.iPane;
import Service.PaneFactory;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
/**
 * @author : Artin Abiri
 * Responsibility: In charge of showing the specific page Goals
 * Used by: PaneFactory, GoalsPageController
 * Uses: JavaFX, PaneFactory, MainView
 */
public class GoalsView implements iPane {

    //________________________________________________ VARIABLES _______________________________________________________

    static GoalsView goalsView;
    private MainView parent;
    @FXML
    public FlowPane goalFlowPane;
    @FXML
    public Button seeBudgetButton;
    @FXML
    public Button goToEntryButton;
    @FXML
    public Button addNewSavingGoalButton;
    @FXML
    private AnchorPane headerAnchorPane;

    //______________________________________________ METHODS ___________________________________________________________

    /**
     * Constructor
     */
    public GoalsView() {
        goalsView = this;
    }

    /**
     * Method for obtaining the GoalsView instance. Handles the creation of a new account object.
     */
    public static GoalsView getInstance() {
        if (goalsView == null) {
            goalsView = new GoalsView();
        }
        return goalsView;
    }
    /**
     * initialized this pane and sets header
     * @param parent a MainView
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        goalFlowPane.setVgap(10);
    }
    /**
     * Method that shows the "BudgetPage" of our program
     */
    public void showBudgetPage() {
        parent.showBudgetPage();
    }
    /**
     * Method that shows the "EntryPage" of our program
     */
    public void showEntryPage() {
        parent.showEntryPage();
    }
}
