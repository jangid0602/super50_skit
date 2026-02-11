import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Filename - VerticalSilhouette.java
 * Description - Assign each node a horizontal distance HD
 * Root = 0, Left = HD-1, Right = HD+1.
 * Group nodes by HD from left to right.
 * Author - Nancy Jain
 * Date - 15/01/2026
 */

public class VerticalSilhouette {

    public static List<List<Integer>> assign(TreeNodeChar root) {

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeHD> queue = new LinkedList<>();

        queue.add(new NodeHD(root, 0));

        while (!queue.isEmpty()) {

            NodeHD temp = queue.poll();

            map.putIfAbsent(temp.hd, new ArrayList<>());
            map.get(temp.hd).add(temp.node.data);

            if (temp.node.left != null) {
                queue.add(new NodeHD(temp.node.left, temp.hd - 1));
            }

            if (temp.node.right != null) {
                queue.add(new NodeHD(temp.node.right, temp.hd + 1));
            }
        }

        return new ArrayList<>(map.values());
    }

    // Helper class
    static class NodeHD {
        TreeNodeChar node;
        int hd;

        NodeHD(TreeNodeChar node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
