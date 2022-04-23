public class MyUtils {
    
    /** 
     * Generate a random number in a specific range
     * @param min is the lowest point of the range
     * @param max is the highest point of the range
     * @return the random number generated
     */
    public static int randomIntRange(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}