package Story4;
import java.util.*;

class SpyCipher {

    public static char findExtraChar(String original, String scrambled) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : original.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : scrambled.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;
            }
            map.put(c, map.get(c) - 1);
        }

        return '\0';
    }
}