package Model.Interfaces;

public interface EntryObserver {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(EntrySubject sub);
}