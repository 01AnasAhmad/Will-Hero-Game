package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

import java.io.Serializable;

public class Sword extends Weapon implements Serializable {

    Sword() {
        setDamage_value(2);
        setLevel(1);
        setWname("Sword");
    }

}
