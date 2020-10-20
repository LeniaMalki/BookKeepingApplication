package Controller.GoalsControllers;

import Controller.Interfaces.ControllerInterface;
import Model.EntryLogic.EntrySubject;
import Model.EntryLogic.iEntry;
import Model.GoalsLogic.SavingGoal;
import Model.GoalsLogic.SavingsOverview;
import Model.Interfaces.EntryObserver;
import View.GoalsView.GoalsInsertView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class NewGoalsInsertController implements EntryObserver, ControllerInterface {
    private final GoalsInsertView insertView = new GoalsInsertView();
    SavingsOverview savingsOverview;
    private double amountSaved = 0;

    /**
     * Creates and instantiates a pane that is a goals insert
     * Adds the pane as an observer to Entry
     */

    public NewGoalsInsertController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/GoalsInseet.fxml"));
        fxmlLoader.setController(insertView);
        fxmlLoader.setRoot(insertView);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setAllViewListeners();
        savingsOverview = SavingsOverview.getInstance();
        EntrySubject.add(this); //TODO denna är beroende på model

    }

    @Override
    public void setAllViewListeners() {
        insertView.okButton.setOnAction(e -> addNewGoal());

    }

    public GoalsInsertView getView() {
        return insertView;
    }


    /**
     * Adds new a new goal object when you ckick on the make new goals button
     */


    public void addNewGoal() {
        try {
            insertView.setName(insertView.nameOfSavingTextField.getText());
            registerSavingGoal(Double.parseDouble(insertView.savingAmountTextField.getText()), insertView.savingNameText.getText());
            insertView.savingsAnchorPane1.getChildren().clear();
            insertView.savingsAnchorPane1.setVisible(false);
            updateSavingLabel();
            updateProgressBar();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            insertView.setRedField();
        }


    }

    /**
     * registers a new goal
     *
     * @param goal the goal you want to reach
     * @param name name of the goal
     */
    private void registerSavingGoal(double goal, String name) {
        SavingGoal savingGoal = new SavingGoal(goal, name);
    }


    @Override
    public void update(String category, String type, double Value) {
        if (category.equals(insertView.nameOfSavingTextField.getText())) {
            amountSaved += savingsOverview.getAmountSaved(category);
            updateSavingLabel();
            updateProgressBar();
        }

    }

    @Override
    public void update(iEntry entry) {

    }

    /**
     * updates the label that states the money saved
     */
    private void updateSavingLabel() {
        insertView.updateSavingsLabel(amountSaved, insertView.savingAmountTextField.getText());
    }

    /**
     * updates the progressbar with the percentage of the goal reached
     */
    private void updateProgressBar() {
        insertView.amoutSavedProgressBar.setProgress(amountSaved / Double.parseDouble(insertView.savingAmountTextField.getText()));

    }
}
