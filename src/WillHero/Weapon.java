package WillHero;

import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Weapon implements Serializable {//extends GameObjects{
    private int damage_value;
    private int level;
    private String wname;
    private ImageView img;
    public void setWname(String wname) {
        this.wname = wname;
    }

    public int getDamage_value() {
        return damage_value;
    }

    public int getLevel() {
        return level;
    }

    public String getWname() {
        return wname;
    }

    public void setDamage_value(int damage_value) {
        this.damage_value = damage_value;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }
}
