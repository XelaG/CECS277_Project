import java.awt.Point;
import java.util.Scanner;

public class Map {
    private char[][] map;
    private Boolean[][] discovered;
    private static Map instance = null;

    private Map() {
    }

    public static Map getInstance() {
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void loadMap(int mapNum) {
        String mapName = "Map" + mapNum + ".txt";
        try{
            Scanner read = new Scanner(new File(mapName));
            int counter = 0;
            while(read.hasNextLine()){
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
        return maze[p.getX()][p.getY()];
    }

    public Point findStart() {
        int x = 0;
        int y = 0;
        while(true){
            for(int i=0; i<map.length; i++){ //iterate through x values for map
                x = i;
                for(int j=0; j<map[0].length; j++){ //iterate through y values for map
                    y = j;
                    if(map[i][j] == 's'){ //jumps out of loop when starting point 's' is found
                        Point p = new Point(x,y);
                        return p;
                    }
                }
            }
        }
    }

    public void reveal(Point p) {
        
    }

    public void removeCharAtLoc(Point p) {
        
    }

    public String mapToString(Point p) {
        String mapString;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length, j++){
                mapString += map.charAt(j) + " ";
            }
            System.out.println();
        }
        return mapString;
    }
}
