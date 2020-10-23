package View.GoalsView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
/**
 * @author : Artin Abiri
 * Responsibility: In charge of showing a single goal
 * Used by: NewGoalsInsertController
 * Uses: JavaFX, AnchorPane
 */
public class GoalsInsertView extends AnchorPane{

    //________________________________________________ VARIABLES _______________________________________________________

    @FXML
    public AnchorPane savingsAnchorPane;

    @FXML
    public Text savingNameText;

    @FXML
    public Text savingGoalText;

    @FXML
    public AnchorPane savingsAnchorPane1;

    @FXML
    public TextField nameOfSavingTextField;

    @FXML
    public TextField savingAmountTextField;

    @FXML
    public ProgressBar amoutSavedProgressBar;

    @FXML
    public Button okButton;

    //______________________________________________ METHODS ___________________________________________________________

    /**
     * Method for setting a TextField
     */
    public void setName(final String text) {
        savingNameText.setText(text);
    }
    /**
     * Method for setting TextField to color red
     */
    public void setRedField() {
        savingAmountTextField.setStyle("-fx-text-box-border: Red;");
    }
    /**
     * Method for setting amount saved
     */
    public void updateSavingsLabel(final double amoutSaved, final String text) {
        savingGoalText.setText(amoutSaved + " of " + text + " saved");
    }
}
