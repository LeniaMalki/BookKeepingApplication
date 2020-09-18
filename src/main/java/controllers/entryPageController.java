package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class entryPageController implements iPane {

    mainController parent;

    @FXML
    private Hyperlink logo;

    @FXML
    private Hyperlink homeButton;

    @FXML
    private Hyperlink entryButton;

    @FXML
    private Hyperlink statisticsButton;

    @FXML
    private Hyperlink budgetButton;

    @FXML
    private Hyperlink goalsButton;

    @FXML
    private Button expencesButton;

    @FXML
    private Button incomebutton;

    @FXML
    private Button savingButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private MenuButton categoryMenuButton;

    @FXML
    private TextField costTextField;

    @FXML
    private ScrollPane entryPageScrollPane;

    @FXML
    private Button submitButton;

    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
