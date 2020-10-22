package View.GoalsView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class GoalsInsertView extends AnchorPane{
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

    public void setName(final String text) {
        savingNameText.setText(text);
    }

    public void setRedField() {
        savingAmountTextField.setStyle("-fx-text-box-border: Red;");
    }

    public void updateSavingsLabel(final double amoutSaved, final String text) {
        savingGoalText.setText(amoutSaved + " of " + text + " saved");
    }
}
