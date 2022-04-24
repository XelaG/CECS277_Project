public interface Fighter {

    static final String FIGHTER_MENU = "1. Sword\n2. Axe";
    static final int NUM_FIGHTER_MENU_ITEMS = 2;
    
    /** 
     * Sword attacks deals damages to the entity and returns a string describing the attack
     * @param h is the entity taking the damages
     * @return String describing the attack
     */
    public String sword(Entity e);

    /** 
     * Sword attacks deals damages to the entity and returns a string describing the attack
     * @param e is the entity taking the damages
     * @return String describing the attack
     */
    public String axe(Entity e);
}
