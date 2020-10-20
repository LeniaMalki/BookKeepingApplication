package View.MainViews;

import Controller.MainControllers.MainController;
import Model.PaneFactory;
import View.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeView implements iPane {

    private static HomeView homeView;
    @FXML
    public Button newEntryButton;
    @FXML
    public Button newBudgetButton;
    @FXML
    public AnchorPane headerAnchorPane;
    @FXML
    public ProgressBar foodBar;
    @FXML
    public ProgressBar householdBar;
    @FXML
    public ProgressBar shoppingBar;
    @FXML
    public ProgressBar transportBar;
    @FXML
    public ProgressBar otherbar;
    @FXML
    public Label foodLabel;
    @FXML
    public Label householdLabel;
    @FXML
    public Label shoppingLabel;
    @FXML
    public Label transportLabel;
    @FXML
    public Label otherLabel;
    private MainController parent;

    public static HomeView getInstance() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;

    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    @FXML
    public void loadEntryPage(ActionEvent event) throws IOException {
        parent.showEntryPage();
    }

    @FXML
    public void goToBudgetButton(ActionEvent event) throws IOException {
        parent.showBudgetPage();
    }


}
