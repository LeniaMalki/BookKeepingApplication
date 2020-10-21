package Controller.EntryControllers;

import Controller.Interfaces.ControllerInterface;
import Controller.Interfaces.RemoveItemObserver;
import Controller.Interfaces.RemoveItemSubject;
import StairwayInterfaces.iEntry;
import View.EntryView.EntryListItemView;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Controller for a new entry as a listItem
 * Responsibility: Create an insert with information about an entry
 * Used by: EntryPageController and StatisticsDetailController
 *
 * @author Artin
 */
public class EntryListItemController implements RemoveItemSubject, ControllerInterface {

    private final EntryListItemView entryListItemView = new EntryListItemView();
    private final iEntry actualEntry;

    //________________________________________________ Methods _________________________________________________________

    /**
     * Creates a new insert for a list and sets the test that is suppose to go in it
     *
     * @param entry is a entry submitted by the user and is used to set the name/cost/category of the listItem
     */
    public EntryListItemController(final iEntry entry) {
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

    /**
     * notifies all the observers that something has happened
     */
    @Override
    synchronized public void notifyListeners() {
        for (RemoveItemObserver o : observers) {
            o.update(actualEntry, entryListItemView);
        }
    }

    //---------------------------------------------------- GETTERS/SETTERS -----------------------------------------------------

    /**
     * gets the view
     *
     * @return returns an instance of the view
     */
    public EntryListItemView getView() {
        return entryListItemView;
    }

    /**
     * makes it so that the controller listens after actions from the view
     */
    @Override
    public void setAllViewListeners() {
        entryListItemView.trashcan.setOnAction(event -> notifyListeners());

    }
}