package Controller.EntryControllers;

import Controller.Interfaces.ControllerInterface;
import Controller.Interfaces.RemoveItemObserver;
import Controller.Interfaces.RemoveItemSubject;
import Model.EntryLogic.Entry;
import Model.Interfaces.SavingsObserver;
import Model.Interfaces.SavingsSubject;
import StairwayInterfaces.iEntry;
import View.EntryView.EntryListItemView;
import View.EntryView.EntryView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Controller for the entry page view
 * Responsibility: Updates and handles the EntryView
 * Used by: PaneFactory
 *
 * @author Artin
 */

public class EntryPageController implements SavingsObserver, RemoveItemObserver, ControllerInterface {

    private final ArrayList<Button> entryButtonTypeCluster = new ArrayList<>();
    private final ArrayList<iEntry> entryList = new ArrayList<>();
    private Button currentActiveEntryButton;
    private final EntryView entryView = EntryView.getInstance();
    private final ArrayList<String> savingCategory = new ArrayList<>() {{
        add("General Saving");
    }};
    private final ArrayList<String> expenceCategory = new ArrayList<>() {{
        add("Food");
        add("Household");
        add("Shopping");
        add("Transportation");
        add("Other");
    }};

    //________________________________________________ Methods _________________________________________________________


    public EntryPageController() {
        setAllViewListeners();
        setValuesAtStart();
    }

    /**
     * activates of deactivates the button that is pressed, this is for choosing the entry type
     *
     * @param event if something is pressed an ActionEvent is fired and tells the system what happened
     */
    private void activateEntryTypeButton(ActionEvent event) {
        final Button btn = (Button) event.getSource();
        for (final Button b : entryButtonTypeCluster) {
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
        setColorRedIfInvalid(entryView.nameTextField, entryView.categoryComboBox, entryView.costTextField);

        if (checkIfFieldsAreFilledInCorrectly(entryView.nameTextField, entryView.categoryComboBox, entryView.costTextField)) {
            try {
                final iEntry entry = new Entry(Double.parseDouble(entryView.costTextField.getText()), entryView.nameTextField.getText(), entryView.categoryComboBox.getValue(), currentActiveEntryButton.getText());
                entryList.add(entry);
                final EntryListItemController itemController = new EntryListItemController(entry);
                entryView.entryFlowPlane.getChildren().add(itemController.getView());
                entryView.costTextField.clear();
                entryView.nameTextField.clear();
                entryView.categoryComboBox.valueProperty().set("Category");
                RemoveItemSubject.add(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * Sets the color of things to red if they have an invalid input
     *
     * @param nameTextField    textfield with string input
     * @param categoryComboBox combobox with string inputs
     * @param costTextField    textfield with double inputs
     */

    private void setColorRedIfInvalid(TextField nameTextField, ComboBox<String> categoryComboBox, TextField costTextField) {

        if (!checkIfNameIsFilledIn(nameTextField)) {
            entryView.setRedColor(nameTextField);
        } else {
            entryView.setGreyColor(nameTextField);
        }

        if (checkIfCategoryIsFilledIninCorrectly(categoryComboBox)) {
            entryView.setRedColor(categoryComboBox);
        } else {
            entryView.setGreyColor(categoryComboBox);
        }

        if (checkIfCostIsInCorrect(costTextField)) {
            entryView.setRedColor(costTextField);
        } else {
            entryView.setGreyColor(costTextField);
        }
    }

    /**
     * checks if all fields are filled in correctly
     *
     * @param nameTextField    textfield with string input
     * @param categoryComboBox combobox with string inputs
     * @param costTextField    textfield with double inputs
     * @return true iff all firlds are correct
     */

    private boolean checkIfFieldsAreFilledInCorrectly(TextField nameTextField, ComboBox<String> categoryComboBox, TextField costTextField) {
        return !checkIfCategoryIsFilledIninCorrectly(categoryComboBox) && checkIfNameIsFilledIn(nameTextField) && !checkIfCostIsInCorrect(costTextField);
    }

    /**
     * checks if costfield is incorrect
     *
     * @param costTextField textfield with double inputs
     * @return true if it doesnt match
     */
    private boolean checkIfCostIsInCorrect(TextField costTextField) {
        return !costTextField.getText().matches("\\d+");
    }

    /**
     * checks if name is filled in
     *
     * @param nameTextField textfield with string input
     * @return returns true if it has any symbol in it
     */
    private boolean checkIfNameIsFilledIn(TextField nameTextField) {
        return !nameTextField.getText().equals("");
    }

    /**
     * checks if fields are incorrect
     *
     * @param categoryComboBox combobox with string inputs
     * @return true if they are incorrect
     */
    private boolean checkIfCategoryIsFilledIninCorrectly(ComboBox<String> categoryComboBox) {
        return (categoryComboBox.getValue() == "" || categoryComboBox.getValue() == "Category" || categoryComboBox.getValue() == null);
    }

    /**
     * Confirms all the entries that the user has added, as an extra step to make sure that everything is right
     */
    private void submitEntries() {
        for (final iEntry entry : entryList) {
            entry.notifyEntryListeners();
        }
        entryView.entryFlowPlane.getChildren().clear();
        entryList.clear();
    }

    /**
     * informs the object that a change has happened in a class that it observes
     *
     * @param string a string has been sent with the change
     */
    @Override
    public void update(String string) {
        savingCategory.add(string);
        if (currentActiveEntryButton == entryView.savingButton) {
            entryView.categoryComboBox.getItems().add(string);
        }
    }


    /**
     * Checks what category box is selected and fills it with the right info
     *
     * @param button is the button that is active
     */
    private void checkCategoryBox(Button button) {
        entryView.categoryComboBox.getItems().clear();
        if (button == entryView.savingButton) {
            entryView.categoryComboBox.getItems().removeAll(expenceCategory);
            entryView.categoryComboBox.getItems().addAll(savingCategory);
        } else {
            entryView.categoryComboBox.getItems().removeAll(savingCategory);
            entryView.categoryComboBox.getItems().addAll(expenceCategory);
        }
    }

    @Override
    public void update(iEntry entry, EntryListItemView controller) {
        entryList.remove(entry);
        entryView.entryFlowPlane.getChildren().remove(controller);
    }

    //---------------------------------------------------- GETTERS/SETTERS -----------------------------------------------------


    /**
     * makes it so that the controller listens after actions from the view
     */
    @Override
    public void setAllViewListeners() {
        entryView.expencesButton.setOnAction(this::activateEntryTypeButton);
        entryView.incomebutton.setOnAction(this::activateEntryTypeButton);
        entryView.savingButton.setOnAction(this::activateEntryTypeButton);
        entryView.addButton.setOnAction(e -> addEntry());
        entryView.submitButton.setOnAction(e -> submitEntries());
    }

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
}

