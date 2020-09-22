package controllers;

import Model.Entry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EntryListItemController extends AnchorPane {

    @FXML
     AnchorPane scrollPaneInsert;

    @FXML
     Text articleName;

    @FXML
     Text categoryName;

    @FXML
     Text costName;
    mainController parent;


    @FXML
    private void loadEntryPage(ActionEvent event) throws IOException {
        parent.showEntryPage();
    }

    public EntryListItemController(Entry entry) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("org/openjfx/entryPageScrollPaneInsert.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.articleName.setText(entry.getName());
        categoryName.setText(entry.getCategory());
        costName.setText(String.valueOf(entry.getAmout()));

    }



}