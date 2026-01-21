import java.util.HashMap;
import java.util.Vector;

/**
 * Filename - PalindromicPath.java
 * Description - Given a rooted tree where each node contains a lowercase
letter ('a'-'z'), find the number of downward paths where the characters in the
path can be rearranged to form a palindrome. 
 * Author - Nancy Jain
 * Date - 14/01/2026
 */

public class PalindromicPath {
    public static int path(TreeNodeChar root){
        //create 2d array to store words.
        Vector<String> currentPath = new Vector<>();
        return dfs(root, currentPath);
    }

    static int dfs(TreeNodeChar root, Vector<String> path) {
        if (root == null) return 0;
        path.add(String.valueOf(root.data));
        int count = 0;
        Vector<String> temp = new Vector<>();
        for (int i = path.size() - 1; i >= 0; i--) {
            temp.add(0, path.get(i));
            if (canFormPalindrome(temp)) {
                count++;
            }
        }
        count += dfs(root.left, path);
        count += dfs(root.right, path);
        path.remove(path.size() - 1);
        return count;
    }

    static boolean canFormPalindrome(Vector<String> word) {
        HashMap<String, Integer> freq = new HashMap<>();

        for (String ch : word) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0;
        for (int val : freq.values()) {
            if (val % 2 != 0) oddCount++;
            if (oddCount > 1) return false;
        }
        return true;
    }
}
