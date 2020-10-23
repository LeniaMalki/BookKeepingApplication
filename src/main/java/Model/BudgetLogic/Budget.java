package Model.BudgetLogic;

import StairwayInterfaces.iBudget;
import Model.Interfaces.BudgetObserver;
import Model.Interfaces.BudgetSubject;

/**
 * @author : viktoriawelzel
 * Responsibility: A class creates budgets with the information that is inputted by the client
 * Uses: iBudget, BudgetSubject
 */
public class Budget implements iBudget, BudgetSubject {

    //________________________________________________ Variables  ______________________________________________________

    private int foodCost;
    private int householdCost;
    private int shoppingCost;
    private int transportCost;
    private int savingsCost;
    private int otherCost;
    private String income;

    //________________________________________________ Methods _________________________________________________________

    /**
     * Constructor that initializes a new budget object.
     * @param foodCost amount of spend on food
     * @param householdCost amount of spend on household
     * @param shoppingCost amount of spend on shopping
     * @param transportCost amount of spend on transport
     * @param savingsCost amount of spend on savings
     * @param otherCost amount of spend on other
     * @param income amount of income
     */
    public Budget(final int foodCost, final int householdCost, final int shoppingCost, final int transportCost,
                  final int savingsCost, final int otherCost, final String income) {
        this.foodCost = foodCost;
        this.householdCost = householdCost;
        this.shoppingCost = shoppingCost;
        this.transportCost = transportCost;
        this.savingsCost = savingsCost;
        this.otherCost = otherCost;
        this.income = income;
    }

    //_________________________________________________ METHODS ________________________________________________________

    /**
     * Notifies all the observers of the object
     */
    @Override
    public void notifyBudgetListeners() {
        for (final BudgetObserver o : observers) {
            o.update(this);

        }
    }

    //____________________________________________ GETTERS / SETTERS ___________________________________________________


    public int getFoodCost() {
        return this.foodCost;
    }

    public void setFoodCost(final int foodCost) {
        this.foodCost = foodCost;
    }

    public int getHouseholdCost() {
        return this.householdCost;
    }

    public void setHouseholdCost(final int householdCost) {
        this.householdCost = householdCost;
    }

    public int getShoppingCost() {
        return this.shoppingCost;
    }

    public void setShoppingCost(final int shoppingCost) {
        this.shoppingCost = shoppingCost;
    }

    public int getTransportCost() {
        return this.transportCost;
    }

    public void setTransportCost(final int transportCost) {
        this.transportCost = transportCost;
    }

    public int getSavingsCost() {
        return this.savingsCost;
    }

    public void setSavingsCost(final int savingsCost) {
        this.savingsCost = savingsCost;
    }

    public int getOtherCost() {
        return this.otherCost;
    }

    public void setOtherCost(final int otherCost) {
        this.otherCost = otherCost;
    }

    public String getIncome() {
        return this.income;
    }

    public void setIncome(final String income) {
        this.income = income;
    }

}
