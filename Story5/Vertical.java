import java.util.*;

/**
 * @filename - Vertical.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

// Single Node class
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Solution {

    // -------- Vertical Traversal --------
    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

       
        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 0, 0});

        while (!q.isEmpty()) {
            Object[] cur = q.poll();
            Node node = (Node) cur[0];
            int col = (int) cur[1];
            int row = (int) cur[2];

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.data});

            if (node.left != null)
                q.add(new Object[]{node.left, col - 1, row + 1});
            if (node.right != null)
                q.add(new Object[]{node.right, col + 1, row + 1});
        }

        // sort each column
        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            List<Integer> colList = new ArrayList<>();
            for (int[] p : list)
                colList.add(p[1]);

            ans.add(colList);
        }
        return ans;
    }

    // -------- Tree Creation (Level Order) --------
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




public class Vertical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter tree nodes (use null for no node):");
        String[] values = sc.nextLine().split(" ");

        Node root = sol.createTree(values);

        List<List<Integer>> result = sol.verticalTraversal(root);

        System.out.println("Vertical Traversal:");
        System.out.println(result);
    }
}
