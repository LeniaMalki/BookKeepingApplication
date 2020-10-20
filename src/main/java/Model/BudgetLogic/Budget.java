package Model.BudgetLogic;

import Interfaces.iBudget;
import Model.Interfaces.BudgetObserver;

public class Budget extends BudgetSubject implements iBudget {

    //________________________________________________ Variables  ______________________________________________________

    private int foodCost;
    private int householdCost;
    private int shoppingCost;
    private int transportCost;
    private int savingsCost;
    private int otherCost;
    private String income;

    //________________________________________________ Methods _________________________________________________________

    public Budget(int foodCost, int householdCost, int shoppingCost, int transportCost, int savingsCost, int otherCost, String income) {
        this.foodCost = foodCost;
        this.householdCost = householdCost;
        this.shoppingCost = shoppingCost;
        this.transportCost = transportCost;
        this.savingsCost = savingsCost;
        this.otherCost = otherCost;
        this.income = income;
    }

    //____________________________________________ GETTERS / SETTERS ___________________________________________________


    public int getFoodCost() {
        return this.foodCost;
    }

    public void setFoodCost(int foodCost) {
        this.foodCost = foodCost;
    }

    public int getHouseholdCost() {
        return this.householdCost;
    }

    public void setHouseholdCost(int householdCost) {
        this.householdCost = householdCost;
    }

    public int getShoppingCost() {
        return this.shoppingCost;
    }

    public void setShoppingCost(int shoppingCost) {
        this.shoppingCost = shoppingCost;
    }

    public int getTransportCost() {
        return this.transportCost;
    }

    public void setTransportCost(int transportCost) {
        this.transportCost = transportCost;
    }

    public int getSavingsCost() {
        return this.savingsCost;
    }

    public void setSavingsCost(int savingsCost) {
        this.savingsCost = savingsCost;
    }

    public int getOtherCost() {
        return this.otherCost;
    }

    public void setOtherCost(int otherCost) {
        this.otherCost = otherCost;
    }

    public String getIncome() {
        return this.income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    @Override
    public void notifyBudgetListeners() {
        for (BudgetObserver o : observers) {
            o.update(this);

        }
    }
}
