package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class entryPageController implements ChildPane{

    mainController parent;
    private Button CurrentActiveEntryButton;
    private List<Button> entryButtonTypeCluster=new ArrayList(){{
        add(expencesButton);
        add(incomebutton);
        add(savingButton);
    }};

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
    AnchorPane entryTypeGroupAnchorPane;
    @FXML
    private Button submitButton;

    @FXML
    private AnchorPane headerAnchorPane;

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    @FXML
    private void activateEntryTypeButton(ActionEvent event){
        Button btn = (Button) event.getSource();
        for(Button b:entryButtonTypeCluster){
            b.getStyleClass().remove("activeEntryButton");
            b.getStyleClass().add("inactiveEntryButton");
        }
        btn.getStyleClass().add("activeEntryButton");
    }
}
