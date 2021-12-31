package WillHero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ThrowingKnife extends Weapon{

    private final int range=2;
    private int no;//number of knives
    private Image knife = new Image("C:\\Users\\ishaan\\IdeaProjects\\Group_20\\src\\GameAssets\\WeaponKnife.jpg");
    private ImageView img= new ImageView(knife);

    ThrowingKnife() {
        this.no = 1;
        setWname("Knife");
        setDamage_value(1);
        setLevel(1);
        setImg(img);
    }

    public int getRange() {
        return range;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
