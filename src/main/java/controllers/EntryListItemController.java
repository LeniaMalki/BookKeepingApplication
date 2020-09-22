package controllers;

import Model.Entry;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EntryListItemController  extends AnchorPane implements Initializable {

    @FXML
    private AnchorPane scrolPaneInsert;

    @FXML
    private Text articleName;

    @FXML
    private Text categoryName;

    @FXML
    private Text costName;

    public EntryListItemController(Entry entry) {
        articleName.setText(entry.getName());
        categoryName.setText(entry.getCategory());
        costName.setText(String.valueOf(entry.getAmout()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("entryPageScrollPaneInsert.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}