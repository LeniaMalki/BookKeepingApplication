package controllers;

import Model.Entry;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class NewGoalsInsertController {
    public NewGoalsInsertController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/GoalsInseet.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
