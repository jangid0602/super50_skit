import java.util.*;

/**
 * @Filename-PalindromicPathFinder.java
 * @Description- Finds the number of downward paths in a tree where characters 
 *               can be rearranged to form a palindrome. Uses bitmask technique
 *               to efficiently track character frequency parity. A path forms
 *               a palindrome if at most one character has an odd frequency.
 * @Author-Aman Jeet Singh
 */

public class PalindromicPathFinder {
    
    static class TreeNode {
        char val;
        List<TreeNode> children;
        
        TreeNode(char val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }
    
    /**
     * Find all downward paths that can form a palindrome
     * Key Insight: A string forms a palindrome if at most ONE character has odd frequency
     * We use a bitmask to track character parity (odd/even count)
     * 
     * @param root The root of the tree
     * @return Number of palindromic paths
     */
    public static int palindromicPaths(TreeNode root) {
        int[] totalPalindromicPathCount = {0};
        depthFirstSearch(root, 0, totalPalindromicPathCount);
        return totalPalindromicPathCount[0];
    }
    
    /**
     * DFS traversal to explore all downward paths
     * characterParityBitmask uses XOR to toggle bits representing character parities
     */
    private static void depthFirstSearch(TreeNode currentNode, int characterParityBitmask, int[] totalPalindromicPathCount) {
        if (currentNode == null) return;
        
        // Toggle bit for current node's character
        // XOR flips the bit: if char appeared even times, mark odd; if odd, mark even
        characterParityBitmask ^= (1 << (currentNode.val - 'a'));
        
        // Check if current path can form palindrome
        // A palindrome path has at most one character with odd frequency
        if (isPalindromic(characterParityBitmask)) {
            totalPalindromicPathCount[0]++;
        }
        
        // Continue DFS to all children (downward paths only)
        for (TreeNode childNode : currentNode.children) {
            depthFirstSearch(childNode, characterParityBitmask, totalPalindromicPathCount);
        }
    }
    
    /**
     * Check if a bitmask represents a palindromic character frequency
     * A bitmask is palindromic if it has at most 1 bit set
     * 
     * Trick: (characterParityBitmask & (characterParityBitmask - 1)) == 0 checks if at most 1 bit is set
     * Examples:
     * - characterParityBitmask=0 (000): 0 & -1 = 0 ✓ (all even)
     * - characterParityBitmask=1 (001): 1 & 0 = 0 ✓ (one odd)
     * - characterParityBitmask=3 (011): 3 & 2 = 2 ✗ (two odds)
     */
    private static boolean isPalindromic(int characterParityBitmask) {
        return (characterParityBitmask & (characterParityBitmask - 1)) == 0;
    }
    
    public static void main(String[] args) {
        // Test Case 1: 3 nodes
        // Expected Output: 4
        // Paths: [a], [b], [a], [a->a]
        
        TreeNode testRoot1 = new TreeNode('a');
        TreeNode testNode1_Left = new TreeNode('b');
        TreeNode testNode1_Right = new TreeNode('a');
        testRoot1.children.add(testNode1_Left);
        testRoot1.children.add(testNode1_Right);
        
        System.out.println("Test Case 1: " + palindromicPaths(testRoot1)); 
        System.out.println("Expected: 4\n");
        
        // Test Case 2: 4 nodes (Skewed - Linear)
        // Expected Output: 10
        // All single node paths: 4
        // All 2-node paths: 3 (even count of 'a' = palindrome)
        // All 3-node paths: 2 (odd count of 'a' = palindrome)
        // All 4-node paths: 1 (even count of 'a' = palindrome)
        // Total: 4 + 3 + 2 + 1 = 10
        
        TreeNode testRoot2 = new TreeNode('a');
        TreeNode testNode2_Level1 = new TreeNode('a');
        TreeNode testNode2_Level2 = new TreeNode('a');
        TreeNode testNode2_Level3 = new TreeNode('a');
        testRoot2.children.add(testNode2_Level1);
        testNode2_Level1.children.add(testNode2_Level2);
        testNode2_Level2.children.add(testNode2_Level3);
        
        System.out.println("Test Case 2: " + palindromicPaths(testRoot2)); 
        System.out.println("Expected: 10\n");
        
        // Test Case 3: 3 nodes
        // Expected Output: 3
        // Only individual nodes can form palindromes: [a], [b], [c]
        // Multi-node paths have different characters, can't form palindrome
        
        TreeNode testRoot3 = new TreeNode('a');
        TreeNode testNode3_Left = new TreeNode('b');
        TreeNode testNode3_Right = new TreeNode('c');
        testRoot3.children.add(testNode3_Left);
        testRoot3.children.add(testNode3_Right);
        
        System.out.println("Test Case 3: " + palindromicPaths(testRoot3)); 
        System.out.println("Expected: 3");
    }
}
