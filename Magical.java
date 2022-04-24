public interface Magical {
    static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball";
    static final int NUM_MAGIC_MENU_ITEMS = 2;

    /** 
     * Magic Missile attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    public String magicMissile(Entity e);

    /** 
     * Fireball attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    public String fireball(Entity e);
}
