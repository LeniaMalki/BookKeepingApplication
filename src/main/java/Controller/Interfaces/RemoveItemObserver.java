package Controller.Interfaces;

import Model.EntryLogic.Entry;
import View.EntryView.EntryListItemView;

public interface RemoveItemObserver {
    void update(Entry entry, EntryListItemView controller);
}
