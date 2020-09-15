package controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class detailStatisticsController implements ChildPane {

        mainController parent;

        @FXML
        private ScrollPane statisticsScrollPane;

        @FXML
        private Button statisticsButtonFood;

        @FXML
        private Button statisticsButtonHousehold;

        @FXML
        private Button statisticsButtonOther;

        @FXML
        private Button statisticsButtonShopping;

        @FXML
        private Button statisticsButtonTransport;

        @FXML
        private Text labelPieChart;

        @FXML
        private AnchorPane headerAnchorPane;


        @Override
        public void initPane(mainController parent) {
                this.parent=parent;
                headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
        }
}
