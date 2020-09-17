package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class budgetPageController implements Initializable {
    @FXML
    private Label foodLabel;
    @FXML
    private Label householdLabel;
    @FXML
    private Label shoppingLabel;
    @FXML
    private Label transportLabel;
    @FXML
    private Label otherLabel;
    @FXML
    private Label savingsLabel;
    @FXML
    private Label foodAmountLabel;
    @FXML
    private Label householdAmountLabel;
    @FXML
    private Label shoppingAmountLabel;
    @FXML
    private Label transportAmountLabel;
    @FXML
    private Label otherAmountLabel;
    @FXML
    private Label savingsAmountLabel;
    @FXML
    private Slider foodSlider;
    @FXML
    private Slider householdSlider;
    @FXML
    private Slider shoppingSlider;
    @FXML
    private Slider transportSlider;
    @FXML
    private Slider otherSlider;
    @FXML
    private Slider savingsSlider;
    @FXML
    private Button saveButton;
    @FXML
    private Button enterIncomeButton;
    @FXML
    private MenuButton previousBudgetButton;
    @FXML
    private Button usePreviousBudgetButton;
    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/org/openjfx/header.fxml"));
            headerAnchorPane.getChildren().setAll(pane);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
