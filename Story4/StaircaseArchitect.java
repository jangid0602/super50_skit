
/**
 * @Filename- StaircaseArchitect.java
 * @Description- This is the class which has a function countways which calculate the no of jumps needed to climb the stairs
 * @Author- Arman Agrawal
 */




public class StaircaseArchitect {

    public static int countWays(int steps) {
        if (steps == 0 || steps == 1) {
            return 1;
        }
        return countWays(steps - 1) + countWays(steps - 2);
    }
}
