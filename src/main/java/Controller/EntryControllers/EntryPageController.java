package Controller.EntryControllers;

import Controller.Interfaces.RemoveItemObserver;
import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import Model.EntryLogic.Entry;
import Model.Interfaces.SavingsObserver;
import Model.Interfaces.SavingsSubject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
/**
 * Controller for the entry page
 *
 * @author Artin
 */

public class EntryPageController implements iPane, SavingsObserver, RemoveItemObserver {

    private final ArrayList<Button> entryButtonTypeCluster = new ArrayList<>();
    private final ArrayList<Entry> entryList = new ArrayList<>();
    MainController parent;
    private boolean listItemPink = false;

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


    /**
     * Initializes the pane when the program starts also adds the header
     * @param parent the main controller
     */
    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        setValuesAtStart();
    }

    /**
     * sets the values that need to be added at the start of the program
     */
    private void setValuesAtStart(){
        entryButtonTypeCluster.add(expencesButton);
        entryButtonTypeCluster.add(savingButton);
        entryButtonTypeCluster.add(incomebutton);
        categoryComboBox.getItems().addAll(expenceCategory);
        currentActiveEntryButton = expencesButton;
        entryPageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        SavingsSubject.observers.add(this);
    }

    /**
     * activates of deactivates the button that is pressed, this is for choosing the entry type
     * @param event if something is pressed an ActionEvent is fired and tells the system what happened
     */
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
        incomeButtonAction(btn);
        checkCategoryBox(btn);
    }

    /**
     * checks if the income button is clicked and hides the category bar if it is
     * @param btn the button that is clicked
     */
    private void incomeButtonAction(Button btn){
        if (btn==incomebutton){
            categoryComboBox.setVisible(false);
            costTextField.setLayoutY(282);
        }
        else{
            categoryComboBox.setVisible(true);
            costTextField.setLayoutY(391);
        }
    }
    /**
     * Adds a new entry when the user has put in the right parameters and added
     */
    @FXML
    private void addEntry() {
        if (currentActiveEntryButton== incomebutton){
            categoryComboBox.setValue("Income");
        }
        Entry entry = new Entry(Double.parseDouble(costTextField.getText()), nameTextField.getText(), categoryComboBox.getValue(), currentActiveEntryButton.getText());
        entryList.add(entry);
        EntryListItemController itemController=new EntryListItemController(entry);
        entryFlowPlane.getChildren().add(itemController);
        listItemPink = !listItemPink;
        costTextField.clear();
        nameTextField.clear();
        categoryComboBox.valueProperty().set("Category");
        itemController.add(this);
    }


    /**
     * Confirms all the entries that the user has added, as an extra step to make sure that everything is right
     */
    @FXML
    private void submitEntries() {
        for (Entry entry : entryList) {
            entry.notifyEntryListeners();
        }
        entryFlowPlane.getChildren().clear();
        entryList.clear();
    }

    /**
     * informs the object that a change has happened in a class that it observes
     * @param s a string has been sent with the change
     */
    @Override
    public void update(String s) {
        savingCategory.add(s);
        if (currentActiveEntryButton == savingButton) {
            categoryComboBox.getItems().add(s);
        }
    }

    /**
     * Checks what category box is selected and fills it with the right info
     * @param b is the button that is active
     */
    private void checkCategoryBox(Button b) {
        categoryComboBox.getItems().clear();
        if (b == savingButton) {
            categoryComboBox.getItems().removeAll(expenceCategory);
            categoryComboBox.getItems().addAll(savingCategory);
        } else {
            categoryComboBox.getItems().removeAll(savingCategory);
            categoryComboBox.getItems().addAll(expenceCategory);
        }
    }


    @Override
    public void update(Entry entry, EntryListItemController controller) {
        entryList.remove(entry);
        entryFlowPlane.getChildren().remove(controller);
    }
}