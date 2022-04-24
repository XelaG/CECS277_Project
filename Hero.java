import java.awt.Point;

public class Hero extends Entity implements Fighter, Magical, Archer {

    private Point loc;
    private int lvl;
    private int gold;
    private int keys;
    private int potions;

    /** 
     * Create a Hero object
     * @param n is the name of the hero
     */
    public Hero(String n) {
        super(n, 25);
        this.lvl = 1;
        this.gold = 25;
        this.keys = 0;
        this.potions = 0;
        Map.getInstance().loadMap(this.lvl);
        this.loc = Map.getInstance().findStart();
        Map.getInstance().reveal(this.loc);
    }

    
    /** A string representing the hero object
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + "\nLevel: " + lvl + "\nGold: " + gold + "\nP: " + potions + " K: " + keys + "\n" + Map.getInstance().mapToString(loc);
    }


    /** Level up the hero and load the new map
     */
    public void levelUp() {
        this.lvl += 1;
        System.out.println("Map lvl = " + this.lvl % 3);
        Map.getInstance().loadMap(this.lvl % 3);
        loc = Map.getInstance().findStart();
        Map.getInstance().reveal(this.loc);
    }

    
    /** Get the level of the hero
     * @return int
     */
    public int getLevel() {
        return lvl;
    }

    
    /** translate the position of the hero to the north
     * @return char representing what is at this new position or 'x' if it's out bound the map
     */
    public char goNorth() {
        if (this.loc.getY() - 1 >= 0) {
            this.loc.translate(0, -1);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** translate the position of the hero to the south
     * @return char representing what is at this new position or 'x' if it's out bound the map
     */
    public char goSouth() {
        if (this.loc.getY() + 1 < 5) {
            this.loc.translate(0, 1);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** translate the position of the hero to the east
     * @return char representing what is at this new position or 'x' if it's out bound the map
     */
    public char goEast() {
        if (this.loc.getX() + 1 < 5) {
            this.loc.translate(1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** translate the position of the hero to the west
     * @return char representing what is at this new position or 'x' if it's out bound the map
     */
    public char goWest() {
        if (this.loc.getX() - 1 >= 0) {
            this.loc.translate(-1, 0);
            Map.getInstance().reveal(this.loc);
            return Map.getInstance().getCharAtLoc(this.loc);
        }
        return 'x';
    }

    
    /** Get the attack menu
     * @return String
     */
    public String getAttackMenu() {
        return "1. Physical Attack\n2. Magical Attack\n3. Ranged Attack\n";
    }

    
    /** Get the number of option for the attack menu
     * @return int
     */
    public int getNumAttackMenuItems() {
        return 3;
    }

    
    /** Get the sub attack menu
     * @param choice the subchoice menu
     * @return String
     */
    public String getSubAttackMenu(int choice) {
        if (choice == 1)
            return FIGHTER_MENU;
        if (choice == 2)
            return MAGIC_MENU;
        return ARCHER_MENU;
    }

    
    /** Get the number of option for a sub attack menu
     * @param choice the subchoice menu
     * @return int
     */
    public int getNumSubAttackMenuItems(int choice) {
        if (choice == 1)
            return NUM_FIGHTER_MENU_ITEMS;
        if (choice == 2)
            return NUM_MAGIC_MENU_ITEMS;
        return NUM_ARCHER_MENU_ITEMS;
    }

    
    /** Attack an enemy
     * @param e the enemy to attack
     * @param choice the type of attack
     * @param subChoice the attack
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

    
    /** Get the number of gold
     * @return int
     */
    public int getGold() {
        return this.gold;
    }

    
    /** Add gold
     * @param g quantity of gold
     */
    public void collectGold(int g) {
        this.gold += g;
    }

    
    /** Remove gold
     * @param g quantity of gold
     * @return Boolean if it works
     */
    public Boolean spendGold(int g) {
        if (this.gold - g < 0) {
            return false;
        }
        this.gold -= g;
        return true;
    }

    
    /** 
     * Checks if the hero has a key
     * @return Boolean decribing if the hero has a key or not
     */
    public Boolean hasKey() {
        if (this.keys > 0)
            return true;
        return false;
    }

    /** 
     * Pick up a key and adds it to inventory
     * @return Boolean if key has been used
     */
    public void pickUpKey() {
        this.keys += 1;
        Map.getInstance().removeCharAtLoc(this.loc);
    }

    
    /** 
     * Use a key
     * @return Boolean if key has been used
     */
    public Boolean useKey() {
        if (this.hasKey()) {
            this.keys -= 1;
            return true;
        }
        return false;
    }

    
    /** 
     * Checks if the hero has a potion
     * @return Boolean describing if the hero has a potion
     */
    public Boolean hasPotion() {
        if (this.potions > 0)
            return true;
        return false;
    }

    /** 
     * Pick up a potion and adds it to the inventory
     */
    public void pickUpPotion() {
        this.potions += 1;
        Map.getInstance().removeCharAtLoc(this.loc);
    }

    
    /** 
     * Use a potion to heal the hero
     * @return Boolean if the potion was used or not
     */
    public Boolean usePotion() {
        if (this.hasPotion()) {
            this.potions -= 1;
            this.heal();
            return true;
        }
        return false;
    }

    
    /** 
     * Sword attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    @Override
    public String sword(Entity e) {
        int damage = MyUtils.randomIntRange(0, 2);
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }

    
    /** 
     * Axe attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    @Override
    public String axe(Entity e) {
        int damage = MyUtils.randomIntRange(0, 4);
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }

    
    /** 
     * Magic Missile attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    @Override
    public String magicMissile(Entity e) {
        int damage = MyUtils.randomIntRange(0, 3);
        e.takeDamage(damage);
        return this.getName() + " hits " + e.getName() + " with a magicMissile for " + damage + " damage.";
    }

    
    /** 
     * Fireball attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    @Override
    public String fireball(Entity e) {
        int damage = MyUtils.randomIntRange(1, 5);
        e.takeDamage(damage);
        return this.getName() + " hits " + e.getName() + " with a Fireball for " + damage + " damage.";
    }

    
    /** 
     * Arrow attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    @Override
    public String arrow(Entity e) {
        int damage = MyUtils.randomIntRange(0, 4);
        e.takeDamage(damage);
        return this.getName() + " shoots " + e.getName() + " with an arrow for " + damage + " damage.";
    }

    
    /** 
     * Fire Arrow attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    @Override
    public String fireArrow(Entity e) {
        int damage = MyUtils.randomIntRange(1, 5);
        e.takeDamage(damage);
        return this.getName() + " shoots " + e.getName() + " with a fire arrow for " + damage + " damage.";
    }
}
