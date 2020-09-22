package Model;

import Model.observers.EntrySubject;

public class AccountMaker {

   private User user;

    public AccountMaker(User user) {
        this.user = user;
    }


    public static interface NewEntryObserver {

            //method to update the observer, used by subject
            public void update();

            //attach with subject to observe
            public void setSubject(EntrySubject sub);
        }
}
