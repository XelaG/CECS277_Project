public interface Magical {
    static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball";
    static final int NUM_MAGIC_MENU_ITEMS = 2;

    public String magicMissile(Entity e);
    public String fireball(Entity e);
}
