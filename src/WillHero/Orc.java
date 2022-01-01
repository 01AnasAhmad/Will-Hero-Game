package WillHero;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Orc extends GameObjects implements Serializable {
    private int power;
    private final int coin_on_defeat=2;
    //private Platform platform;
    private double max_height;
    private double length;

    Orc(Location loc1, ImageView img1){
        super(loc1,img1);//When beginning the game from scratch...

    }
}
