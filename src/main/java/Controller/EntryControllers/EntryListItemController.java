package Controller.EntryControllers;

import Controller.Interfaces.RemoveItemObserver;
import Controller.Interfaces.RemoveItemSubject;
import Model.EntryLogic.Entry;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller for a new entry as a listItem
 *
 * @author Artin
 */
public class EntryListItemController extends AnchorPane implements RemoveItemSubject {

    @FXML
    Text articleName;

    @FXML
    Text categoryName;

    @FXML
    Text costName;

    Entry actualEntry;
    ArrayList<RemoveItemObserver> observers = new ArrayList<>();


    /**
     * Creates a new insert for a list and sets the test that is suppose to go in it
     * @param entry is a entry submitted by the user and is used to set the name/cost/category of the listItem
     */
    public EntryListItemController(Entry entry) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/entryPageScrollPaneInsert.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        categoryName.setText(entry.getCategory());
        costName.setText(String.valueOf(entry.getAmount()));
        articleName.setText(entry.getName());
        actualEntry = entry;

    }

    /**
     * A mouse event that updates the boolean parameter of the entry. All entries are created with boolean false.
     * When selected, the value turns to true.
     */
    @FXML
    private void selectEntry(MouseEvent event) {
        actualEntry.setSelected(!actualEntry.getSelected());
    }

    @FXML
    private void onTrashCanClick(){
        notifyListeners();
    }

    @Override
    public void add(RemoveItemObserver o) {
        observers.add(o);
    }
    @Override
    public void notifyListeners() {
    for(RemoveItemObserver o : observers){
        o.update(actualEntry, this);
    }
    }
}