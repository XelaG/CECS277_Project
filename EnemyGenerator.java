import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class EnemyGenerator {

    private HashMap<String, Integer> enemies;

    /** 
     * Constructor of the enemy generator
     */
    public EnemyGenerator() {
        enemies = new HashMap<String, Integer>();
        try {
            Scanner read = new Scanner(new File("./Configs/Enemies.txt"));
            while(read.hasNextLine()) {
                String word = read.nextLine();
                String[] splitted = word.split(",");
                enemies.put(splitted[0], Integer.parseInt(splitted[1]));
            }
            read.close();
        } catch( FileNotFoundException fnf ) {
            System.out.println("File not found");
        } catch (NullPointerException npe) {
            System.out.println("Could not sort list");
        }
    }

    
    /** 
     * Generates an enemy randomly from the map
     * @param level defines the level of the player at this time
     * @return Generated Enemy
     */
    public Enemy generateEnemy(int level) {
        Set<String> set = enemies.keySet();
        int type = MyUtils.randomIntRange(1, 3);
        int enemyNb = MyUtils.randomIntRange(0,set.size() - 1);
        String name = (String)enemies.keySet().toArray()[enemyNb];
        int mHp = enemies.get(enemies.keySet().toArray()[enemyNb]);
        switch (type) {
            case 1:
                return new Warrior(name, mHp * level );
            case 2:
                return new Wizard(name, mHp * level );
            case 3:
                return new Ranger(name, mHp * level );

            default:
                return null;
        }
    }
}
