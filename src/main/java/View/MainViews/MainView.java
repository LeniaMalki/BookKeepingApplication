package View.MainViews;

import Controller.MainControllers.MainController;
import View.Interfaces.iPane;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * @author : Oscar
 */

public class MainView implements iPane{

    static MainView mainView;
    public MainController parent;

    @FXML
    public AnchorPane logInPage;
    @FXML
    public AnchorPane firstPage;
    @FXML
    public AnchorPane entryPage;
    @FXML
    public AnchorPane budgetPage;
    @FXML
    public AnchorPane budgetCharPage;
    @FXML
    public AnchorPane accountPage;
    @FXML
    public AnchorPane goalsPage;
    @FXML
    public AnchorPane signUpPopUp;
    @FXML
    public AnchorPane deleteAccountPopUp;
    @FXML
    public AnchorPane changePasswordPopUp;
    @FXML
    public AnchorPane detailStatistics;
    @FXML
    public AnchorPane overviewStatistics;
    @FXML
    public AnchorPane mainAnchor;

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;

    }

    public MainView() {
        mainView = this;;
    }

    @Override
    public void initPane(MainController parent) {
        this.parent=parent;
    }
}
