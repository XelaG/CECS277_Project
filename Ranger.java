public class Ranger extends Enemy implements Archer {
    public Ranger(String n, int mHp) {
        super(n, mHp);
    }

    String attack(Hero h){
        
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
