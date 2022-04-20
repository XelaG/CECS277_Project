import java.awt.Point;

public class Hero extends Entity implements Fighter, Magical, Archer {

    private Point loc;
    private int lvl;
    private int gold;
    private int keys;
    private int potions;

    public Hero(String n) {
        super(n, 25);
        this.lvl = 1;
        this.gold = 25;
        this.keys = 1;
        this.potions = 0;
        Map.getInstance().loadMap(this.lvl);
        this.loc = Map.getInstance().findStart();
        Map.getInstance().reveal(this.loc);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + "\nLevel: " + lvl + "\nGold: " + gold + "\nP: " + potions + " K: " + keys + "\n" + Map.getInstance().mapToString(loc);
    }

    public void levelUp() {
        this.lvl += 1;
        System.out.println("Map lvl = " + this.lvl % 3);
        Map.getInstance().loadMap(this.lvl % 3);
        loc = Map.getInstance().findStart();
        Map.getInstance().reveal(this.loc);
    }

    
    /** 
     * @return int
     */
    public int getLevel() {
        return lvl;
    }

    
    /** 
     * @return char
     */
    public char goNorth() {
        if (this.loc.getY() - 1 >= 0) {
            this.loc.translate(0, -1);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** 
     * @return char
     */
    public char goSouth() {
        if (this.loc.getY() + 1 < 5) {
            this.loc.translate(0, 1);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** 
     * @return char
     */
    public char goEast() {
        if (this.loc.getX() + 1 < 5) {
            this.loc.translate(1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** 
     * @return char
     */
    public char goWest() {
        if (this.loc.getX() - 1 >= 0) {
            this.loc.translate(-1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** 
     * @return String
     */
    public String getAttackMenu() {
        return "1. Physical Attack\n2. Magical Attack\n3. Ranged Attack\n";
    }

    
    /** 
     * @return int
     */
    public int getNumAttackMenuItems() {
        return 3;
    }

    
    /** 
     * @param choice
     * @return String
     */
    public String getSubAttackMenu(int choice) {
        if (choice == 1)
            return FIGHTER_MENU;
        if (choice == 2)
            return MAGIC_MENU;
        return ARCHER_MENU;
    }

    
    /** 
     * @param choice
     * @return int
     */
    public int getNumSubAttackMenuItems(int choice) {
        if (choice == 1)
            return NUM_FIGHTER_MENU_ITEMS;
        if (choice == 2)
            return NUM_MAGIC_MENU_ITEMS;
        return NUM_ARCHER_MENU_ITEMS;
    }

    
    /** 
     * @param e
     * @param choice
     * @param subChoice
     * @return String
     */
    public String attack(Enemy e, int choice, int subChoice) {
        String toReturn = "";
        switch (choice) {
            case 1: 
                if (subChoice == 1) toReturn =  this.sword(e);
                else toReturn =  this.axe(e);
                break;
            case 2: 
                if (subChoice == 1) toReturn =  this.magicMissile(e);
                else toReturn =  this.fireball(e);
                break;
            case 3: 
                if (subChoice == 1) toReturn =  this.arrow(e);
                else toReturn =  this.fireArrow(e);
                break;
        }
        if (e.getHp() <= 0) {
            Map.getInstance().removeCharAtLoc(loc);
            toReturn += "\n" + "You defeated the " + e.getName() + "!" + "\n";
            int droppedGold = MyUtils.randomIntRange(1 * lvl, 10 * lvl);
            collectGold(droppedGold);
            toReturn += "You found " + droppedGold + " gold on the corpse.";
        }
        return toReturn;
    }

    
    /** 
     * @return int
     */
    public int getGold() {
        return this.gold;
    }

    
    /** 
     * @param g
     */
    public void collectGold(int g) {
        this.gold += g;
    }

    
    /** 
     * @param g
     * @return Boolean
     */
    public Boolean spendGold(int g) {
        if (this.gold - g < 0) {
            return false;
        }
        this.gold -= g;
        return true;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean hasKey() {
        if (this.keys > 0)
            return true;
        return false;
    }

    public void pickUpKey() {
        this.keys += 1;
        Map.getInstance().removeCharAtLoc(this.loc);
    }

    
    /** 
     * @return Boolean
     */
    public Boolean useKey() {
        if (this.hasKey()) {
            this.keys -= 1;
            return true;
        }
        return false;
    }

    
    /** 
     * @return Boolean
     */
    public Boolean hasPotion() {
        if (this.potions > 0)
            return true;
        return false;
    }

    public void pickUpPotion() {
        this.potions += 1;
        Map.getInstance().removeCharAtLoc(this.loc);
    }

    
    /** 
     * @return Boolean
     */
    public Boolean usePotion() {
        if (this.hasPotion()) {
            this.potions -= 1;
            return true;
        }
        return false;
    }

    
    /** 
     * @param e
     * @return String
     */
    @Override
    public String sword(Entity e) {
        int damage = MyUtils.randomIntRange(0, 2);
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }

    
    /** 
     * @param e
     * @return String
     */
    @Override
    public String axe(Entity e) {
        int damage = MyUtils.randomIntRange(0, 4);
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }

    
    /** 
     * @param e
     * @return String
     */
    @Override
    public String magicMissile(Entity e) {
        int damage = MyUtils.randomIntRange(0, 3);
        e.takeDamage(damage);
        return this.getName() + " hits " + e.getName() + " with a magicMissile for " + damage + " damage.";
    }

    
    /** 
     * @param e
     * @return String
     */
    @Override
    public String fireball(Entity e) {
        int damage = MyUtils.randomIntRange(1, 5);
        e.takeDamage(damage);
        return this.getName() + " hits " + e.getName() + " with a Fireball for " + damage + " damage.";
    }

    
    /** 
     * @param e
     * @return String
     */
    @Override
    public String arrow(Entity e) {
        int damage = MyUtils.randomIntRange(0, 4);
        e.takeDamage(damage);
        return this.getName() + " shoots " + e.getName() + " with an arrow for " + damage + " damage.";
    }

    
    /** 
     * @param e
     * @return String
     */
    @Override
    public String fireArrow(Entity e) {
        int damage = MyUtils.randomIntRange(1, 5);
        e.takeDamage(damage);
        return this.getName() + " shoots " + e.getName() + " with a fire arrow for " + damage + " damage.";
    }
}
