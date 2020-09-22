package controllers;

import Model.Entry;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.FlowPane;

import java.io.IOException;
import java.util.ArrayList;

public class entryPageController implements ChildPane{

    mainController parent;


    private Button currentActiveEntryButton;

    @FXML
    private Button expencesButton;

    @FXML
    private Button incomebutton;

    @FXML
    private Button savingButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private TextField costTextField;

    @FXML
    private ScrollPane entryPageScrollPane;

    @FXML
    AnchorPane entryTypeGroupAnchorPane;

    @FXML
    private Button submitButton;

    @FXML
    private FlowPane entryFlowPlane;

    @FXML
    private AnchorPane headerAnchorPane;

    private ArrayList<Button> entryButtonTypeCluster=new ArrayList<>();
    private ArrayList<Entry> entryList=new ArrayList<>();

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        entryButtonTypeCluster.add(expencesButton);
        entryButtonTypeCluster.add(savingButton);
        entryButtonTypeCluster.add(incomebutton);
        categoryComboBox.getItems().addAll("Food","Household","Shopping","Transportation","Other");
        currentActiveEntryButton=expencesButton;
    }

    @FXML
    private void activateEntryTypeButton(ActionEvent event){
        Button btn = (Button) event.getSource();
        for(Button b : entryButtonTypeCluster){
            b.getStyleClass().remove("activeEntryButton");
            if(!b.getStyleClass().contains("inactiveEntryButton")) {
                b.getStyleClass().add("inactiveEntryButton");
            }
        }
        btn.getStyleClass().remove("inactiveEntryButton");
        btn.getStyleClass().add("activeEntryButton");
        currentActiveEntryButton = btn;
    }

    @FXML
    private void addEntry(ActionEvent event) {
        System.out.println(currentActiveEntryButton.getText());
        Entry entry =new Entry(Double.parseDouble(costTextField.getText()), nameTextField.getText(), categoryComboBox.getValue(),currentActiveEntryButton.getText());
        entryList.add(entry);
        entryFlowPlane.getChildren().add(new EntryListItemController(entry));

    }
}
