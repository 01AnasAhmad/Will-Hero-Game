package WillHero;

import javafx.scene.image.ImageView;

public class Coin_Chest extends Chest{
    private final int numCoins=10;
    Coin_Chest(Location loc, ImageView coinChestimg){
        super(loc,coinChestimg);
        this.setType("Coin");
    }

    public int getNumCoins() {
        return numCoins;
    }
}
