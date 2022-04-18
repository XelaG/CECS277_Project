import java.awt.Point;

public class Hero {

    private Point loc;
    private int lvl;
    private int gold;
    private int keys;
    private int positions;

    public Hero(String n) {
        this.loc = new Point(0, 0);
    }

    @Override
    public String toString() {
        return "";
    }

    public void levelUp() {
        
    }

    public int getLevel() {
        return lvl;
    }

    public char goNorth() {
        return 'a';
    }

    public char goSouth() {
        return 'a';
    }

    public char goEast() {
        return 'a';
    }

    public char goWest() {
        return 'a';
    }

    public String getAttackMenu() {
        return "";
    }

    public int getNumAttackMenuItems() {
        return 0;
    }

    public String getSubAttackMenu(int choice) {
        return "";
    }

    public int getNumSubAttackMenuItems(int choice) {
        return 0;
    }

    public String attack(Enemy e, int choice, int subChoice) {
        return "";
    }

    public int getGold() {
        return gold;
    }

    public void collectGold(int g) {
        
    }

    public Boolean spendGold(int g) {
        return false;
    }

    public Boolean hasKey() {
        return false;
    }

    public void pickUpKey() {
        
    }

    public Boolean useKey() {
        return false;
    }

    public Boolean hasPotion() {
        return false;
    }

    public void pickUpPotion() {
        
    }

    public Boolean usePotion() {
        return false;
    }
}
