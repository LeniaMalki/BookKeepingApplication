package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class GoalsPageController implements iPane {

    MainController parent;

    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
