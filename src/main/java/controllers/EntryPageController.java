package controllers;

import Model.Entry;
import Model.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class EntryPageController implements iPane {

    private final ArrayList<Button> entryButtonTypeCluster = new ArrayList<>();
    private final ArrayList<Entry> entryList = new ArrayList<>();
    MainController parent;
    boolean listItemPink = false;
    @FXML
    AnchorPane entryTypeGroupAnchorPane;
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
    private Button submitButton;

    @FXML
    private FlowPane entryFlowPlane;

    @FXML
    private AnchorPane headerAnchorPane;


    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        entryButtonTypeCluster.add(expencesButton);
        entryButtonTypeCluster.add(savingButton);
        entryButtonTypeCluster.add(incomebutton);
        categoryComboBox.getItems().addAll("Food", "Household", "Shopping", "Transportation", "Other");
        currentActiveEntryButton = expencesButton;
        entryPageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    }

    @FXML
    private void activateEntryTypeButton(ActionEvent event) {
        Button btn = (Button) event.getSource();
        for (Button b : entryButtonTypeCluster) {
            b.getStyleClass().remove("activeEntryButton");
            if (!b.getStyleClass().contains("inactiveEntryButton")) {
                b.getStyleClass().add("inactiveEntryButton");
            }
        }
        btn.getStyleClass().remove("inactiveEntryButton");
        btn.getStyleClass().add("activeEntryButton");
        currentActiveEntryButton = btn;
    }

    @FXML
    private void addEntry(ActionEvent event) {
        Entry entry = new Entry(Double.parseDouble(costTextField.getText()), nameTextField.getText(), categoryComboBox.getValue(), currentActiveEntryButton.getText());
        entryList.add(entry);
        entryFlowPlane.getChildren().add(new EntryListItemController(entry, listItemPink));
        listItemPink = !listItemPink;
        costTextField.clear();
        nameTextField.clear();
        categoryComboBox.valueProperty().set("Category");
    }

    @FXML

    private void submitEntries(ActionEvent event) {
        for (Entry entry : entryList) {
            entry.notifyObservers();
        }
        entryFlowPlane.getChildren().clear();

    }
}