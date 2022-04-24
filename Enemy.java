public abstract class Enemy extends Entity {

    /** 
     * Constructor of the enemy class
     * @param n is the name of the enemy
     * @param mHp is the max health points of the enemy
     */
    public Enemy(String n, int mHp) {
        super(n, mHp);
    }

    /** 
     * Attack deals damages to the entity and returns a string describing the attack
     * @param h is the entity taking the damages
     * @return String describing the attack
     */
    abstract String attack(Hero h);
}
