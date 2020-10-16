package View.EntryView;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import Controller.MainControllers.PaneFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;


public class EntryView implements iPane {

    @FXML
    public Button submitButton;
    @FXML
    public Button addButton;
    @FXML
    public Button expencesButton;
    @FXML
    public Button incomebutton;
    @FXML
    public Button savingButton;
    @FXML
    public TextField nameTextField;
    @FXML
    public ComboBox<String> categoryComboBox;
    @FXML
    public TextField costTextField;
    @FXML
    public ScrollPane entryPageScrollPane;
    @FXML
    public FlowPane entryFlowPlane;
    @FXML
    public AnchorPane headerAnchorPane;

    private MainController parent;
    static EntryView entryView;

    public EntryView() {
        entryView = this;
    }

    /**
     * Method for obtaining the EntryView instance. Handles the creation of a new account object.
     */
    public static EntryView getInstance() {
        if (entryView == null) {
            entryView = new EntryView();
        }
        return entryView;
    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
        headerAnchorPane.getChildren().setAll(PaneFactory.initHeader());
    }

    public void hideIncomeCategory() {
        categoryComboBox.setVisible(false);
        costTextField.setLayoutY(282);
    }

    public void showCategory() {
        entryView.categoryComboBox.setVisible(true);
        entryView.costTextField.setLayoutY(391);
    }

    public void setRedColorIfInvalid(TextField nameTextField, ComboBox<String> categoryComboBox, TextField costTextField) {
        if (nameTextField.getText().equals("")) {
            nameTextField.setStyle("-fx-text-box-border: Red;");
        } else nameTextField.setStyle("-fx-text-box-border: Grey;");
        if (categoryComboBox.getValue() == "" || categoryComboBox.getValue() == "Category" || categoryComboBox.getValue() == null) {
            categoryComboBox.setStyle(" -fx-border-color: Red;");
        } else categoryComboBox.setStyle("-fx-text-box-border: Grey;");
        if (!costTextField.getText().matches("\\d+")) {
            costTextField.setStyle(" -fx-border-color: Red;");
        } else costTextField.setStyle(" -fx-border-color: Gray;");
    }
}
