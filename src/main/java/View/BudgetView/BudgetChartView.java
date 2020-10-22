package View.BudgetView;

import Service.PaneFactory;
import View.Interfaces.iPane;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class BudgetChartView implements iPane {

    static BudgetChartView budgetChartView;
    public MainView parent;
    @FXML
    public AnchorPane headerAnchorPane;
    @FXML
    public BarChart barChart;
    @FXML
    public AnchorPane rootAnchorPane;
    @FXML
    public CategoryAxis xAxis;
    @FXML
    public Button addNewBudgetButton;
    @FXML
    public Button editBudgetButton;

    public BudgetChartView() {
        budgetChartView = this;
    }

    public static BudgetChartView getInstance() {
        if (budgetChartView == null) {
            budgetChartView = new BudgetChartView();
        }
        return budgetChartView;
    }

    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    public void showBudgetPage() {
        parent.showBudgetPage();
    }

}
