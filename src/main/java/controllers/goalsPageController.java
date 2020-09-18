package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class goalsPageController implements iPane {

    mainController parent;

    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
