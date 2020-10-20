package View.GoalsView;

import View.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class GoalsView implements iPane {
    static GoalsView goalsView;
    private MainController parent;
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

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        goalFlowPane.setVgap(10);
    }

    public void showBudgetPage() {
        parent.showBudgetPage();
    }

    public void showEntryPage() {
        parent.showEntryPage();
    }
}
