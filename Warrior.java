public class Warrior extends Enemy implements Fighter {
    public Warrior(String n, int mHp) {
        super(n, mHp);
    }

    public String attack(Hero h){
        return "";
    }

    @Override
    public String sword(Entity e) {
        return "";
    }

    @Override
    public String axe(Entity e) {
        return "";
    }
}
