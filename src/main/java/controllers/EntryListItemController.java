package controllers;

import Model.Entry;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class EntryListItemController  extends AnchorPane {

    @FXML
    private AnchorPane scrolPaneInsert;

    @FXML
    private Text articleName;

    @FXML
    private Text categoryName;

    @FXML
    private Text costName;

    public EntryListItemController(Entry entry) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("entryPageScrollPaneInsert.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        articleName.setText(entry.getName());
        categoryName.setText(entry.getName());
        costName.setText(String.valueOf(entry.getAmout()));
    }
}