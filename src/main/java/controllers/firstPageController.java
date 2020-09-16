package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class firstPageController implements ChildPane {
    mainController parent;

    @FXML
    private Button newEntryButton;

    @FXML
    private Button newBudgetButton;

    @FXML
    private AnchorPane headerAnchorPane;


    @FXML
    private void loadEntryPage(ActionEvent event) throws IOException {
        parent.showEntryPage();
    }


    @FXML
    private void goToBudgetButton(ActionEvent event) throws IOException{
        parent.showBudgetPage();
    }

    @Override
    public void initPane(mainController parent) {
        this.parent=parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }
}
