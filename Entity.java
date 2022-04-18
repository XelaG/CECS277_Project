public abstract class Entity {

    private String name;
    int hp;
    int maxHp;

    public Entity(String n, int mHp) {
        
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void heal() {
        hp = maxHp;
    }

    public void takeDamage(int d) {
        hp -= d;
    }

    @Override
    public String toString() {
        return name + ": " + hp + "/" + maxHp;
    }
}
