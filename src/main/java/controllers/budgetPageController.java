package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class budgetPageController implements iPane {

    mainController parent;
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
    private CheckMenuItem checkMenuItem1;
    @FXML
    private CheckMenuItem checkMenuItem2;
    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
