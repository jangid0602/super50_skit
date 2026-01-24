import java.util.*;


/**
 * @Filename-LCAOfSet.java
 * @Description- Finds the Lowest Common Ancestor (LCA) of a set of nodes in a binary tree.
 *               The LCA of a set is the deepest node that is an ancestor of all nodes in the set.
 *               Uses recursive approach to find pairwise LCAs and combines them iteratively.
 * @Author-Aman Jeet Singh
 */



public class LCAOfSet {

    /**
     * Finds the Lowest Common Ancestor of two nodes in a binary tree
     * @param rootNode The root of the tree
     * @param firstNodeValue Value of the first node
     * @param secondNodeValue Value of the second node
     * @return The LCA node, or null if either node is not found
     */
    static TreeNode findLowestCommonAncestor(TreeNode rootNode, int firstNodeValue, int secondNodeValue) {
        if (rootNode == null) return null;
        if (rootNode.val == firstNodeValue || rootNode.val == secondNodeValue) return rootNode;

        TreeNode leftSubtreeResult = findLowestCommonAncestor(rootNode.left, firstNodeValue, secondNodeValue);
        TreeNode rightSubtreeResult = findLowestCommonAncestor(rootNode.right, firstNodeValue, secondNodeValue);

        if (leftSubtreeResult != null && rightSubtreeResult != null) return rootNode;
        return leftSubtreeResult != null ? leftSubtreeResult : rightSubtreeResult;
    }

    /**
     * Finds the Lowest Common Ancestor of a set of nodes
     * @param rootNode The root of the tree
     * @param nodeValues Array of node values to find LCA for
     * @return The LCA of all nodes in the set
     */
    static TreeNode findLowestCommonAncestorOfSet(TreeNode rootNode, int[] nodeValues) {
        TreeNode currentLCA = rootNode;
        for (int nodeIndex = 0; nodeIndex < nodeValues.length; nodeIndex++) {
            currentLCA = findLowestCommonAncestor(rootNode, currentLCA.val, nodeValues[nodeIndex]);
        }
        return currentLCA;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode rootNode = TreeBuilder.buildTree(scanner);

        System.out.print("Enter number of nodes: ");
        int numberOfNodes = InputUtil.readInt(scanner);

        int[] nodeValues = new int[numberOfNodes];
        for (int nodeIndex = 0; nodeIndex < numberOfNodes; nodeIndex++) {
            nodeValues[nodeIndex] = InputUtil.readInt(scanner);
        }

        TreeNode lcaResult = findLowestCommonAncestorOfSet(rootNode, nodeValues);
        System.out.println("LCA = " + lcaResult.val);
        scanner.close();
    }
}
