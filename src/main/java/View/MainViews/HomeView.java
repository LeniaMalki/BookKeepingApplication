package View.MainViews;

import Service.PaneFactory;
import View.Interfaces.iPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

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

    public HomeView() {
        homeView = this;
    }

    public static HomeView getInstance() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;

    }

    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    @FXML
    public void loadEntryPage() {
        parent.showEntryPage();
    }

    @FXML
    public void goToBudgetButton() {
        parent.showBudgetPage();
    }

    public void setProgressBar(final double progress, final String category) {
        switch (category) {
            case "Food" -> foodBar.setProgress(progress);
            case "Household" -> householdBar.setProgress(progress);
            case "Shopping" -> shoppingBar.setProgress(progress);
            case "Transport" -> transportBar.setProgress(progress);
            case "Other" -> otherbar.setProgress(progress);
        }
    }

    public void setTextLabel(final String amount, final String category) {
        switch (category) {
            case "Food" -> foodLabel.setText(amount);
            case "Household" -> householdLabel.setText(amount);
            case "Shopping" -> shoppingLabel.setText(amount);
            case "Transport" -> transportLabel.setText(amount);
            case "Other" -> otherLabel.setText(amount);
        }
    }


}
