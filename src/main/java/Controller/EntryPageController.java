package Controller;

import Model.Entry;
import Model.Interfaces.SavingsObserver;
import Model.Interfaces.SavingsSubject;
import Controller.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class EntryPageController implements iPane, SavingsObserver {

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
    private ArrayList<String> savingCategory = new ArrayList<>() {{
        add("General Saving");
    }};
    private ArrayList<String> expenceCategory = new ArrayList<>() {{
        add("Food");
        add("Household");
        add("Shopping");
        add("Transportation");
        add("Other");

    }};


    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        entryButtonTypeCluster.add(expencesButton);
        entryButtonTypeCluster.add(savingButton);
        entryButtonTypeCluster.add(incomebutton);
        categoryComboBox.getItems().addAll(expenceCategory);
        currentActiveEntryButton = expencesButton;
        entryPageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        SavingsSubject.observers.add(this);
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
        checkCategoryBox(btn);
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
        entry.notifyEntryListeners();
        }
        entryFlowPlane.getChildren().clear();
        entryList.clear();
    }

    @Override
    public void update(String s) {
        savingCategory.add(s);
        if (currentActiveEntryButton== savingButton){
            categoryComboBox.getItems().add(s);
        }
    }

    private void checkCategoryBox(Button b) {
        if (b == savingButton) {
            categoryComboBox.getItems().removeAll(expenceCategory);
            categoryComboBox.getItems().addAll(savingCategory);
        } else {
            categoryComboBox.getItems().removeAll(savingCategory);
            categoryComboBox.getItems().addAll(expenceCategory);
        }
    }
}