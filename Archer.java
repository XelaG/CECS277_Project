public interface Archer {
    static final String ARCHER_MENU = "1. Arrow\n2. Fire Arrow";
    static final int NUM_ARCHER_MENU_ITEMS = 2;

    /** 
     * Arrow attacks deals damages to the entity and returns a string describing the attack
     * @param h is the entity taking the damages
     * @return String describing the attack
     */
    public String arrow(Entity e);

    /** 
     * Fire Arrow attacks deals damages to the entity and returns a string describing the attack
     * @param h is the entity taking the damages
     * @return String describing the attack
     */
    public String fireArrow(Entity e);
}
