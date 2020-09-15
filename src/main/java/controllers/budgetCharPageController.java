package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class budgetCharPageController implements ChildPane {

    mainController parent;

    @FXML
    private Button editBudgetButton;

    @FXML
    private Button addNewBudgetButton;
    @FXML
    private AnchorPane headerAnchorPane;


    @Override
    public void initPane(mainController parent) {
        this.parent=parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
