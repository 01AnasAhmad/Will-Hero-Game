package WillHero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game1.fxml")));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("game1.fxml")));
        primaryStage.setTitle(" WILL HERO GAME");
        primaryStage.setScene(new Scene(root,900,500, Color.SKYBLUE)); //root,1100,690, Color.SKYBLUE remember these
        Image icon = new Image("C:\\Users\\Anas Ahmad\\Desktop\\intellijCode\\Group_20\\src\\GameAssets\\icon.jpg");
        primaryStage.getIcons().add(icon);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args); // or Application.launch(args)
    }
}
