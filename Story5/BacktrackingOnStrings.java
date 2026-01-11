/**
 * filename- BacktrackingOnStrings.java
 * description- This will perform most of the  Backtracking on Strings. 
 * author- Agrani Gupta
 */
package Story5;

import java.util.*;

public class BacktrackingOnStrings {
    // 5
    List<List<String>> generateSubset(List<String> Teams) {
        List<List<String>> result = new ArrayList<>();
        backtrack(Teams, 0, new ArrayList<>(), result);
        return result;
    }

    void backtrack(List<String> Teams, int index, List<String> current, List<List<String>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < Teams.size(); i++) {
            current.add(Teams.get(i));
            backtrack(Teams, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

}
