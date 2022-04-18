import java.awt.Point;

public class Map {
    private char[][] map;
    private Boolean[][] discovered;
    private static Map instance = null;

    private Map() {
    }

    public static Map getInstance() {
        return instance;
    }

    public void loadMap(int mapNum) {
        
    }

    public char getCharAtLoc(Point p) {
        return 'a';
    }

    public Point findStart() {
        return new Point(0, 0);
    }

    public void reveal(Point p) {
        
    }

    public void removeCharAtLoc(Point p) {
        
    }

    public String mapToString(Point p) {
        return "";
    }
}
