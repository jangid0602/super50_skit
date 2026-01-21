import java.util.*;

/**
 * @Filename-KSumPath.java
 * @Description- This is Maximum path sum
 * @Author-Arman Agrawal
 */



public class KSumPath {

    static int maxLen = 0;

    static void solve(TreeNode root, int K, int currSum,
                      int level, Map<Integer, Integer> map) {

        if (root == null) return;

        currSum += root.val;

        map.putIfAbsent(currSum, level);

        if (map.containsKey(currSum - K)) {
            maxLen = Math.max(maxLen, level - map.get(currSum - K));
        }

        solve(root.left, K, currSum, level + 1, map);
        solve(root.right, K, currSum, level + 1, map);

        if (map.get(currSum) == level) {
            map.remove(currSum);
        }
    }

    static int longestKSumPath(TreeNode root, int K) {
        maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        solve(root, K, 0, 1, map);
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = TreeBuilder.buildTree(sc);

        System.out.print("Enter K: ");
        int K = InputUtil.readInt(sc);

        System.out.println("Longest path length = " + longestKSumPath(root, K));
        sc.close();
    }
}
