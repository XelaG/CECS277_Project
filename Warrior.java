public class Warrior extends Enemy implements Fighter {
    /** 
     * Create a Warrior object
     * @param n name
     * @param mHp maxHp
     */
    public Warrior(String n, int mHp) {
        super(n, mHp);
    }

    /** 
     * attacks deals damages to the entity and returns a string describing the attack
     * @param h is the entity taking the damages
     * @return String describing the attack
     */
    public String attack(Hero h){
        int rdm = MyUtils.randomIntRange(1, 2);
        switch (rdm) {
            case 1:
                return sword(h);
            case 2:
                return axe(h);
            default:
                return "";
        }
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
}
