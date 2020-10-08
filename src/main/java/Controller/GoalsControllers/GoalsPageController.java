package Controller.GoalsControllers;

import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.Interfaces.iIconSelector;
import Controller.Interfaces.iPane;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 * Controller for the Savings page
 *
 * @author Artin
 */

public class GoalsPageController implements iPane, iIconSelector {

    MainController parent;

    @FXML
    FlowPane goalFlowPane;
    @FXML
    private AnchorPane headerAnchorPane;

    /**
     * Stats the page when the program is started, also sets header.
     * @param parent is a main controller
     */
    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        goalFlowPane.setVgap(10);

    }

    /**
     * open the budget page
     */

    @FXML
    private void openBudget() {
        parent.showBudgetPage();
    }

    /**
     * open entry page
     */
    @FXML
    private void openEntry() {
        parent.showEntryPage();
    }


    /**
     * adds a new goal
     */

    @FXML
    private void addGoal() {
        goalFlowPane.getChildren().add(new NewGoalsInsertController());
    }

    /**
     * used to select an icon for the saving
     */
    @Override
    public void selectIconForSavings() {
    }

}
