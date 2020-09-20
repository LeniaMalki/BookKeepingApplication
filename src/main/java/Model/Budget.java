package Model;

public class Budget {

    private int foodCost;
    private int householdCost;
    private int shoppingCost;
    private int transportCost;
    private int savingsCost;
    private int otherCost;

    protected Budget() {
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

}
