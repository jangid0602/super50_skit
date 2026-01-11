/**
 * filename- RecursionOnNumbers.java
 * description- This will perform  Recursion  on Numbers like calculating sum of tree nodes. 
 * author- Agrani Gupta
 */
package Story5;

import java.util.*;

public class RecursionOnNumbers {
    // 1
    boolean findKey(int number) {

        if (number == 0) {
            return false;
        }
        if (number == 1) {
            return true;
        }
        return findKey(number - 1);
    }

    // 2
    int fibonaaciSum(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonaaciSum(number - 1) + fibonaaciSum(number - 2);
    }

    // 3
    int calculatelegacy(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return root.val + calculatelegacy(root.left) + calculatelegacy(root.right);
        }
        if (root.left != null && root.right == null) {
            return root.val + calculatelegacy(root.left);

        }
        return root.val + calculatelegacy(root.right);
    }
    // 6

    String compressString(String[] characters) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        calculateFrequency(characters, map, 0);
        String answer = "";
        for (Character x : set) {
            answer += x;
            answer += map.get(x);
        }
        return answer;
    }

    void calculateFrequency(String[] characters, HashMap<Character, Integer> map, int i) {
        if (i == characters.length) {
            return;
        }
        map.put(characters[i].charAt(0), map.getOrDefault(characters[i].charAt(0), 0) + 1);
        calculateFrequency(characters, map, i + 1);

    }

}
