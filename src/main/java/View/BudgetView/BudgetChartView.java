package View.BudgetView;

import View.Interfaces.iPane;
import Service.PaneFactory;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class BudgetChartView implements iPane {

    /**
     * @author : viktoriawelzel
     * Responsibility: In charge of creating/ displaying the BudgetChartPage.
     * Uses: iPane
     */
    //________________________________________________ Variables _______________________________________________________

    public MainView parent;
    static BudgetChartView budgetChartView;

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

    //---------------------------------------------------- METHODS -----------------------------------------------------

    /**
     * initialized this pane.
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    /**
     * constructor.
     */
    public BudgetChartView(){
        budgetChartView = this;
    }

    /**
     * Method for obtaining the BudgetChartView instance.
     */
    public static BudgetChartView getInstance(){
        if (budgetChartView == null){
            budgetChartView = new BudgetChartView();
        }
        return budgetChartView;
    }

    /**
     * Shows the Budget Page.
     */
    public void showBudgetPage(){
        parent.showBudgetPage();
    }

}
