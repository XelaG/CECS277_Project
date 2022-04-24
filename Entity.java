public abstract class Entity {

    private String name;
    private int hp;
    private int maxHp;

    /** 
     * Constructor of the entity class
     * @param n is the name of the entity
     * @param mHp is the max health points of the entity
     */
    public Entity(String n, int mHp) {
        name = n;
        hp = mHp;
        maxHp = mHp;
    }

    
    /** 
     * Returns the name of the entity
     * @return String name of the entity
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Returns the hp of the entity
     * @return int health points
     */
    public int getHp() {
        return hp;
    }

    /** 
     * Resets the hp of the entity to the max
     */
    public void heal() {
        hp = maxHp;
    }

    
    /** 
     * Inflict damages to the entity
     * @param d is the amount of damages to inflict
     */
    public void takeDamage(int d) {
        hp -= d;
    }

    
    /** 
     * returns a string descripting the Entity object
     * @return String descripting the Entity object
     */
    @Override
    public String toString() {
        return name + "\nHP: " + hp + "/" + maxHp;
    }
}
