package View.AccountView;

import View.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Service.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
/**
 * @author : Lenia Malki
 * Responsibility: Holds the relevant JavaFX variables of the profile page and  methods directly related to it's view
 * Used by: ProfilePageController, PaneFactory, accountPage.fxml
 * Uses: iPane interface, MainController, JavaFX
 */
public class ProfilePageView implements iPane {

    //________________________________________________ Variables _______________________________________________________
    private static ProfilePageView profilePageView;
    @FXML
    private AnchorPane headerAnchorPane;
    @FXML
    private AnchorPane popUpPosition;
    @FXML
    private AnchorPane back;
    @FXML
    public TextField username;
    @FXML
    public TextField name;
    @FXML
    public TextField email;
    @FXML
    private Text textMessage;
    public MainController parent;
    @FXML
    public Hyperlink changePasswordLink;
    @FXML
    public Hyperlink deleteAccountLink;
    @FXML
    public Button submitChangesButton;
    @FXML
    public Button signOutButton;

    //---------------------------------------------------- METHODS -----------------------------------------------------
    /**
     * Constructor
     */
    public ProfilePageView() {
        profilePageView = this;
    }

    /**
     * Singleton pattern for getting an instance of this class
     * @return instance of view
     */
    public static ProfilePageView getInstance() {
        if (profilePageView == null) {
            synchronized (ProfilePageView.class){
            profilePageView = new ProfilePageView();}
        }
        return profilePageView;
    }

    /**
     * Initializes the pane
     * @param parent parent
     */
    @Override
    public void initPane(final MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    /**
     * Sets message on view
     * @param message obtained from controller
     */
    public void setMessage(final String message) {
        textMessage.setText(message);


    }

    /**
     * Handles the mouse action for when the delete account link is clicked on
     */
    public void openDeleteAccountPop() {
        popUpHandler();
        popUpPosition.getChildren().add(parent.getDeleteAccountPopUp());
    }

    /**
     * Handles the mouse action for when the change password  link is clicked on
     */
    public void openChangePasswordPop() {
        popUpHandler();
        popUpPosition.getChildren().add(parent.getChangePasswordPopUp());
    }

    /**
     * Handles image view for opening a pop up on account page
     */
    public void popUpHandler() {
        back.setVisible(true);
        popUpPosition.setVisible(true);
        popUpPosition.getChildren().clear();
        back.toFront();
        back.setStyle("-fx-background-color: #000000");
        back.setOpacity(0.5);
        popUpPosition.toFront();
    }

    /**
     * Graphic method to hide pop ups
     */
    @FXML
    private void hidePopUp() {
        back.setVisible(false);
        popUpPosition.setVisible(false);
        headerAnchorPane.toFront();
    }

}
