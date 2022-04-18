public abstract class Enemy extends Entity {
    public Enemy(String n, int mHp) {
        super(n, mHp);
    }

    abstract String attack(Hero h);
}
