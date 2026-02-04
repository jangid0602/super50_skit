import java.util.*;

/**
 * @Filename-VerticalSilhouette.java
 * @Description- Performs vertical order traversal of a binary tree, grouping nodes
 *               by their horizontal distance from the root. Root has HD=0, left children
 *               have HD-1, and right children have HD+1. Nodes at the same horizontal
 *               distance are sorted by level first, then by value.
 * @Author-Aman Jeet Singh
 */

public class VerticalSilhouette {
    
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Node wrapper to track: value, horizontal distance, level
     * Used for sorting at same HD
     */
    static class NodeInfo {
        int val;
        int hd;      // Horizontal Distance
        int level;   // Depth in tree
        
        NodeInfo(int val, int hd, int level) {
            this.val = val;
            this.hd = hd;
            this.level = level;
        }
    }
    
    /**
     * Vertical Order Traversal using BFS
     * Groups nodes by horizontal distance and sorts by level, then value
     * 
     * @param root The root of the binary tree
     * @return List of lists where each inner list contains values at same HD
     */
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;
        
        // Map: HD -> List of NodeInfo (value, level)
        Map<Integer, List<NodeInfo>> map = new TreeMap<>();
        
        // BFS with tracking of HD and level
        Queue<NodeWrapper> nodeQueue = new LinkedList<>();
        nodeQueue.add(new NodeWrapper(root, 0, 0)); // node, HD, level
        
        while (!nodeQueue.isEmpty()) {
            NodeWrapper currentNodeWrapper = nodeQueue.poll();
            TreeNode currentNode = currentNodeWrapper.node;
            int horizontalDistance = currentNodeWrapper.hd;
            int currentLevel = currentNodeWrapper.level;
            
            // Add node info to map
            map.putIfAbsent(horizontalDistance, new ArrayList<>());
            map.get(horizontalDistance).add(new NodeInfo(currentNode.val, horizontalDistance, currentLevel));
            
            // Process left child (HD - 1)
            if (currentNode.left != null) {
                nodeQueue.add(new NodeWrapper(currentNode.left, horizontalDistance - 1, currentLevel + 1));
            }
            
            // Process right child (HD + 1)
            if (currentNode.right != null) {
                nodeQueue.add(new NodeWrapper(currentNode.right, horizontalDistance + 1, currentLevel + 1));
            }
        }
        
        // Extract results from map, sorted by HD (automatic from TreeMap)
        for (int horizontalDistance : map.keySet()) {
            List<NodeInfo> nodesAtDistance = map.get(horizontalDistance);
            
            // Sort by level first, then by value
            Collections.sort(nodesAtDistance, (firstNode, secondNode) -> {
                if (firstNode.level != secondNode.level) {
                    return firstNode.level - secondNode.level; // Sort by level ascending
                }
                return firstNode.val - secondNode.val; // Sort by value ascending
            });
            
            // Extract values
            List<Integer> verticalColumn = new ArrayList<>();
            for (NodeInfo nodeInfo : nodesAtDistance) {
                verticalColumn.add(nodeInfo.val);
            }
            result.add(verticalColumn);
        }
        
        return result;
    }
    
    /**
     * Helper class for BFS queue
     */
    static class NodeWrapper {
        TreeNode node;
        int hd;      // Horizontal Distance
        int level;   // Level/Depth
        
        NodeWrapper(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }
    
    /**
     * Build tree from level-order array (with nulls for missing nodes)
     */
    /**
     * Builds a binary tree from level-order array representation
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
    
    /**
     * Print result in readable format
     */
    public static void printResult(List<List<Integer>> result) {
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        
        // Test Case 1: [3,9,20,null,null,15,7]
        // HD: -1(9), 0(3), -1(15), 1(20), 2(7)
        // Output: [[9],[3,15],[20],[7]]
        
        System.out.println("=== Test Case 1 ===");
        Integer[] testCase1Values = {3, 9, 20, null, null, 15, 7};
        TreeNode testRoot1 = buildTree(testCase1Values);
        List<List<Integer>> testResult1 = verticalTraversal(testRoot1);
        System.out.println("Input: [3,9,20,null,null,15,7]");
        System.out.println("Output: " + testResult1);
        System.out.println("Expected: [[9],[3,15],[20],[7]]");
        System.out.println();
        
        // Test Case 2: [1,2,3,4,5,6,7] (Perfect Binary Tree)
        // HD: -2(4), -1(2), 0(1,5,6), 1(3), 2(7)
        // Output: [[4],[2],[1,5,6],[3],[7]]
        
        System.out.println("=== Test Case 2 ===");
        Integer[] testCase2Values = {1, 2, 3, 4, 5, 6, 7};
        TreeNode testRoot2 = buildTree(testCase2Values);
        List<List<Integer>> testResult2 = verticalTraversal(testRoot2);
        System.out.println("Input: [1,2,3,4,5,6,7]");
        System.out.println("Output: " + testResult2);
        System.out.println("Expected: [[4],[2],[1,5,6],[3],[7]]");
        System.out.println();
        
        // Test Case 3: [1,2,null,3,null,4]
        // HD: -3(4), -2(3), -1(2), 0(1)
        // Output: [[4],[3],[2],[1]]
        
        System.out.println("=== Test Case 3 ===");
        Integer[] testCase3Values = {1, 2, null, 3, null, 4};
        TreeNode testRoot3 = buildTree(testCase3Values);
        List<List<Integer>> testResult3 = verticalTraversal(testRoot3);
        System.out.println("Input: [1,2,null,3,null,4]");
        System.out.println("Output: " + testResult3);
        System.out.println("Expected: [[4],[3],[2],[1]]");
        System.out.println();
        
        // Additional Test Case 4: Single node
        System.out.println("=== Test Case 4: Single Node ===");
        Integer[] testCase4Values = {5};
        TreeNode testRoot4 = buildTree(testCase4Values);
        List<List<Integer>> testResult4 = verticalTraversal(testRoot4);
        System.out.println("Input: [5]");
        System.out.println("Output: " + testResult4);
        System.out.println("Expected: [[5]]");
        System.out.println();
        
        // Additional Test Case 5: Right-skewed tree
        // HD: 0(1), 1(2), 2(3), 3(4)
        // Output: [[1],[2],[3],[4]]
        
        System.out.println("=== Test Case 5: Right-skewed ===");
        Integer[] testCase5Values = {1, null, 2, null, 3, null, 4};
        TreeNode testRoot5 = buildTree(testCase5Values);
        List<List<Integer>> testResult5 = verticalTraversal(testRoot5);
        System.out.println("Input: [1,null,2,null,3,null,4]");
        System.out.println("Output: " + testResult5);
        System.out.println("Expected: [[1],[2],[3],[4]]");
        System.out.println();
        
        // Additional Test Case 6: Duplicate values at same HD but different levels
        // HD: -2(4), -1(2,5), 0(1), 1(3,5), 2(6)
        // Note: At HD=1, we have level 2 value 3 and level 3 value 5, sorted by level
        
        System.out.println("=== Test Case 6: Duplicate values (different levels) ===");
        TreeNode testRoot6 = new TreeNode(1);
        testRoot6.left = new TreeNode(2);
        testRoot6.right = new TreeNode(3);
        testRoot6.left.left = new TreeNode(4);
        testRoot6.left.right = new TreeNode(5);
        testRoot6.right.left = new TreeNode(5);
        testRoot6.right.right = new TreeNode(6);
        
        List<List<Integer>> testResult6 = verticalTraversal(testRoot6);
        System.out.println("Output: " + testResult6);
    }
}
