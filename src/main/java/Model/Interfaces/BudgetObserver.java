package Model.Interfaces;

import Model.BudgetLogic.Budget;
import Model.BudgetLogic.BudgetSubject;
import Model.EntryLogic.Entry;

public interface BudgetObserver {
    void update(Budget b);

}
