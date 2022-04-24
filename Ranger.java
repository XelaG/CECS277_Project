public class Ranger extends Enemy implements Archer {
    /** 
     * Create a Ranger object
     * @param n name
     * @param mHp maxHp
     */
    public Ranger(String n, int mHp) {
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
                return arrow(h);
            case 2:
                return fireArrow(h);
            default:
                return "";
        }
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
