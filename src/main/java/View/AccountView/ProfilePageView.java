package View.AccountView;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ProfilePageView implements iPane {

    public static ProfilePageView profilePageView;
    @FXML
    public AnchorPane headerAnchorPane;
    @FXML
    public AnchorPane popUpPosition;
    @FXML
    public AnchorPane back;
    @FXML
    public TextField username;
    @FXML
    public TextField name;
    @FXML
    public TextField email;
    @FXML
    public Text textMessage;
    public MainController parent;
    @FXML
    public Hyperlink changePasswordLink;
    @FXML
    public Hyperlink deleteAccountLink;
    @FXML
    public Button submitChangesButton;
    @FXML
    public Button signOutButton;

    public ProfilePageView() {
        profilePageView = this;
    }

    public static ProfilePageView getInstance() {
        if (profilePageView == null) {
            profilePageView = new ProfilePageView();
        }
        return profilePageView;
    }

    @Override
    public void initPane(final MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

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
