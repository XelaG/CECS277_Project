public class Wizard extends Enemy implements Magical {
    public Wizard(String n, int mHp) {
        super(n, mHp);
    }

    String attack(Hero h){
        
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
}
