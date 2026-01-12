package Story4;
import java.util.*;

class FactoryFloorRobot {

    public static List<String> labelItems(int[] weights) {
        List<String> result = new ArrayList<>();

        for (int w : weights) {
            if (w % 15 == 0) {
                result.add("Hazardous");
            } else if (w % 3 == 0) {
                result.add("Heavy");
            } else if (w % 5 == 0) {
                result.add("Fragile");
            } else {
                result.add(String.valueOf(w));
            }
        }

        return result;
    }

}