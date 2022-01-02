package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

import java.io.Serializable;

public class Sword extends Weapon implements Serializable {

    private transient Image sword = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\WeaponSword.jpg");
    private transient ImageView img= new ImageView(sword);

    Sword() {
        setDamage_value(2);
        setLevel(1);
        setWname("Sword");
        setImg(img);
    }

}
