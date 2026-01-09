/**
 * Filename- TeamAssembly.java
 * Description- You are a manager with a list of $N$ specialized developers. You want 
to see every possible combination of team members you could form 
(subsets). 
 * Author - Nancy Jain
 * Date - 08/01/2026
 */
package tasks;

import java.util.ArrayList;
import java.util.List;

public class TeamAssembly {
    public static List<List<String>> Team(String[] members){
        List<List<String>> result = new ArrayList<>();
        makeSet(members, 0  ,new ArrayList<>() , result);
        return result;
    }
    public static void makeSet(String[] members , int index , List<String> current , List<List<String>> result){
        if(index == members.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        makeSet(members, index+1, current, result);
        current.add(members[index]);
        makeSet(members, index+1, current, result);

        current.remove(current.size()-1);
    }
}
