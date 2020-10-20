package View.StatisticsView;

import Controller.EntryControllers.EntryListItemController;
import View.EntryView.EntryListItemView;
import View.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class StatisticsDetailView implements iPane {

    //________________________________________________ VARIABLES _______________________________________________________

    static StatisticsDetailView statisticsDetailView;
    private MainController parent;

    @FXML
    public FlowPane flowpaneStat;

    @FXML
    public Text labelPieChart;

    @FXML
    public AnchorPane headerAnchorPane;

    @FXML
    public AnchorPane chartPane;

    @FXML
    public Button statisticsButtonShopping;

    @FXML
    public Button statisticsButtonFood;

    @FXML
    public Button statisticsButtonHousehold;

    @FXML
    public Button statisticsButtonTransport;

    @FXML
    public Button statisticsButtonOther;

    @FXML
    public Button statisticsButtonAllEntries;

    public PieChart chart;

    //_________________________________________________ METHODS ________________________________________________________


    public StatisticsDetailView(){
        statisticsDetailView = this;
    }

    public static StatisticsDetailView getInstance(){
        if(statisticsDetailView == null){
            statisticsDetailView = new StatisticsDetailView();
        }
        return statisticsDetailView;
    }

    public void setLabel(String text){
        labelPieChart.setText(text);

    }

    public void clearPane(){
        flowpaneStat.getChildren().clear();

    }

    public void removeEntryListItemView(EntryListItemView view){
        flowpaneStat.getChildren().remove(view);

    }

    public void addEntryListItemView(EntryListItemController controller){
        flowpaneStat.getChildren().add(controller.getView());

    }

    public void addToPieChart(){
        chartPane.getChildren().add(statisticsDetailView.chart);

    }

    @Override
    public void initPane(MainController parent) {
        this.parent=parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());


    }
}
