package Model;


import Model.Interfaces.EntryObserver;

public class Entry extends EntrySubject {

    double amout;
    final String name;
    final String category;
    final String typeOfEntry;


    public Entry(double cost, String name, String category, String typeOfEntry) {
        this.amout = cost;
        this.name = name;
        this.category = category;
        this.typeOfEntry = typeOfEntry;
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

    public Entry getEntry() {
        return this;
    }

    @Override
    public void notifyListeners() {
        for (EntryObserver observer : observers) {
            observer.update(this.getCategory(), this.getTypeOfEntry(), this.getAmout());
        }
    }
}