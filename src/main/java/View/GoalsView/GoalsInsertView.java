package View.GoalsView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class GoalsInsertView {
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
    public AnchorPane infoAnchorPane;

    @FXML
    public ImageView savingsImage;
    @FXML
    public Button okButton;

    public void setName(String text) {
        savingNameText.setText(text);
    }

    public void setRedField() {
        savingAmountTextField.setStyle("-fx-text-box-border: Red;");
    }
}
