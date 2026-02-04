import java.util.*;

/**
 * @Filename-MinimumCameraCoverage.java
 * @Description- Finds the minimum number of cameras needed to monitor an entire binary tree.
 *               Each camera monitors itself, its parent, and its immediate children.
 *               Uses a greedy post-order DFS approach that processes leaves first and places
 *               cameras at parent nodes when needed, maximizing coverage per camera.
 * @Author-Aman Jeet Singh
 */

public class MinimumCameraCoverage {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    static int totalCameraCount = 0;
    
    /**
     * Node monitoring states:
     * 0 -> Node is not monitored
     * 1 -> Node is monitored (by child camera or parent camera)
     * 2 -> Node has a camera installed
     */
    
    /**
     * Finds minimum cameras needed using greedy post-order DFS
     * Key Insight: Process leaves first, place camera at parent if leaf not covered
     * This maximizes coverage per camera
     * @param rootNode Root of the binary tree
     * @return Minimum number of cameras needed
     */
    public static int minCameraCover(TreeNode rootNode) {
        totalCameraCount = 0;
        int rootState = depthFirstSearch(rootNode);
        
        // If root is not monitored, we need a camera at root
        if (rootState == 0) {
            totalCameraCount++;
        }
        
        return totalCameraCount;
    }
    
    /**
     * DFS post-order traversal to determine monitoring state
     * Returns state of current node:
     * 0 -> Node is not monitored
     * 1 -> Node is monitored (by child camera or parent camera)
     * 2 -> Node has a camera
     * @param currentNode Current node being processed
     * @return Monitoring state of current node
     */
    private static int depthFirstSearch(TreeNode currentNode) {
        if (currentNode == null) {
            return 1; // Null nodes are considered "monitored"
        }
        
        int leftChildState = depthFirstSearch(currentNode.left);
        int rightChildState = depthFirstSearch(currentNode.right);
        
        // If any child is not monitored (state = 0), 
        // we MUST place a camera at current node
        if (leftChildState == 0 || rightChildState == 0) {
            totalCameraCount++;
            return 2; // Current node has camera
        }
        
        // If any child has a camera (state = 2),
        // current node is monitored by that camera
        if (leftChildState == 2 || rightChildState == 2) {
            return 1; // Current node is monitored
        }
        
        // Both children are monitored (state = 1)
        // Current node is NOT monitored (needs parent's camera or its own)
        return 0; // Not monitored
    }
    
    /**
     * Helper function to build tree from array (level-order)
     * @param nodeValues Array of node values in level-order (null for missing nodes)
     * @return Root node of the constructed tree
     */
    public static TreeNode buildTree(Integer[] nodeValues) {
        if (nodeValues == null || nodeValues.length == 0) return null;
        
        TreeNode rootNode = new TreeNode(nodeValues[0]);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);
        int valueIndex = 1;
        
        while (!nodeQueue.isEmpty() && valueIndex < nodeValues.length) {
            TreeNode currentNode = nodeQueue.poll();
            
            // Add left child
            if (valueIndex < nodeValues.length && nodeValues[valueIndex] != null) {
                currentNode.left = new TreeNode(nodeValues[valueIndex]);
                nodeQueue.add(currentNode.left);
            }
            valueIndex++;
            
            // Add right child
            if (valueIndex < nodeValues.length && nodeValues[valueIndex] != null) {
                currentNode.right = new TreeNode(nodeValues[valueIndex]);
                nodeQueue.add(currentNode.right);
            }
            valueIndex++;
        }
        
        return rootNode;
    }
    
    public static void main(String[] args) {
        // Test Case 1: [0,0,null,0,0]
        // Expected: 1
        // A camera at the node with 2 children covers itself and both children
        
        Integer[] testCase1Values = {0, 0, null, 0, 0};
        TreeNode testRoot1 = buildTree(testCase1Values);
        System.out.println("Test Case 1: " + minCameraCover(testRoot1));
        System.out.println("Expected: 1\n");
        
        // Test Case 2: [0] (Single node)
        // Expected: 1
        // Single node must have camera
        
        Integer[] testCase2Values = {0};
        TreeNode testRoot2 = buildTree(testCase2Values);
        System.out.println("Test Case 2: " + minCameraCover(testRoot2));
        System.out.println("Expected: 1\n");
        
        // Test Case 3: [0, 0, 0, null, null, null, 0]
        // Expected: 2
        // Need cameras at strategic positions to cover all nodes
        
        Integer[] testCase3Values = {0, 0, 0, null, null, null, 0};
        TreeNode testRoot3 = buildTree(testCase3Values);
        System.out.println("Test Case 3: " + minCameraCover(testRoot3));
        System.out.println("Expected: 2\n");
        
        // Additional Test Case 4: Linear chain
        // Expected: 1 or 2 depending on length
        
        Integer[] testCase4Values = {0, 0, null, 0, null, 0};
        TreeNode testRoot4 = buildTree(testCase4Values);
        System.out.println("Test Case 4 (Linear chain): " + minCameraCover(testRoot4));
        System.out.println("Expected: 2\n");
        
        // Additional Test Case 5: Complex tree
        
        Integer[] testCase5Values = {0, 0, 0, 0, 0};
        TreeNode testRoot5 = buildTree(testCase5Values);
        System.out.println("Test Case 5 (Complex tree): " + minCameraCover(testRoot5));
        System.out.println("Expected: 1");
    }
}
