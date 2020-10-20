package Interfaces;

public interface iBudget {
    int getFoodCost();

    void setFoodCost(int foodCost);

    int getHouseholdCost();

    void setHouseholdCost(int householdCost);

    int getShoppingCost();

    void setShoppingCost(int shoppingCost);

    int getTransportCost();

    void setTransportCost(int transportCost);

    int getSavingsCost();

    void setSavingsCost(int savingsCost);

    int getOtherCost();

    void setOtherCost(int otherCost);

    String getIncome();

    void setIncome(String income);

    void notifyBudgetListeners();
}
