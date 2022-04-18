public class Ranger extends Enemy implements Archer {
    public Ranger(String n, int mHp) {
        super(n, mHp);
    }

    String attack(Hero h){
        return "";
    }

    @Override
    public String arrow(Entity e) {
        return "";
    }

    @Override
    public String fireArrow(Entity e) {
        return "";
    }
}
