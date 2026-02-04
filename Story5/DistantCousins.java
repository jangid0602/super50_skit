import java.util.*;

/**
 * @Filename-DistantCousins.java
 * @Description- Finds all cousin nodes of a given node X in a binary tree. Cousins are nodes
 *               at the same level as X but with different parents. Uses level-order traversal
 *               (BFS) to identify nodes at the same level, excluding siblings of X.
 * @Author-Aman Jeet Singh
 */



public class DistantCousins {

    /**
     * Finds all cousin nodes of node X in the binary tree
     * @param rootNode Root of the binary tree
     * @param targetNodeValue Value of the node whose cousins are to be found
     * @return List of cousin node values
     */
    static List<Integer> findCousins(TreeNode rootNode, int targetNodeValue) {
        List<Integer> cousinNodes = new ArrayList<>();
        if (rootNode == null || rootNode.val == targetNodeValue) return cousinNodes;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);

        boolean targetNodeFound = false;

        while (!nodeQueue.isEmpty()) {
            int currentLevelSize = nodeQueue.size();

            for (int nodeIndex = 0; nodeIndex < currentLevelSize; nodeIndex++) {
                TreeNode currentNode = nodeQueue.poll();

                // Check if current node has target node as a child (sibling detection)
                if ((currentNode.left != null && currentNode.left.val == targetNodeValue) ||
                    (currentNode.right != null && currentNode.right.val == targetNodeValue)) {
                    targetNodeFound = true;
                } else {
                    // Add children to queue for next level processing
                    if (currentNode.left != null) nodeQueue.add(currentNode.left);
                    if (currentNode.right != null) nodeQueue.add(currentNode.right);
                }
            }

            // If target node was found at previous level, remaining nodes are cousins
            if (targetNodeFound) {
                while (!nodeQueue.isEmpty()) {
                    cousinNodes.add(nodeQueue.poll().val);
                }
                break;
            }
        }
        return cousinNodes;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeNode rootNode = TreeBuilder.buildTree(scanner);

        System.out.print("Enter value X: ");
        int targetNodeValue = scanner.nextInt();

        List<Integer> cousinNodes = findCousins(rootNode, targetNodeValue);

        System.out.println("Cousins of " + targetNodeValue + " are:");
        System.out.println(cousinNodes);

        scanner.close();
    }
}
