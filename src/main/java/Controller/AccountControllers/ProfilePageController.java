package Controller.AccountControllers;//NOPMD

import Controller.Interfaces.ControllerInterface;
import Model.AccountLogic.AccountFacade;
import Model.Interfaces.AccountObserver;
import StairwayInterfaces.iAccountFacade;
import View.AccountView.ProfilePageView;

/**
 * @author : Lenia Malki
 * Responsibility: Updating the ProfilePageVIew through model
 * Used by: PaneFactory
 * Uses: ControllerInterface, iAccountFacade, ChangePasswordView
 */
public class ProfilePageController implements AccountObserver, ControllerInterface {
    //________________________________________________ VARIABLES _______________________________________________________
    private final iAccountFacade accountFacade = AccountFacade.getInstance();
    private final ProfilePageView profilePageView = ProfilePageView.getInstance();

    //________________________________________________ Methods _________________________________________________________

    /**
     * Constructor
     */
    public ProfilePageController() {
        accountFacade.add(this);
        setAllViewListeners();

    }

    /**
     * Sets all relevant profilePageView components to listeners
     */
    @Override
    public void setAllViewListeners() {
        profilePageView.submitChangesButton.setOnAction(e -> onSubmitChangesClicked());
        profilePageView.changePasswordLink.setOnAction(e -> openChangePasswordPop());
        profilePageView.signOutButton.setOnAction(e -> signOut());
        profilePageView.deleteAccountLink.setOnAction(e -> openDeleteAccountPop());

    }

    /**
     * Handles the account page fields name, username and email when an Account object has been created. Sets the
     * account page fields name, through delegation, username and email when an Account object has been created
     */
    @Override
    public void update() {
        profilePageView.username.setText(accountFacade.getAccountUsername());
        profilePageView.name.setText(accountFacade.getAccountName());
        profilePageView.email.setText(accountFacade.getAccountEmail());
    }

    /**
     * Handles color of "Submit Changes" button
     */
    private void onSubmitChangesClicked() {

        final int changesMade = accountFacade.handleAccountChanges(profilePageView.username.getText(),
                                                                   profilePageView.name.getText(),
                                                                   profilePageView.email.getText());

        if (changesMade == 0) {
            profilePageView.setMessage("No changes made");
        }
        if (changesMade > 0) {
            accountFacade.updateAccountFields(profilePageView.username.getText(), profilePageView.name.getText(),
                                              profilePageView.email.getText());
            profilePageView.setMessage("Changes saved!");
        }
        if (changesMade == 3) {
            profilePageView.setMessage("Incorrect input(s)!");

        }
    }

    /**
     * Handles the mouse action for when the delete account link is clicked on
     */
    private void openDeleteAccountPop() {
        profilePageView.openDeleteAccountPop();
    }

    /**
     * Handles the mouse action for when the change password  link is clicked on
     */
    private void openChangePasswordPop() {
        profilePageView.openChangePasswordPop();

    }

    /**
     * Handles the action when sign out is clicked
     */
    private void signOut() {
        profilePageView.parent.showLogInPage();
    }


}
