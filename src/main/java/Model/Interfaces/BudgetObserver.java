package Model.Interfaces;

import Model.BudgetLogic.Budget;

public interface BudgetObserver {
    void update(Budget b);

}
