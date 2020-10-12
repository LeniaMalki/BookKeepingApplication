package Controller.Interfaces;

import Controller.EntryControllers.EntryListItemController;
import Model.EntryLogic.Entry;

public interface RemoveItemObserver {
    void update(Entry entry, EntryListItemController controller);
}
