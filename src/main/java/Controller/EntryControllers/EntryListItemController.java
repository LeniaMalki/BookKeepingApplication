package Controller.EntryControllers;

import Controller.Interfaces.RemoveItemObserver;
import Controller.Interfaces.RemoveItemSubject;
import Model.EntryLogic.Entry;
import View.EntryView.EntryListItemView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller for a new entry as a listItem
 *
 * @author Artin
 */
public class EntryListItemController implements RemoveItemSubject {

    EntryListItemView entryListItemView = new EntryListItemView();
    Entry actualEntry;
    ArrayList<RemoveItemObserver> observers = new ArrayList<>();


    /**
     * Creates a new insert for a list and sets the test that is suppose to go in it
     *
     * @param entry is a entry submitted by the user and is used to set the name/cost/category of the listItem
     */
    public EntryListItemController(Entry entry) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/entryPageScrollPaneInsert.fxml"));
        fxmlLoader.setController(entryListItemView);
        fxmlLoader.setRoot(entryListItemView);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        setAllViewLiseners();
        entryListItemView.setFields(entry.getCategory(), entry.getAmount(), entry.getName());
        actualEntry = entry;
    }

    private void setAllViewLiseners() {
        entryListItemView.trashcan.setOnAction(event -> notifyListeners());

    }

    @Override
    public void add(RemoveItemObserver o) {
        observers.add(o);
    }

    @Override
    public void notifyListeners() {
        for (RemoveItemObserver o : observers) {
            o.update(actualEntry, entryListItemView);
        }
    }

    public EntryListItemView getView() {
        return entryListItemView;
    }
}