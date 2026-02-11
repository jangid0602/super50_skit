/**
 * Filename- CosmicCourier
 * Deescription- The scrambled string is created by rearranging the characters of original and adding
exactly one extra character. Your task is to identify and return that extra character.
 * Author - Nancy Jain
 */
import java.util.*;

public class SpyCipher {
    public static char findChar(String originalString , String scrambledString){
        Map<Character , Integer> map = new HashMap<>();
        for(char c : scrambledString.toCharArray()){
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        for(char ch:originalString.toCharArray()){
            map.put(ch, map.get(ch)-1);
        }
        for(char c : map.keySet()){
            if(map.get(c)>0) return c;
        }
        return ' ';
    }
}
