package Controller.GoalsControllers;

import Model.EntryLogic.Entry;
import Model.EntryLogic.EntrySubject;
import Model.GoalsLogic.SavingGoal;
import Model.GoalsLogic.SavingsOverview;
import Model.Interfaces.EntryObserver;
import View.GoalsView.GoalsInsertView;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NewGoalsInsertController extends AnchorPane implements EntryObserver {
    private GoalsInsertView insertView=new GoalsInsertView();

    SavingsOverview savingsOverview;


    private double amoutSaved = 0;

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
        savingsOverview = SavingsOverview.getInstance();
        EntrySubject.add(this);

    }
    private void setAllViewLiseners() {
    insertView.okButton.setOnAction(e-> addNewGoal());

    }


        /**
         * Adds new a new goal object when you ckick on the make new goals button
         */


    public void addNewGoal() {

        try {
            insertView.setName(insertView.nameOfSavingTextField.getText());
            registerSavingGoal(Double.parseDouble(insertView.savingAmountTextField.getText()),insertView.savingNameText.getText(),insertView. savingsImage.getImage());
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
     * @param goal the goal you want to reach
     * @param name name of the goal
     * @param image the image you want to set
     */
    private void registerSavingGoal(double goal, String name, Image image) {
        SavingGoal savingGoal = new SavingGoal(goal, name, image);
    }


    @Override
    public void update(String category, String type, double Value) {
        if (category.equals(insertView.nameOfSavingTextField.getText())) {
            amoutSaved += savingsOverview.getAmountSaved(category);
            updateSavingLabel();
            updateProgressBar();
        }

    }

    @Override
    public void update(Entry entry) {

    }

    /**
     * updates the label that states the money saved
     */
    private void updateSavingLabel() {
        insertView.   savingGoalText.setText(amoutSaved + " of " +insertView. savingAmountTextField.getText() + " saved");
    }
    /**
     * updates the progressbar with the percentage of the goal reached
     */
    private void updateProgressBar() {
        insertView.   amoutSavedProgressBar.setProgress(amoutSaved / Double.parseDouble(insertView.savingAmountTextField.getText()));

    }
}
