import java.awt.Point;

public class Hero extends Entity implements Fighter, Magical, Archer {

    private Point loc;
    private int lvl;
    private int gold;
    private int keys;
    private int potions;

    public Hero(String n) {
        super(n, 25);
        Map.getInstance().loadMap(this.lvl);
        this.loc = Map.getInstance().findStart();
        this.lvl = 1;
        this.gold = 10;
        this.keys = 0;
        this.potions = 0;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLevel: " + lvl + "\nGold: " + gold + "\nP: " + potions + " K: " + keys + "\n" + Map.getInstance().mapToString(loc);
    }

    public void levelUp() {
        this.lvl += 1;
        Map.getInstance().loadMap(this.lvl % 3);
    }

    public int getLevel() {
        return lvl;
    }

    public char goNorth() {
        if (this.loc.getY() - 1 >= 0) {
            this.loc.translate(0, -1);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    public char goSouth() {
        if (this.loc.getY() + 1 < 5) {
            this.loc.translate(-1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    public char goEast() {
        if (this.loc.getX() + 1 < 5) {
            this.loc.translate(1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    public char goWest() {
        if (this.loc.getX() - 1 >= 0) {
            this.loc.translate(-1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    public String getAttackMenu() {
        return "1. Physical Attack\n2. Magical Attack\n3. Ranged Attack\n";
    }

    public int getNumAttackMenuItems() {
        return 3;
    }

    public String getSubAttackMenu(int choice) {
        if (choice == 1)
            return FIGHTER_MENU;
        if (choice == 2)
            return MAGIC_MENU;
        return ARCHER_MENU;
    }

    public int getNumSubAttackMenuItems(int choice) {
        if (choice == 1)
            return NUM_FIGHTER_MENU_ITEMS;
        if (choice == 2)
            return NUM_MAGIC_MENU_ITEMS;
        return NUM_ARCHER_MENU_ITEMS;
    }

    public String attack(Enemy e, int choice, int subChoice) {
        switch (choice) {
            case 1: switch (subChoice) {
                        case 1: return this.sword(e);
                        case 2: return this.axe(e);
                    }
            case 2: switch (subChoice) {
                        case 1: return this.magicMissile(e);
                        case 2: return this.fireball(e);
                    }
            case 3: switch (subChoice) {
                        case 1: return this.arrow(e);
                        case 2: return this.fireArrow(e);
                    }
        }
    }

    public int getGold() {
        return this.gold;
    }

    public void collectGold(int g) {
        this.gold += g;
    }

    public Boolean spendGold(int g) {
        if (this.gold - g < 0) {
            return false;
        }
        this.gold -= g;
        return true;
    }

    public Boolean hasKey() {
        if (this.key > 0)
            return true;
        return false;
    }

    public void pickUpKey() {
        this.key += 1;
        Map.getInstance().removeCharAtLoc(this.loc);
    }

    public Boolean useKey() {
        if (this.hasKey()) {
            this.key -= 1;
            return true;
        }
        return false;
    }

    public Boolean hasPotion() {
        if (this.potions > 0)
            return true;
        return false;
    }

    public void pickUpPotion() {
        this.potions += 1;
        Map.getInstance().removeCharAtLoc(this.loc);
    }

    public Boolean usePotion() {
        if (this.hasPotion()) {
            this.potions -= 1;
            return true;
        }
        return false;
    }

    @Override
    public String sword(Entity e) {
        return "";
    }

    @Override
    public String axe(Entity e) {
        return "";
    }

    @Override
    public String magicMissile(Entity e) {
        return "";
    }

    @Override
    public String fireball(Entity e) {
        return "";
    }

    @Override
    public String arrow(Entity e) {
        return "";
    }

    @Override
    public String fireArrow(Entity e) {
        return "";
    }
}
