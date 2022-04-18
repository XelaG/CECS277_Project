public interface Archer {
    static final String ARCHER_MENU = "1. Arrow\n2. Fire Arrow";
    static final int ARCHER_MENU_ITEMS = 2;

    public String arrow(Entity e);
    public String fireArrow(Entity e);
}
