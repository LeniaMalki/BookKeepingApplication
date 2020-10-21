package Controller.Interfaces;

import StairwayInterfaces.iEntry;
import View.EntryView.EntryListItemView;

public interface RemoveItemObserver {
    void update(iEntry entry, EntryListItemView controller);
}
