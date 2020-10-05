package Model;

public class Budget {

    private int foodCost = 0;
    private int householdCost = 0;
    private int shoppingCost = 0;
    private int transportCost = 0;
    private int savingsCost = 0;
    private int otherCost = 0;
    private int income = 0;

    protected Budget(/*int foodCost, int householdCost, int shoppingCost, int transportCost, int savingsCost, int otherCost, int income*/) {
        /*this.foodCost = foodCost;
        this.householdCost = householdCost;
        this.shoppingCost = shoppingCost;
        this.transportCost = transportCost;
        this.savingsCost = savingsCost;
        this.otherCost = otherCost;
        this.income = income;*/
    }

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

    public int getIncome() {
        return this.income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

}
