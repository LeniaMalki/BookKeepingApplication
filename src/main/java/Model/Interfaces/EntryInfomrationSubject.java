package Model.Interfaces;

import Controller.Interfaces.EntryInformationObserver;

import java.util.ArrayList;
import java.util.List;


    /**
     * The observer  interface
     * @author Artin
     */
    public interface EntryInfomrationSubject {
        List<EntryInformationObserver> informationObservers = new ArrayList<>();

        //methods to register observers

        /**
         * adds observers to a class that extends this
         * @param observer the observer that subscribes as a listener
         */
        static void add(EntryInformationObserver observer) {
            informationObservers.add(observer);
        }

        /**
         * Notifies all the observers that subscribe to an object that a change has happened
         */
        void notifyEntryListeners();


    }

