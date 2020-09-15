package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class headerController implements ChildPane{

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
    private void clickHeader(ActionEvent event) throws IOException {
        if (homeButton.equals(event.getTarget()) || logo.equals(event.getTarget())) {
            parent.showFirstPage();
        } else if (budgetButton.equals(event.getTarget())) {
            parent.showBudgetCharPage();
        } else if (entryButton.equals(event.getTarget())) {
            parent.showEntryPage();
        } else if (statisticsButton.equals(event.getTarget())) {
            parent.showStatisticsOverviewPage();
        } else if (goalsButton.equals(event.getTarget())){
            //TODO
        }

    }

    //Opens up/going back to first page when pressing on the Logo i.e. works as an escape hatch
    public void escapeHatchHandler(ActionEvent actionEvent) throws IOException {
        parent.showFirstPage();
    }

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
    }

}


