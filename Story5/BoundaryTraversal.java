import java.util.*;


/**
 * @Filename-BoundaryTraversal.java
 * @Description- Prints boundary nodes of a binary tree in anti-clockwise order.
 *               Boundary includes: left boundary (top to bottom), leaf nodes (left to right),
 *               and right boundary (bottom to top). Root node is included if not a leaf.
 * @Author-Aman Jeet Singh
 */



public class BoundaryTraversal {

    /**
     * Checks if a node is a leaf node (has no children)
     * @param node The node to check
     * @return true if node is a leaf, false otherwise
     */
    static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    /**
     * Adds left boundary nodes to result (excluding leaf nodes)
     * @param rootNode Root of the tree
     * @param boundaryResult List to store boundary nodes
     */
    static void addLeftBoundary(TreeNode rootNode, List<Integer> boundaryResult) {
        TreeNode currentNode = rootNode.left;
        while (currentNode != null) {
            if (!isLeafNode(currentNode)) boundaryResult.add(currentNode.val);
            currentNode = (currentNode.left != null) ? currentNode.left : currentNode.right;
        }
    }

    /**
     * Adds all leaf nodes to result in left-to-right order
     * @param rootNode Root of the tree
     * @param boundaryResult List to store boundary nodes
     */
    static void addLeafNodes(TreeNode rootNode, List<Integer> boundaryResult) {
        if (rootNode == null) return;
        if (isLeafNode(rootNode)) {
            boundaryResult.add(rootNode.val);
            return;
        }
        addLeafNodes(rootNode.left, boundaryResult);
        addLeafNodes(rootNode.right, boundaryResult);
    }

    /**
     * Adds right boundary nodes to result in reverse order (excluding leaf nodes)
     * @param rootNode Root of the tree
     * @param boundaryResult List to store boundary nodes
     */
    static void addRightBoundary(TreeNode rootNode, List<Integer> boundaryResult) {
        Stack<Integer> rightBoundaryStack = new Stack<>();
        TreeNode currentNode = rootNode.right;
        while (currentNode != null) {
            if (!isLeafNode(currentNode)) rightBoundaryStack.push(currentNode.val);
            currentNode = (currentNode.right != null) ? currentNode.right : currentNode.left;
        }
        while (!rightBoundaryStack.isEmpty()) boundaryResult.add(rightBoundaryStack.pop());
    }

    /**
     * Performs boundary traversal of binary tree in anti-clockwise order
     * @param rootNode Root of the binary tree
     * @return List of boundary nodes in anti-clockwise order
     */
    static List<Integer> boundaryTraversal(TreeNode rootNode) {
        List<Integer> boundaryResult = new ArrayList<>();
        if (rootNode == null) return boundaryResult;

        if (!isLeafNode(rootNode)) boundaryResult.add(rootNode.val);
        addLeftBoundary(rootNode, boundaryResult);
        addLeafNodes(rootNode, boundaryResult);
        addRightBoundary(rootNode, boundaryResult);

        return boundaryResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode rootNode = TreeBuilder.buildTree(scanner);
        System.out.println(boundaryTraversal(rootNode));
        scanner.close();
    }
}
