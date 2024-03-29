package WillHero;

import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Orc extends GameObjects implements Serializable {
    private int power;
    private final int coin_on_defeat=2;
    //private Platform platform;
    private double max_height;
    private double length;
    private transient TranslateTransition tt;

    Orc(Location loc1, ImageView img1){
        super(loc1,img1);//When beginning the game from scratch...

    }

    public TranslateTransition getTt() {
        return tt;
    }

    public void setTt(TranslateTransition tt) {
        this.tt = tt;
    }
}
