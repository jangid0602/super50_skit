/**
 * Filename : ConsertSeatManager.java
 * Description :  determine the first customer who requests a seat that has already been
requested by someone else. 
 * Author : Nancy Jain
 */

import java.util.Set;
import java.util.HashSet;
public class ConcertSeatManager {
    public static String DuplicateDetection(String[][] requests){
        Set<String> seats = new HashSet<>();
        for(String[] req : requests){
            if(!seats.add(req[1])){
                return req[0];
            }
        }
        return "-1";
    }
}
