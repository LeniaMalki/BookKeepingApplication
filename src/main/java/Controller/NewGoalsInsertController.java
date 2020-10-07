package Controller;

import Model.Entry;
import Model.EntrySubject;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.iIconSelector;
import Model.SavingGoal;
import Model.SavingsOverview;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
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

    iIconSelector iconSelector;

    SavingsOverview savingsOverview;


    private double amoutSaved = 0;

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

    @FXML
    public void addNewGoal(MouseEvent mouseEvent) {

        savingsImage.setImage(new Image(new File("/../resources/Images/piggyBank.png").toURI().toString()));
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

    @FXML
    public void newIconButtonClicked(MouseEvent mouseEvent) {
        iconSelector.selectIconForSavings();
    }

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



    private void updateSavingLabel() {
        savingGoalText.setText(amoutSaved + " of " + savingAmountTextField.getText() + " saved");
    }

    private void updateProgressBar() {
        amoutSavedProgressBar.setProgress(amoutSaved / Double.parseDouble(savingAmountTextField.getText()));

    }
}