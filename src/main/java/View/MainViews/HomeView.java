package View.MainViews;

import Service.PaneFactory;
import View.Interfaces.iPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class HomeView implements iPane {
    /**
     * @author : Oscar Forsberg
     * Responsibility: In charge of displaying the page for the home page.
     * Used by: HomePageController, PaneFactory
     * Uses: iPane, JavaFX, MainView, PaneFactory
     */
    //________________________________________________ VARIABLES _______________________________________________________

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

    //______________________________________________ METHODS ___________________________________________________________
    /**
     * Constructor for MainView
     */
    public HomeView() {
        homeView = this;
    }

    /**
     * Singleton pattern for getting an instance of this class
     *
     * @return instance of view
     */
    public static HomeView getInstance() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;
    }

    /**
     * Method that shows the "EntryPage" of our program
     */
    public void loadEntryPage() {
        parent.showEntryPage();
    }

    /**
     * Method that shows the "BudgetPage" of our program
     */
    public void goToBudgetButton() {
        parent.showBudgetPage();
    }

    /**
     * Method that updates sliders depending on which category sent in
     * @param progress a double that is used to set our progress in a slider
     * @param category a String that decides which slider that will be updated
     */
    public void setProgressBar(final double progress, final String category) {
        switch (category) {
            case "Food" -> foodBar.setProgress(progress);
            case "Household" -> householdBar.setProgress(progress);
            case "Shopping" -> shoppingBar.setProgress(progress);
            case "Transport" -> transportBar.setProgress(progress);
            case "Other" -> otherbar.setProgress(progress);
        }
    }

    /**
     * Method that updates TextFields depending on which category sent in
     * @param amount a String that is used to set our amount in a TextField
     * @param category a String that decides which TextField that will be updated
     */
    public void setTextLabel(final String amount, final String category) {
        switch (category) {
            case "Food" -> foodLabel.setText(amount);
            case "Household" -> householdLabel.setText(amount);
            case "Shopping" -> shoppingLabel.setText(amount);
            case "Transport" -> transportLabel.setText(amount);
            case "Other" -> otherLabel.setText(amount);
        }
    }

    /**
     * initialized this pane and sets header
     * @param parent a MainView
     */
    @Override
    public void initPane(final MainView parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

}
