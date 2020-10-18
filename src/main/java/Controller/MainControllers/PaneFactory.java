package Controller.MainControllers;

import Controller.AccountControllers.*;
import Controller.BudgetControllers.BudgetChartPageController;
import Controller.BudgetControllers.BudgetPageController;
import Controller.EntryControllers.EntryPageController;
import Controller.GoalsControllers.GoalsPageController;
import Controller.StatisticsController.StatisticsDetailController;
import Controller.StatisticsController.StatisticsOverViewController;
import View.AccountView.*;
import View.EntryView.EntryView;
import View.GoalsView.GoalsView;
import View.BudgetView.BudgetChartView;
import View.BudgetView.BudgetView;
import View.StatisticsView.StatisticsDetailView;
import View.StatisticsView.StatisticsOverviewView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;


/**
 * A class that works as a factory for all the panes
 *
 * @author Oscar
 */
public class PaneFactory {

    //________________________________________________ VARIABLES _______________________________________________________

    private static MainController parent;

    //___________________________________-_____________ METHODS _______________________________________________________-

    /**
     * A generalized function for fetching root and controller from a function
     *
     * @param path a path to desired fx ml
     */
    private static <T> Pane<T> loadInPane(String path) {
        Pane<T> pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PaneFactory.class.getClassLoader().getResource(path));
            AnchorPane anchorPane = fxmlLoader.load();
            T controller = fxmlLoader.getController();
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
        Pane<MainController> pane = loadInPane("org/openjfx/mainAnchor.fxml");
        PaneFactory.parent = pane.controller;
        pane.controller.init();
        return pane.anchorPane;
    }

    public static AnchorPane initHeader() {
        Pane<HeaderController> pane = loadInPane("org/openjfx/header.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initLoginPane() {
        Pane<LogInView> pane = loadInPane("org/openjfx/logInPage.fxml");
        pane.controller.initPane(parent);
        LogInPageController logInPageController = new LogInPageController();
        return pane.anchorPane;
    }

    static AnchorPane initFirstPane() {
        Pane<HomePageController> pane = loadInPane("org/openjfx/firstPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initAccountPane() {
        Pane<ProfilePageView> pane = loadInPane("org/openjfx/accountPage.fxml");
        pane.controller.initPane(parent);
        ProfilePageController profilePageController = new ProfilePageController();
        return pane.anchorPane;
    }


    static AnchorPane initBudgetPane() {
        Pane<BudgetView> pane = loadInPane("org/openjfx/budgetPage.fxml");
        pane.controller.initPane(parent);
        BudgetPageController budgetPageController = new BudgetPageController();
        return pane.anchorPane;
    }

    static AnchorPane initSignUpPopUp() {
        Pane<SignUpView> pane = loadInPane("org/openjfx/signUpPopUp.fxml");
        pane.controller.initPane(parent);
        SignUpPageController signUpPageController = new SignUpPageController();
        return pane.anchorPane;
    }

    static AnchorPane initBudgetCharPane() {
        Pane<BudgetChartView> pane = loadInPane("org/openjfx/budgetCharPage.fxml");
        pane.controller.initPane(parent);
        BudgetChartPageController budgetCharPageController = new BudgetChartPageController();
        return pane.anchorPane;
    }

    static AnchorPane initEntryPane() {
        Pane<EntryView> pane = loadInPane("org/openjfx/entryPage.fxml");
        pane.controller.initPane(parent);
        EntryPageController pageController = new EntryPageController();
        return pane.anchorPane;
    }

    static AnchorPane initGoalsPane() {
        Pane<GoalsView> pane = loadInPane("org/openjfx/goalsPage.fxml");
        pane.controller.initPane(parent);
        GoalsPageController pageController = new GoalsPageController();
        return pane.anchorPane;
    }

    static AnchorPane initStatisticsDetailPane() {
        Pane<StatisticsDetailView> pane = loadInPane("org/openjfx/statisticsDetailPage.fxml");
        StatisticsDetailController statisticsDetailController = new StatisticsDetailController();
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initStatisticsOverviewPane() {
        Pane<StatisticsOverviewView> pane = loadInPane("org/openjfx/statisticsOverviewPage.fxml");
        pane.controller.initPane(parent);
        StatisticsOverViewController statisticsOverViewController = new StatisticsOverViewController();
        return pane.anchorPane;
    }

    static AnchorPane initDelAccPopup() {
        Pane<DeleteAccountView> pane = loadInPane("org/openjfx/deleteAccountPopUp.fxml");
        pane.controller.initPane(parent);
        DeleteAccountPopUpController deleteAccountView = new DeleteAccountPopUpController();
        return pane.anchorPane;
    }

    static AnchorPane initChangePasswordPopUp() {
        Pane<ChangePasswordView> pane = loadInPane("org/openjfx/changePasswordPopUp.fxml");
        pane.controller.initPane(parent);
        ChangePasswordPopUpController passwordPopUpController = new ChangePasswordPopUpController();
        return pane.anchorPane;
    }

    /**
     * A private class that let us store controllers and anchor panes as one.
     */
    static class Pane<T> {
        AnchorPane anchorPane;
        T controller;

        Pane(AnchorPane anchorPane, T controller) {
            this.anchorPane = anchorPane;
            this.controller = controller;
        }
    }
}