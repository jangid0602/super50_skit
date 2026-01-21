/**
 * Filename- DigitalLibrarySystem.java
 * Deescription- The robot processes a list of weights and outputs a corresponding list of labels. This problem
    checks logical ordering and conditional prioritization.
 * Author - Nancy Jain
 */

import java.util.*;

public class FactoryRobot {
    public static List<String> label(int [] weights){
        List<String> result = new ArrayList<>();

        for(int weight : weights){
            if(weight % 15 == 0) result.add("Hazardous");
            else if(weight % 3 == 0) result.add("Heavy");
            else if(weight % 5 == 0 ) result.add("Fragile");
            else result.add(String.valueOf(weight));
        }
        return result;
    }
}
