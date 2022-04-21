public class Wizard extends Enemy implements Magical {
    public Wizard(String n, int mHp) {
        super(n, mHp);
    }

    public String attack(Hero h){
        return "";
    }

    @Override
    public String magicMissile(Entity e) {
        return "";
    }

    @Override
    public String fireball(Entity e) {
        return "";
    }
}
