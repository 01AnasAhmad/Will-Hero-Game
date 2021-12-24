
package WillHero;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private AnchorPane gameScreenFixed1;

    @FXML
    void forwardMove(MouseEvent event) {

    }
    @FXML
    void forwardMove1(MouseEvent event) {

    }

    public Group CreateHero(Group group){
        Image hero = new Image("C:\\Users\\Anas Ahmad\\Desktop\\intellijCode\\Group_20\\src\\GameAssets\\hero.jpg");
        ImageView heroImg = new ImageView(hero);
        heroImg.setFitHeight(25);
        heroImg.setFitWidth(25);
        heroImg.setX(50);
        heroImg.setY(200);
        heroImg.setPreserveRatio(true);
        heroImg.setSmooth(true);
        heroImg.setCache(true);
        group.getChildren().add(heroImg);
        return group;
    }

    public Group CreateBigPlatform(Group group){
        Image island = new Image("C:\\Users\\Anas Ahmad\\Desktop\\intellijCode\\Group_20\\src\\GameAssets\\islandbig11.jpg");
        ImageView islandImg = new ImageView(island);
        group.getChildren().add(islandImg);
        return group;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Group g = new Group();
        Image hero = new Image("C:\\Users\\Anas Ahmad\\Desktop\\intellijCode\\Group_20\\src\\GameAssets\\hero.jpg");
        ImageView heroImg = new ImageView(hero);
        heroImg.setFitHeight(25);
        heroImg.setFitWidth(25);
        heroImg.setX(175);
        heroImg.setY(200);
        heroImg.setPreserveRatio(true);
        heroImg.setSmooth(true);
        heroImg.setCache(true);
        g.getChildren().add(heroImg);

        for (int i = 0; i < 5; i++) {
            Image island = new Image("C:\\Users\\Anas Ahmad\\Desktop\\intellijCode\\Group_20\\src\\GameAssets\\islandOrig.jpg");
            ImageView islandImg = new ImageView(island);
            islandImg.setFitHeight(100);
            islandImg.setFitWidth(200);

            islandImg.setX((i+1) * 200);
            islandImg.setY(250);
            islandImg.setPreserveRatio(true);
            islandImg.setSmooth(true);
            islandImg.setCache(true);
            g.getChildren().add(islandImg);
        }
//        Group group = new Group();
//        //Hero HERO = new Hero();
//        CreateHero(group);
//        gameScreenFixed1.getChildren().add(group);
//        group = CreateBigPlatform(group);
        gameScreenFixed1.getChildren().add(g);

    }


//        TranslateTransition translateTransition = new TranslateTransition();
//        //translateTransition.setNode(r2);
//        translateTransition.setAutoReverse(true);
//        translateTransition.setDuration(Duration.millis(900));
//        translateTransition.setByX(+300);
//        translateTransition.setCycleCount(1);
//        translateTransition.play();

}
