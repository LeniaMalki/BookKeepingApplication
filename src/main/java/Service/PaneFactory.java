package Service;

import Controller.AccountControllers.*;
import Controller.BudgetControllers.BudgetChartPageController;
import Controller.BudgetControllers.BudgetPageController;
import Controller.EntryControllers.EntryPageController;
import Controller.GoalsControllers.GoalsPageController;
import Controller.MainControllers.HeaderController;
import Controller.MainControllers.HomePageController;
import Controller.MainControllers.MainController;
import Controller.StatisticsController.StatisticsDetailController;
import Controller.StatisticsController.StatisticsOverViewController;
import View.AccountView.*;
import View.BudgetView.BudgetChartView;
import View.BudgetView.BudgetView;
import View.EntryView.EntryView;
import View.GoalsView.GoalsView;
import View.MainViews.HeaderView;
import View.MainViews.HomeView;
import View.MainViews.MainView;
import View.StatisticsView.StatisticsDetailView;
import View.StatisticsView.StatisticsOverviewView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


/**
 * A class that works as a factory for all the panes
 * @author Oscar
 */
public class PaneFactory {

    //________________________________________________ VARIABLES _______________________________________________________

    public static MainController parent;

    //___________________________________-_____________ METHODS _______________________________________________________-

    /**
     * A generalized function for fetching root and controller from a function
     * @param path a path to desired fx ml
     */
    private static <T> Pane<T> loadInPane(final String path) {
        Pane<T> pane = null;
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader(PaneFactory.class.getClassLoader().getResource(path));
            final AnchorPane anchorPane = fxmlLoader.load();
            final T controller = fxmlLoader.getController();
            pane = new Pane<>(anchorPane, controller);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return pane;
    }

    /**
     * Down below are similar functions that loads in different panes using fxml files
     */
    public static Parent initMain() {
        final Pane <MainView> pane = loadInPane("org/openjfx/mainAnchor.fxml");
        PaneFactory.parent = new MainController();
        parent.init();
        return  pane.anchorPane;
    }

    public static AnchorPane initHeader() {
        final Pane<HeaderView> pane = loadInPane("org/openjfx/header.fxml");
        final HeaderController headerController = new HeaderController();
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    public static AnchorPane initLoginPane() {
        final Pane<LogInView> pane = loadInPane("org/openjfx/logInPage.fxml");
        pane.controller.initPane(parent);
        final LogInController logInController = new LogInController();
        return pane.anchorPane;
    }

    public static AnchorPane initFirstPane() {
        final Pane<HomeView> pane = loadInPane("org/openjfx/firstPage.fxml");
        pane.controller.initPane(parent);
        final HomePageController homePageController = new HomePageController();
        return pane.anchorPane;
    }

    public static AnchorPane initAccountPane() {
        final Pane<ProfilePageView> pane = loadInPane("org/openjfx/accountPage.fxml");
        pane.controller.initPane(parent);
        final ProfilePageController profilePageController = new ProfilePageController();
        return pane.anchorPane;
    }


    public static AnchorPane initBudgetPane() {
        final Pane<BudgetView> pane = loadInPane("org/openjfx/budgetPage.fxml");
        pane.controller.initPane(parent);
        final BudgetPageController budgetPageController = new BudgetPageController();
        return pane.anchorPane;
    }

    public static AnchorPane initSignUpPopUp() {
        final Pane<SignUpView> pane = loadInPane("org/openjfx/signUpPopUp.fxml");
        pane.controller.initPane(parent);
        final SignUpPageController signUpPageController = new SignUpPageController();
        return pane.anchorPane;
    }

    public static AnchorPane initBudgetCharPane() {
        final Pane<BudgetChartView> pane = loadInPane("org/openjfx/budgetCharPage.fxml");
        pane.controller.initPane(parent);
        final BudgetChartPageController budgetCharPageController = new BudgetChartPageController();
        return pane.anchorPane;
    }

    public static AnchorPane initEntryPane() {
        final Pane<EntryView> pane = loadInPane("org/openjfx/entryPage.fxml");
        pane.controller.initPane(parent);
        final EntryPageController pageController = new EntryPageController();
        return pane.anchorPane;
    }

    public static AnchorPane initGoalsPane() {
        final Pane<GoalsView> pane = loadInPane("org/openjfx/goalsPage.fxml");
        pane.controller.initPane(parent);
        final GoalsPageController pageController = new GoalsPageController();
        return pane.anchorPane;
    }

    public static AnchorPane initStatisticsDetailPane() {
        final Pane<StatisticsDetailView> pane = loadInPane("org/openjfx/statisticsDetailPage.fxml");
        final StatisticsDetailController statisticsDetailController = new StatisticsDetailController();
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    public static AnchorPane initStatisticsOverviewPane() {
        final Pane<StatisticsOverviewView> pane = loadInPane("org/openjfx/statisticsOverviewPage.fxml");
        pane.controller.initPane(parent);
        final StatisticsOverViewController statisticsOverViewController = new StatisticsOverViewController();
        return pane.anchorPane;
    }

    public static AnchorPane initDelAccPopup() {
        final Pane<DeleteAccountView> pane = loadInPane("org/openjfx/deleteAccountPopUp.fxml");
        pane.controller.initPane(parent);
        final DeleteAccountController deleteAccountView = new DeleteAccountController();
        return pane.anchorPane;
    }

    public static AnchorPane initChangePasswordPopUp() {
        final Pane<ChangePasswordView> pane = loadInPane("org/openjfx/changePasswordPopUp.fxml");
        pane.controller.initPane(parent);
        final PasswordEditController passwordPopUpController = new PasswordEditController();
        return pane.anchorPane;
    }

    /**
     * A private class that let us store controllers and anchor panes as one.
     */
    private static class Pane<T> {
        AnchorPane anchorPane;
        T controller;

        Pane(final AnchorPane anchorPane, final T controller) {
            this.anchorPane = anchorPane;
            this.controller = controller;
        }
    }
}