package controllers;

import Model.Interfaces.iIconSelector;
import Model.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.awt.event.MouseEvent;

public class GoalsPageController implements iPane, iIconSelector {

    MainController parent;

    @FXML
    FlowPane goalFlowPane;
    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        goalFlowPane.setVgap(10);

    }
    @FXML
    private void openBudget(){
        parent.showBudgetPage();
    }

    @FXML
    private void openEntry(){
        parent.showEntryPage();
    }
    @FXML
    private void addGoal() {
        goalFlowPane.getChildren().add(new NewGoalsInsertController());
    }

    @Override
    public void selectIconForSavings() {
    }

}
