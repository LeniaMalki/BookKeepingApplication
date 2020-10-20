package View.BudgetView;

import View.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class BudgetChartView implements iPane {

    public MainController parent;
    private static BudgetChartView budgetChartView;

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    public BudgetChartView(){
        budgetChartView = this;
    }

    public static BudgetChartView getInstance(){
        if (budgetChartView == null){
            budgetChartView = new BudgetChartView();
        }
        return budgetChartView;
    }

    public void showBudgetPage(){
        parent.showBudgetPage();
    }

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

}
