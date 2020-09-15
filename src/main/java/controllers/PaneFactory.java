package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


/**
 * A class that works as a factory for all the panes
 *
 * @author Oscar
 */
public class PaneFactory {
    private static mainController parent;

    /**
     * A private class that makes us let us store controllers and anchor panes as one.
     */
    static class Pane<T> {
        AnchorPane anchorPane;
        T controller;

        Pane(AnchorPane anchorPane, T controller) {
            this.anchorPane = anchorPane;
            this.controller = controller;
        }
    }

    /**
     * A generalized function for fetching root and controller from a function
     *
     * @param path a path to desired fxml
     */
    private static <T> Pane<T> loadInPane(String path) {
        Pane<T> pane = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(PaneFactory.class.getClassLoader().getResource(path));
            AnchorPane anchorPane = fxmlLoader.load();
            T controller = fxmlLoader.getController();
            pane = new Pane<T>(anchorPane, controller);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return pane;
    }

    // Create page
    public static Parent initMain(){
        Pane<mainController> pane = loadInPane("org/openjfx/mainAnchor.fxml");
        PaneFactory.parent = pane.controller;
        pane.controller.init();
        return pane.anchorPane;
    }

    static AnchorPane initLoginPane() {
        Pane<logInPageController> pane = loadInPane("org/openjfx/logInPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initFirstPane() {
        Pane<firstPageController> pane = loadInPane("org/openjfx/firstPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initAccountPane() {
        Pane<accountPageController> pane = loadInPane("org/openjfx/accountPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initBudgetPane() {
        Pane<budgetPageController> pane = loadInPane("org/openjfx/budgetPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initBudgetCharPane() {
        Pane<budgetCharPageController> pane = loadInPane("org/openjfx/budgetCharPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initEntryPane() {
        Pane<entryPageController> pane = loadInPane("org/openjfx/entryPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initHeader() {
        Pane<headerController> pane = loadInPane("org/openjfx/header.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static AnchorPane initStatisticsOverviewPane() {
        Pane<overViewStatisticsController> pane = loadInPane("org/openjfx/statisticsOverviewPage.fxml");
        pane.controller.initPane(parent);
        return pane.anchorPane;
    }

    static Pane<detailStatisticsController> initStatisticsDetailPane() {
        Pane<detailStatisticsController> pane = loadInPane("org/openjfx/statisticsDetailPage.fxml");
        pane.controller.initPane(parent);
        return pane;
    }

    static AnchorPane initDelAccPopup(){
        Pane<deleteAccountPopUpController> pane = loadInPane("org/openjfx/deleteAccountPopUp.fxml");
        return pane.anchorPane;
    }
}

