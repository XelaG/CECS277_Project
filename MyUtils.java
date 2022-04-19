public class MyUtils {
    public static int randomIntRange(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}