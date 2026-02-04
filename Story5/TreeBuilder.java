import java.util.*;



/**
 * @Filename-TreeBuilder.java
 * @Description- Utility class to build a binary tree interactively from user input.
 *               Prompts user for each node value (or "null" for missing nodes) using
 *               level-order traversal. Validates input and constructs the tree structure.
 * @Author-Aman Jeet Singh
 */



class TreeBuilder {

    /**
     * Builds a binary tree interactively from user input using level-order traversal
     * @param scanner Scanner object for reading user input
     * @return Root node of the constructed tree, or null if root is null
     */
    public static TreeNode buildTree(Scanner scanner) {
        System.out.print("Enter root value (or null): ");
        String rootInputValue = InputUtil.readNode(scanner);

        if (rootInputValue.equals("null")) return null;

        TreeNode rootNode = new TreeNode(Integer.parseInt(rootInputValue));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();

            System.out.print("Enter left child of " + currentNode.val + " (or null): ");
            String leftChildInput = InputUtil.readNode(scanner);
            if (!leftChildInput.equals("null")) {
                currentNode.left = new TreeNode(Integer.parseInt(leftChildInput));
                nodeQueue.add(currentNode.left);
            }

            System.out.print("Enter right child of " + currentNode.val + " (or null): ");
            String rightChildInput = InputUtil.readNode(scanner);
            if (!rightChildInput.equals("null")) {
                currentNode.right = new TreeNode(Integer.parseInt(rightChildInput));
                nodeQueue.add(currentNode.right);
            }
        }
        return rootNode;
    }
}
