package WillHero;

import javafx.scene.image.ImageView;

public abstract class GameObjects implements Serializable{
    //private int unique_id;
    private Location location1;
    //private double x_coordinate;
    private ImageView objectImg;
    GameObjects(Location loc1,ImageView img1){
        this.location1 = loc1;
        this.objectImg = img1;
        //this.x_coordinate = (loc1+1)*200+100;
    }

    public Location getLocation1() {
        return location1;
    }

    public ImageView getObjectImg() {
        return objectImg;
    }

    public void setLocation1(Location location1) {
        this.location1 = location1;
    }
}
