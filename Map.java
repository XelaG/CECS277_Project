import java.awt.Point;
import java.util.Scanner;

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
        String mapName = "Map" + mapNum + ".txt";
        try{
            Scanner read = new Scanner(new File(mapName));
            while(read.hasNextLine()){
                counter = 0;
                String line = read.nextLine();
                for(int i=0; i<line.length(); i++){
                    line = line.replaceAll("\\s", "");
                    map[counter][i] = line.charAt(i);
                }
                counter++;
            }
        read.close();
        }catch( FileNotFoundException fnf ) {
            System.out.println("File Not Found");
        }
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
