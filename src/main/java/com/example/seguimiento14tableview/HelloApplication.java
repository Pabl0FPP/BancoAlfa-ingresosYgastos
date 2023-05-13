package com.example.seguimiento14tableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        openWindows("hello-view.fxml");

    }

    public static void openWindows(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage =new Stage();
            stage.setTitle("Banco Alfa");
            stage.setScene(scene);
            stage.show();

        }catch (IOException ex){
            ex.printStackTrace();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}