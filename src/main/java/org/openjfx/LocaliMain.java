package org.openjfx;

import Controller.MainControllers.PaneFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LocaliMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(PaneFactory.initMain(), 1440, 1024);
        stage.setTitle("Locali");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);




    }

}
