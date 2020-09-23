package controllers;

import Model.Entry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class EntryListItemController extends AnchorPane {


    @FXML
     Text articleName;

    @FXML
     Text categoryName;

    @FXML
     Text costName;
    MainController parent;


    public EntryListItemController(Entry entry, boolean pinkColor) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/entryPageScrollPaneInsert.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        categoryName.setText(entry.getCategory());
        costName.setText(String.valueOf(entry.getAmout()));
        articleName.setText(entry.getName());
        if (pinkColor){
            this.getStyleClass().add("pinkInsert");
        }
    }



}