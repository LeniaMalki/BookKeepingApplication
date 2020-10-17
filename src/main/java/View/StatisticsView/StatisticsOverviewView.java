package View.StatisticsView;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class StatisticsOverviewView implements iPane {
    MainController parent;
    static StatisticsOverviewView statisticsOverviewView;
    @FXML
    public AnchorPane dailyAnchor;

    @FXML
    public AnchorPane weeklyAnchor;

    @FXML
    public AnchorPane monthlyAnchor;

    @FXML
    public AnchorPane headerAnchorPane;

    @FXML
    public Button toDailyStatistics;

    @FXML
    public Button toWeeklyStatistics;

    @FXML
    public Button toMonthlyStatistics;

    public StatisticsOverviewView(){
        statisticsOverviewView=this;
    }

    public static StatisticsOverviewView getInstance(){
        if(statisticsOverviewView==null){
            statisticsOverviewView = new StatisticsOverviewView();
        }
        return statisticsOverviewView;
    }

    public void showDetailStatisticsPage(String text){
        parent.showStatisticsDetailPage(text);
    }

    @Override
    public void initPane(MainController parent) {
        this.parent=parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());

    }




    /*
    /**
     * Initializes the pane when the program starts also adds the header
     * @param parent is the main controller
     */
    /*@Override
    public void initPane(MainController parent) {
        this.parent = parent;
        EntrySubject.add(this);
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }*/
}
