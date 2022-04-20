import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private char[][] map;
    private boolean[][] discovered;
    private static Map instance = null;

    private Map() {
        map = new char[5][5];
        discovered = new boolean[5][5];
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public void loadMap(int mapNum) {
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

    public char getCharAtLoc(Point p) {
        return map[p.x][p.y];
    }

    public Point findStart() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 's') {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public void reveal(Point p) {
        discovered[p.x][p.y] = true;
    }

    public void removeCharAtLoc(Point p) {
        map[p.x][p.y] = 'n';
        
    }

    public String mapToString(Point p) {
        String toReturn = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == p.x && j == p.y) {
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
