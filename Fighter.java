public interface Fighter {

    static final String FIGHTER_MENU = "1. Sword\n2. Axe";
    static final int NUM_FIGHTER_MENU_ITEMS = 2;
    
    public String sword(Entity e);
    public String axe(Entity e);
}
