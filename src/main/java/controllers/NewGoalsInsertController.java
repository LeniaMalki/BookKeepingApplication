package controllers;

import Model.Interfaces.iIconSelector;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

public class NewGoalsInsertController extends AnchorPane {

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

    iIconSelector iconSelector;


    private int amoutSaved = 10;

    public NewGoalsInsertController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/GoalsInseet.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    @FXML
    public void addNewGoal(MouseEvent mouseEvent){
        savingNameText.setText(nameOfSavingTextField.getText());
        savingGoalText.setText(amoutSaved + " of " + savingAmountTextField.getText() + " saved");
        amoutSavedProgressBar.setProgress(amoutSaved/Double.parseDouble(savingAmountTextField.getText()));
        savingsAnchorPane1.getChildren().clear();
        savingsAnchorPane1.setVisible(false);
    }
    @FXML
    public void newIconButtonClicked(MouseEvent mouseEvent) {
        iconSelector.selectIconForSavings();
    }
}
