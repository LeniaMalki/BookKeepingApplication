package controllers;

import Model.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BudgetCharPageController implements iPane {

    MainController parent;

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
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
