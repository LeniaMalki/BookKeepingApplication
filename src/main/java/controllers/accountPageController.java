package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class accountPageController implements ChildPane {
    mainController parent;
    @FXML
    private AnchorPane headerAnchorPane;

    @FXML
    private ImageView editUsername;

    @FXML
    private ImageView editName;

    @FXML
    private ImageView editEmail;

    @FXML
    private Hyperlink changePasswordLink;

    @FXML
    private Hyperlink deleteAccountLink;

    @FXML
    private ImageView changeLanguage;

    private Hyperlink accountPage;

    @Override
    public void initPane(mainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }


}
