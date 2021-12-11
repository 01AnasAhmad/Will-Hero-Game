package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("page1.fxml")));
        primaryStage.setTitle("WILL HERO GAME");
        primaryStage.setScene(new Scene(root,600,500, Color.SKYBLUE));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
