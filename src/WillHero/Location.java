package WillHero;

public class Location {
    //private double x_center;
    private int number;
    private Platform platform;
    private Chest chest;
    private Orc orc;
    private boolean has_platform;
    private boolean has_chest;
    private boolean has_orc;

    Location(int loc,boolean has_platform){ //For island
        this.number = loc;
        this.has_platform = has_platform;
    }

    public boolean isHas_platform() {
        return has_platform;
    }

    public void setHas_chest(boolean has_chest) {
        this.has_chest = has_chest;
    }

    public void setHas_orc(boolean has_orc) {
        this.has_orc = has_orc;
    }

    public Orc getOrc() {
        return orc;
    }

    public void setOrc(Orc orc) {
        this.orc = orc;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public boolean isHas_chest() {
        return has_chest;
    }

    public int getNumber() {
        return number;
    }
}
