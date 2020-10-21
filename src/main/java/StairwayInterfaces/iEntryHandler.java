package StairwayInterfaces;

import java.util.List;

public interface iEntryHandler {
    double getFoodAmount();

    double getTransportationAmount();

    double getHouseholdAmount();

    double getShoppingAmount();

    double getOtherAmount();

    double getGeneralSaving();

    List<iEntry> getEntries();

    void updateTotalCategoryValues();


}
