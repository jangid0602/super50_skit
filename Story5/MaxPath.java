import java.util.*;

/**
 * @filename - MaxPath.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

// Tree node definition
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {
    int ans = 0;

    void dfs(Node root, int K, int currSum, int level, Map<Integer, Integer> mp) {
        if (root == null) return;

        currSum += root.data;

        // If sum itself equals K
        if (currSum == K) {
            ans = Math.max(ans, level + 1);
        }

        // If (currSum - K) seen before
        if (mp.containsKey(currSum - K)) {
            ans = Math.max(ans, level - mp.get(currSum - K));
        }

        // Store first occurrence of currSum
        if (!mp.containsKey(currSum)) {
            mp.put(currSum, level);
        }

        dfs(root.left, K, currSum, level + 1, mp);
        dfs(root.right, K, currSum, level + 1, mp);

        // Backtrack
        if (mp.get(currSum) == level) {
            mp.remove(currSum);
        }
    }

    int longestPathSum(Node root, int K) {
        Map<Integer, Integer> mp = new HashMap<>();
        dfs(root, K, 0, 0, mp);
        return ans;
    }

    // Build tree from level order input
    Node createTree(String[] values) {
        if (values.length == 0 || values[0].equals("null"))
            return null;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            Node curr = q.poll();

            if (i < values.length && !values[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;

            if (i < values.length && !values[i].equals("null")) {
                curr.right = new Node(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}




public class MaxPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        // Input
        System.out.println("Enter number of nodes");
        int n = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter tree nodes");
        String[] tree = sc.nextLine().split(" ");
        System.out.println("Enter sum k");
        int K = sc.nextInt();
        sc.nextLine();
        Node root = sol.createTree(tree);

        int result = sol.longestPathSum(root, K);
        System.out.println("longest downward path:"+result);
    }
}
