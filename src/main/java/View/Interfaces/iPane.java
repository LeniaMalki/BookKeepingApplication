package View.Interfaces;

import View.MainViews.MainView;
/**
 * @author : Oscar Forsberg
 * Responsibility: An interface for all the panes that needs to be aware of the mainAnchor
 * Used by: ChangePasswordView, DeleteAccountView, LogInView, ProfilePageView, SignUpView, BudgetChartView,
 *          BudgetView, EntryView, GoalsView, HeaderView, HomeView, StatisticsDetailView, StatisticsOverviewView
 * Uses: MainView
 */
public interface iPane {
    void initPane(MainView parent);

}
