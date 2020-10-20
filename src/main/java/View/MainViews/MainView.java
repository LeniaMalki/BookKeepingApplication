package View.MainViews;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainView {

    static MainView mainView;
    public AnchorPane logInPage;
    public AnchorPane firstPage;
    public AnchorPane entryPage;
    public AnchorPane budgetPage;
    public AnchorPane budgetCharPage;
    public AnchorPane accountPage;
    public AnchorPane goalsPage;
    public AnchorPane signUpPopUp;
    public AnchorPane deleteAccountPopUp;
    public AnchorPane changePasswordPopUp;
    public AnchorPane detailStatistics;
    public AnchorPane overviewStatistics;
    @FXML
    public AnchorPane mainAnchor;

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;

    }

}
