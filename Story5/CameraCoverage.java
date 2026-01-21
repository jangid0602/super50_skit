
/**
 * Filename - CameraCoverage.java
 * Description - You need to install cameras on nodes to monitor the entire 
tree. A camera at a node monitors itself, its parent, and its immediate children. 
Find the minimum number of cameras needed.  
 * Author - Nancy Jain
 * Date - 16/01/2026
 */

public class CameraCoverage {

    // 0 -> node needs camera
    // 1 -> node has camera
    // 2 -> node is covered
    int cameras = 0;
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            cameras++;   // root needs a camera
        }
        return cameras;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 2; // null nodes are covered
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // if any child needs camera
        if (left == 0 || right == 0) {
            cameras++;
            return 1; // place camera here
        }

        // if any child has camera
        if (left == 1 || right == 1) {
            return 2; // this node is covered
        }

        // children are covered but no camera
        return 0;
    }
}
