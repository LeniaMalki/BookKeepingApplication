package View.StatisticsView;

import Controller.EntryControllers.EntryListItemController;
import View.EntryView.EntryListItemView;
import View.Interfaces.iPane;
import Service.PaneFactory;
import View.MainViews.MainView;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 * @author : Oscar Forsberg
 * Responsibility: In charge of displaying the page for the detail statistics page.
 * Used by: StatisticsDetailController, PaneFactory
 * Uses: iPane, JavaFX, MainView, PaneFactory
 */
public class StatisticsDetailView implements iPane {
    //________________________________________________ VARIABLES _______________________________________________________

    static StatisticsDetailView statisticsDetailView;
    private MainView parent;

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

    /**
     * Constructor
     */
    public StatisticsDetailView(){
        statisticsDetailView = this;
    }
    /**
     * Singleton pattern for getting an instance of this class
     * @return instance of view
     */
    public static StatisticsDetailView getInstance(){
        if(statisticsDetailView == null){
            statisticsDetailView = new StatisticsDetailView();
        }
        return statisticsDetailView;
    }
    /**
     * Sets a label
     * @param text that the label will be set to
     */
    public void setLabel(final String text){
        labelPieChart.setText(text);

    }
    /**
     * Method that clears a flowpane
     */
    public void clearPane(){
        flowpaneStat.getChildren().clear();

    }
    /**
     * Method that removes an EntryListItemView from the FlowPane
     * @param view an entry the user has submited
     */
    public void removeEntryListItemView(final EntryListItemView view){
        flowpaneStat.getChildren().remove(view);

    }
    /**
     * Method that adds an EntryListItemController to the FlowPane
     * @param controller an EntryListItemController
     */
    public void addEntryListItemView(final EntryListItemController controller){
        flowpaneStat.getChildren().add(controller.getView());

    }

    /**
     * Method that lays a PieChart on top of an AnchorPane
     */
    public void addToPieChart(){
        chartPane.getChildren().add(statisticsDetailView.chart);

    }

    /**
     * initialized this pane and sets header
     * @param parent a MainView
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent=parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());


    }
}
