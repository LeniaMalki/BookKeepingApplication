package View.MainViews;

import Service.PaneFactory;
import View.Interfaces.iPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeView implements iPane {

    static HomeView homeView;
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
    private MainView parent;

    public static HomeView getInstance() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;

    }

    public HomeView() {
        homeView = this;
    }

    @Override
    public void initPane(MainView parent) {
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

    public void setProgressBarFood(int progress) {
        foodBar.setProgress(progress);

    }

    public void setProgressBarHousehold(int progress) {
        householdBar.setProgress(progress);

    }

    public void setProgressBarTransport(int progress) {
        transportBar.setProgress(progress);

    }

    public void setProgressBarShopping(int progress) {
        shoppingBar.setProgress(progress);

    }

    public void setProgressBarOther(int progress) {
        otherbar.setProgress(progress);

    }

    public void setTextLabelFood(String string) {
        foodLabel.setText(string);
    }

    public void setTextLabelShopping(String string) {
        shoppingLabel.setText(string);
    }

    public void setTextLabelTransport(String string) {
        transportLabel.setText(string);
    }

    public void setTextLabelHousehold(String string) {
        householdLabel.setText(string);
    }

    public void setTextLabelOther(String string) {
        otherLabel.setText(string);
    }
}
