package Controller.EntryControllers;

import Controller.Interfaces.RemoveItemObserver;
import Model.EntryLogic.Entry;
import Model.Interfaces.SavingsObserver;
import Model.Interfaces.SavingsSubject;
import View.EntryView.EntryListItemView;
import View.EntryView.EntryView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Controller for the entry page
 *
 * @author Artin
 */

public class EntryPageController implements SavingsObserver, RemoveItemObserver {
    private final ArrayList<Button> entryButtonTypeCluster = new ArrayList<>();
    private final ArrayList<Entry> entryList = new ArrayList<>();
    private boolean listItemPink = false;

    private Button currentActiveEntryButton;
    EntryView entryView = EntryView.getInstance();

    public EntryPageController() {
        setAllViewLiseners();
        setValuesAtStart();
    }


    private void setAllViewLiseners() {
        entryView.expencesButton.setOnAction(this::activateEntryTypeButton);
        entryView.incomebutton.setOnAction(this::activateEntryTypeButton);
        entryView.savingButton.setOnAction(this::activateEntryTypeButton);
        entryView.addButton.setOnAction(e -> addEntry());
        entryView.submitButton.setOnAction(e -> submitEntries());
    }


    private ArrayList<String> savingCategory = new ArrayList<>() {{
        add("General Saving");
    }};
    private final ArrayList<String> expenceCategory = new ArrayList<>() {{
        add("Food");
        add("Household");
        add("Shopping");
        add("Transportation");
        add("Other");

    }};

    /**
     * sets the values that need to be added at the start of the program
     */
    private void setValuesAtStart() {
        entryButtonTypeCluster.add(entryView.expencesButton);
        entryButtonTypeCluster.add(entryView.savingButton);
        entryButtonTypeCluster.add(entryView.incomebutton);
        entryView.categoryComboBox.getItems().addAll(expenceCategory);
        currentActiveEntryButton = entryView.expencesButton;
        entryView.entryPageScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        SavingsSubject.observers.add(this);
    }

    /**
     * activates of deactivates the button that is pressed, this is for choosing the entry type
     *
     * @param event if something is pressed an ActionEvent is fired and tells the system what happened
     */
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
     *
     * @param btn the button that is clicked
     */
    private void incomeButtonAction(Button btn) {
        if (btn == entryView.incomebutton) {
            entryView.hideIncomeCategory();

        } else {
            entryView.showCategory();
        }
    }

    /**
     * Adds a new entry when the user has put in the right parameters and added
     */
    private void addEntry() {
        if (currentActiveEntryButton == entryView.incomebutton) {
            entryView.categoryComboBox.setValue("Income");
        }
        entryView.setRedColorIfInvalid(entryView.nameTextField, entryView.categoryComboBox, entryView.costTextField);
        if (checkIfFieldsAreFilledInCorrectly(entryView.nameTextField, entryView.categoryComboBox)) {

            try {
                Entry entry = new Entry(Double.parseDouble(entryView.costTextField.getText()), entryView.nameTextField.getText(), entryView.categoryComboBox.getValue(), currentActiveEntryButton.getText());
                entryList.add(entry);
                EntryListItemController itemController = new EntryListItemController(entry);
                entryView.entryFlowPlane.getChildren().add(itemController.getView());
                listItemPink = !listItemPink;
                entryView.costTextField.clear();
                entryView.nameTextField.clear();
                entryView.categoryComboBox.valueProperty().set("Category");
                itemController.add(this);
            } catch (Exception ignored) {
            }
        }
    }

    private boolean checkIfFieldsAreFilledInCorrectly(TextField nameTextField, ComboBox<String> categoryComboBox) {
        return checkIfCategoryIsFilledIn(categoryComboBox) && checkIfNameIsFilledIn(nameTextField);
    }

    private boolean checkIfNameIsFilledIn(TextField nameTextField) {
        return !nameTextField.getText().equals("");
    }

    private boolean checkIfCategoryIsFilledIn(ComboBox<String> categoryComboBox) {
        return categoryComboBox.getValue() != "" && categoryComboBox.getValue() != "Category";
    }

    /**
     * Confirms all the entries that the user has added, as an extra step to make sure that everything is right
     */
    private void submitEntries() {
        for (Entry entry : entryList) {
            entry.notifyEntryListeners();
        }
        entryView.entryFlowPlane.getChildren().clear();
        entryList.clear();
    }

    /**
     * informs the object that a change has happened in a class that it observes
     *
     * @param s a string has been sent with the change
     */
    @Override
    public void update(String s) {
        savingCategory.add(s);
        if (currentActiveEntryButton == entryView.savingButton) {
            entryView.categoryComboBox.getItems().add(s);
        }
    }

    /**
     * Checks what category box is selected and fills it with the right info
     *
     * @param b is the button that is active
     */
    private void checkCategoryBox(Button b) {
        entryView.categoryComboBox.getItems().clear();
        if (b == entryView.savingButton) {
            entryView.categoryComboBox.getItems().removeAll(expenceCategory);
            entryView.categoryComboBox.getItems().addAll(savingCategory);
        } else {
            entryView.categoryComboBox.getItems().removeAll(savingCategory);
            entryView.categoryComboBox.getItems().addAll(expenceCategory);
        }
    }

    @Override
    public void update(Entry entry, EntryListItemView controller) {
        entryList.remove(entry);
        entryView.entryFlowPlane.getChildren().remove(controller);
    }
}

