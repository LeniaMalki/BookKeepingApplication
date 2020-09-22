package Model;

import java.util.ArrayList;
import java.util.List;


public class Entry<T> implements EntrySubject{
    private List<NewEntryObserver> observers = new ArrayList<>();
    private T message;
    private boolean changed;

    double amout;
    String name;
    String category;
    String typeOfEntry;


    public Entry(double cost, String name, String category, String typeOfEntry) {
        this.amout = cost;
        this.name = name;
        this.category=category;
        this.typeOfEntry=typeOfEntry;
    }

    @Override
    public void register(NewEntryObserver obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
        if(!observers.contains(obj)) observers.add(obj);
    }

    @Override
    public void notifyObservers() {
        List<NewEntryObserver> observersLocal = null;
        if (!changed) return;

        observersLocal = new ArrayList<>(this.observers);
        this.changed=false;
        for (NewEntryObserver obj : observersLocal) {
            obj.update();
        }
    }

    public void submitOneEntry(T entry){
        this.message=entry;
        this.changed=true;
        notifyObservers();
    }

    @Override
    public Object getUpdate(NewEntryObserver obj) {
        return this.message;
    }

    public double getAmout() {
        return amout;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getTypeOfEntry() {
        return typeOfEntry;
    }

}