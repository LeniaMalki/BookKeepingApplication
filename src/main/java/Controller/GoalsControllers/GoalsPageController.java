package Controller.GoalsControllers;

import View.GoalsView.GoalsView;

/**
 * Controller for the Savings page
 *
 * @author Artin
 */

public class GoalsPageController {

private GoalsView goalsView= GoalsView.getInstance();
public GoalsPageController(){

}


   private void setAllViewLiseners(){
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
        goalsView.goalFlowPane.getChildren().add(new NewGoalsInsertController());
    }


}
