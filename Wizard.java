public class Wizard extends Enemy implements Magical {
    /** 
     * Create a Wizard object
     * @param n name
     * @param mHp maxHp
     */
    public Wizard(String n, int mHp) {
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
                return magicMissile(h);
            case 2:
                return fireball(h);
            default:
                return "";
        }
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
}
