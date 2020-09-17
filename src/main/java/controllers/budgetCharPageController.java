package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class budgetCharPageController implements ChildPane {

    mainController parent;

    @FXML
    private Button editBudgetButton;

    @FXML
    private Button addNewBudgetButton;
    @FXML
    private AnchorPane headerAnchorPane;

    @FXML
    private void addNewBudgetButton(ActionEvent event) throws IOException {
        parent.showBudgetPage();
    }


    @Override
    public void initPane(mainController parent) {
        this.parent=parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
