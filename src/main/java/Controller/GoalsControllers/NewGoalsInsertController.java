package Controller.GoalsControllers;

import Model.EntryLogic.Entry;
import Model.EntryLogic.EntrySubject;
import Model.GoalsLogic.SavingGoal;
import Model.GoalsLogic.SavingsOverview;
import Model.Interfaces.EntryObserver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class NewGoalsInsertController extends AnchorPane implements EntryObserver {

    @FXML
    private AnchorPane savingsAnchorPane;

    @FXML
    private Text savingNameText;

    @FXML
    private Text savingGoalText;

    @FXML
    private AnchorPane savingsAnchorPane1;

    @FXML
    private TextField nameOfSavingTextField;

    @FXML
    private TextField savingAmountTextField;

    @FXML
    private ProgressBar amoutSavedProgressBar;

    @FXML
    private AnchorPane infoAnchorPane;

    @FXML
    private ImageView savingsImage;

    SavingsOverview savingsOverview;


    private double amoutSaved = 0;

    /**
     * Creates and instantiates a pane that is a goals insert
     * Adds the pane as an observer to Entry
     */

    public NewGoalsInsertController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/GoalsInseet.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        savingsOverview = SavingsOverview.getInstance();
        EntrySubject.add(this);
    }

    /**
     * Adds new a new goal object when you ckick on the make new goals button
     */
    @FXML
    public void addNewGoal() {

        try {
            savingNameText.setText(nameOfSavingTextField.getText());
            registerSavingGoal(Double.parseDouble(savingAmountTextField.getText()), savingNameText.getText(), savingsImage.getImage());
            savingsAnchorPane1.getChildren().clear();
            savingsAnchorPane1.setVisible(false);
            updateSavingLabel();
            updateProgressBar();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            savingAmountTextField.setStyle("-fx-text-box-border: Red;");
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
        if (category.equals(nameOfSavingTextField.getText())) {
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
        savingGoalText.setText(amoutSaved + " of " + savingAmountTextField.getText() + " saved");
    }
    /**
     * updates the progressbar with the percentage of the goal reached
     */
    private void updateProgressBar() {
        amoutSavedProgressBar.setProgress(amoutSaved / Double.parseDouble(savingAmountTextField.getText()));

    }
}
