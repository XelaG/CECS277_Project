public class Warrior extends Enemy implements Fighter {
    public Warrior(String n, int mHp) {
        super(n, mHp);
    }


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
     * String for sword attack
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
     * String for axe attack
     * @param e
     * @return String
     */
    @Override
    public String axe(Entity e) {
        int damage = MyUtils.randomIntRange(0, 4);
        e.takeDamage(damage);
        return this.getName() + " slashes " + e.getName() + " for " + damage + " damage.";
    }
}
