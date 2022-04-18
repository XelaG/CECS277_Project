import java.util.HashMap;

public class EnemyGenerator {

    private HashMap<String, Integer> enemies;

    public EnemyGenerator() {
        //TODO
        // constructor reads the file and adds the different enemies and their base hp
        // to the HashMap (do not assume you know the length of the file)
        enemies.put("", 1);
    }

    public Enemy generateEnemy(int level) {
        //TODO
        // generateEnemy method randomly selects an enemy from the map, then
        // randomly selects an ability type (Fighter/Magical/Archer), then copies
        // over the name and base hp to construct a new enemy of that type. Use the
        // level value passed in to modify the base hp so that as the Hero progresses
        // through the levels, the difficulty will increase.
        Enemy a = new Warrior("a", 1);
        return a;
    }
}
