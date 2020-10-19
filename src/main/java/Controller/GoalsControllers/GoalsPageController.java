package Controller.GoalsControllers;

import View.GoalsView.GoalsView;

/**
 * Controller for the Savings page
 *
 * @author Artin
 */

public class GoalsPageController {

private final GoalsView goalsView= GoalsView.getInstance();
public GoalsPageController(){
    setAllViewListeners();
}


   private void setAllViewListeners(){
       goalsView.seeBudgetButton.setOnAction(event -> openBudget());
       goalsView.goToEntryButton.setOnAction(event -> openEntry());
       goalsView.addNewSavingGoalButton.setOnAction(event -> addGoal());
    }


    /**
     * open the budget page
     */

    private void openBudget() {
        goalsView.showBudgetPage();
    }

    /**
     * open entry page
     */
    private void openEntry() {
       goalsView.showEntryPage();
    }


    /**
     * adds a new goal
     */

    private void addGoal() {
        final NewGoalsInsertController goalsInsertController=new NewGoalsInsertController();
        goalsView.goalFlowPane.getChildren().add(goalsInsertController.getView());
    }


}
