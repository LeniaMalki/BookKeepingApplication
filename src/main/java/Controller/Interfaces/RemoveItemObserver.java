package Controller.Interfaces;

import Interfaces.iEntry;
import View.EntryView.EntryListItemView;

public interface RemoveItemObserver {
    void update(iEntry entry, EntryListItemView controller);
}
