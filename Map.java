import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private char[][] map;
    private boolean[][] discovered;
    private static Map instance = null;

    /**
     * Create a map
     */
    private Map() {
        map = new char[5][5];
        discovered = new boolean[5][5];
    }
    /**
     * Get instance of the map or create it if it's not defined
     * @return instance of the map
     */
    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }
    /**
     * Reads in map from the file and stores it in the character array
     * @param mapNum number for map file
     */
    public void loadMap(int mapNum) {
        discovered = new boolean[5][5];
        map = new char[5][5];
        String filename = "./Configs/Map" + mapNum + ".txt";
        try {
            Scanner read = new Scanner(new File(filename));
            int i = 0;
            while(read.hasNextLine()) {
                String word = read.nextLine();
                String[] splitted = word.split(" ");
                int j = 0;
                for (String c : splitted) {
                    map[i][j] = c.charAt(0);
                    j++;
                }
                i++;
            }
            read.close();
        } catch( FileNotFoundException fnf ) {
            System.out.println("File not found");
        } catch (NullPointerException npe) {
            System.out.println("Could not sort list");
        }
    }

    /**
     * Get character at location
     * @param p is the coordinates of the point we want the char of
     * @return the character at the coordinates p
     */
    public char getCharAtLoc(Point p) {
        return map[p.y][p.x];
    }

    /**
     * Find starting point of the map
     * @return Coordinates of the starting point
     */
    public Point findStart() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 's') {
                    return new Point(j, i);
                }
            }
        }
        return null;
    }

    /**
     * Reveal the position in the map
     * @param p is the coordinates of the tile we want to reveal
     */
    public void reveal(Point p) {
        discovered[p.y][p.x] = true;
    }

    /**
     * Remove character by replacing with 'n' at specified location
     * @param p is the coordinates of the tile we want to remove
     */
    public void removeCharAtLoc(Point p) {
        map[p.y][p.x] = 'n';
        
    }

    /**
     * Turn map into string
     * @param p is the location of the player in the map
     * @return string of map
     */
    public String mapToString(Point p) {
        String toReturn = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == p.y && j == p.x) {
                    toReturn += "* ";
                } else if (discovered[i][j] == true) {
                    toReturn += map[i][j] + " ";
                } else {
                    toReturn += "x ";
                }
            }
            toReturn += "\n";
        }
        return toReturn;
    }
}
