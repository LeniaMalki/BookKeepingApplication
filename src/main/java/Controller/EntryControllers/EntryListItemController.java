package Controller.EntryControllers;

import Controller.Interfaces.ControllerInterface;
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
public class EntryListItemController implements RemoveItemSubject, ControllerInterface {

    private final EntryListItemView entryListItemView = new EntryListItemView();
    private final Entry actualEntry;
    private final ArrayList<RemoveItemObserver> observers = new ArrayList<>();


    /**
     * Creates a new insert for a list and sets the test that is suppose to go in it
     *
     * @param entry is a entry submitted by the user and is used to set the name/cost/category of the listItem
     */
    public EntryListItemController(final Entry entry) {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/entryPageScrollPaneInsert.fxml"));
        fxmlLoader.setController(entryListItemView);
        fxmlLoader.setRoot(entryListItemView);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
        }
        setAllViewListeners();
        entryListItemView.setFields(entry.getCategory(), entry.getAmount(), entry.getName());
        actualEntry = entry;
    }

    @Override
    public void setAllViewListeners() {
        entryListItemView.trashcan.setOnAction(event -> notifyListeners());

    }

    @Override
    public void add(RemoveItemObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyListeners() {
        for (final RemoveItemObserver o : observers) {
            o.update(actualEntry, entryListItemView);
        }
    }

    public EntryListItemView getView() {
        return entryListItemView;
    }
}