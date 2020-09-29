package controllers;

import Model.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class GoalsPageController implements iPane {

    MainController parent;

    @FXML
    FlowPane goalFlowPane;
    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }


    @FXML
    private void addGoal(ActionEvent event) {
        goalFlowPane.getChildren().add(new DountChartController());

    }


}
