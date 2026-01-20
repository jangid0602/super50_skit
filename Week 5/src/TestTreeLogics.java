import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for all Week 5 tree-based problems covering various edge cases and
 * scenarios.
 *
 * @author Bhavya Jain
 * @date 20 Jan 2026
 */
class TestTreeLogics {

    private TreeLogics logic;

    @Nested
    class PalindromicPathFinderTests {

        @BeforeEach
        void setUp() {
            logic = new TreeLogics();
        }

        @Test
        void testThreeNodesBasic() {
            // Tree: root='a', left='b', right='a'
            TreeNode root = new TreeNode('a');
            root.left = new TreeNode('b');
            root.right = new TreeNode('a');

            int result = logic.countAllPalindromicDownwardPaths(root);
            assertEquals(4, result); // [a], [b], [a], [a->a]
        }

        @Test
        void testSkewedAllSameChar() {
            // Linear tree: a -> a -> a -> a
            TreeNode root = new TreeNode('a');
            root.left = new TreeNode('a');
            root.left.left = new TreeNode('a');
            root.left.left.left = new TreeNode('a');

            int result = logic.countAllPalindromicDownwardPaths(root);
            assertEquals(10, result); // 4 single + 3 pairs + 2 triples + 1 quad
        }

        @Test
        void testThreeDifferentChars() {
            // Tree: root='a', left='b', right='c'
            TreeNode root = new TreeNode('a');
            root.left = new TreeNode('b');
            root.right = new TreeNode('c');

            int result = logic.countAllPalindromicDownwardPaths(root);
            assertEquals(3, result); // Only individual nodes [a], [b], [c]
        }

        @Test
        void testNullTree() {
            int result = logic.countAllPalindromicDownwardPaths(null);
            assertEquals(0, result);
        }

        @Test
        void testSingleNode() {
            TreeNode root = new TreeNode('z');
            int result = logic.countAllPalindromicDownwardPaths(root);
            assertEquals(1, result);
        }

        @Test
        void testPalindromeABA() {
            // Path a -> b -> a forms palindrome
            TreeNode root = new TreeNode('a');
            root.left = new TreeNode('b');
            root.left.left = new TreeNode('a');

            int result = logic.countAllPalindromicDownwardPaths(root);
            assertEquals(4, result); // [a], [b], [a], [a->b->a]
        }
    }

    @Nested
    class VerticalSilhouetteTests {

        @BeforeEach
        void setUp() {
            logic = new TreeLogics();
        }

        @Test
        void testBasicTree() {
            // [3,9,20,null,null,15,7]
            TreeNode root = TreeUtils.buildTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });

            List<List<Integer>> result = logic.verticalSilhouette(root);
            assertEquals(4, result.size());
            assertEquals(List.of(9), result.get(0));
            assertEquals(List.of(3, 15), result.get(1));
            assertEquals(List.of(20), result.get(2));
            assertEquals(List.of(7), result.get(3));
        }

        @Test
        void testPerfectBinaryTree() {
            // [1, 2, 3, 4, 5, 6, 7]
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });

            List<List<Integer>> result = logic.verticalSilhouette(root);
            assertEquals(5, result.size());
            assertEquals(List.of(4), result.get(0));
            assertEquals(List.of(2), result.get(1));
            assertEquals(List.of(1, 5, 6), result.get(2));
            assertEquals(List.of(3), result.get(3));
            assertEquals(List.of(7), result.get(4));
        }

        @Test
        void testLeftSkewedZigzag() {
            // [1, 2, null, 3, null, 4]
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, null, 3, null, 4 });

            List<List<Integer>> result = logic.verticalSilhouette(root);
            assertEquals(4, result.size());
            assertEquals(List.of(4), result.get(0));
            assertEquals(List.of(3), result.get(1));
            assertEquals(List.of(2), result.get(2));
            assertEquals(List.of(1), result.get(3));
        }

        @Test
        void testNullTree() {
            List<List<Integer>> result = logic.verticalSilhouette(null);
            assertTrue(result.isEmpty());
        }

        @Test
        void testSingleNode() {
            TreeNode root = new TreeNode(5);
            List<List<Integer>> result = logic.verticalSilhouette(root);
            assertEquals(1, result.size());
            assertEquals(List.of(5), result.get(0));
        }
    }

    @Nested
    class DistantCousinsTests {

        @BeforeEach
        void setUp() {
            logic = new TreeLogics();
        }

        @Test
        void testBasicCousins() {
            // [1,2,3,null,4,null,5]
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, null, 4, null, 5 });

            List<Integer> result = logic.findCousins(root, 4);
            assertEquals(List.of(5), result);
        }

        @Test
        void testCousinsSecondExample() {
            // [1, 2, 3, 4, null, null, 5]
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, null, null, 5 });

            List<Integer> result = logic.findCousins(root, 4);
            assertEquals(List.of(5), result);
        }

        @Test
        void testNoCousins() {
            // Root has no cousins
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3 });
            List<Integer> result = logic.findCousins(root, 1);
            assertTrue(result.isEmpty());
        }

        @Test
        void testSiblingNotCousin() {
            // Siblings should not be returned
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
            List<Integer> result = logic.findCousins(root, 4);
            assertEquals(List.of(6, 7), result); // 6, 7 are cousins, not 5
        }

        @Test
        void testNullTree() {
            List<Integer> result = logic.findCousins(null, 5);
            assertTrue(result.isEmpty());
        }

        @Test
        void testNodeNotFound() {
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3 });
            List<Integer> result = logic.findCousins(root, 99);
            assertTrue(result.isEmpty());
        }
    }

    @Nested
    class MinCameraCoverageTests {

        @BeforeEach
        void setUp() {
            logic = new TreeLogics();
        }

        @Test
        void testBasicTree() {
            // [0,0,null,0,0]
            TreeNode root = TreeUtils.buildTree(new Integer[] { 0, 0, null, 0, 0 });
            int result = logic.minCameraCoverage(root);
            assertEquals(1, result);
        }

        @Test
        void testSingleNode() {
            TreeNode root = new TreeNode(0);
            int result = logic.minCameraCoverage(root);
            assertEquals(1, result);
        }

        @Test
        void testLinearChain() {
            // [0, 0, 0, null, null, null, 0] interpreted as chain
            TreeNode root = new TreeNode(0);
            root.left = new TreeNode(0);
            root.left.left = new TreeNode(0);
            root.left.left.left = new TreeNode(0);

            int result = logic.minCameraCoverage(root);
            assertEquals(2, result);
        }

        @Test
        void testNullTree() {
            int result = logic.minCameraCoverage(null);
            assertEquals(0, result);
        }

        @Test
        void testTwoNodes() {
            TreeNode root = new TreeNode(0);
            root.left = new TreeNode(0);
            int result = logic.minCameraCoverage(root);
            assertEquals(1, result);
        }

        @Test
        void testBalancedTree() {
            TreeNode root = TreeUtils.buildTree(new Integer[] { 0, 0, 0, 0, 0, 0, 0 });
            int result = logic.minCameraCoverage(root);
            assertEquals(2, result);
        }
    }

    @Nested
    class SerializerDeserializerTests {

        @BeforeEach
        void setUp() {
            logic = new TreeLogics();
        }

        @Test
        void testBasicTree() {
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, null, null, 4, 5 });
            String serialized = logic.serialize(root);
            TreeNode deserialized = logic.deserialize(serialized);

            assertNotNull(deserialized);
            assertEquals(1, deserialized.val);
            assertEquals(2, deserialized.left.val);
            assertEquals(3, deserialized.right.val);
        }

        @Test
        void testEmptyTree() {
            String serialized = logic.serialize(null);
            assertEquals("null", serialized);
            TreeNode deserialized = logic.deserialize(serialized);
            assertNull(deserialized);
        }

        @Test
        void testLeftSkewedTree() {
            // [1, 2, null, 3, null, 4, null]
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(3);
            root.left.left.left = new TreeNode(4);

            String serialized = logic.serialize(root);
            TreeNode deserialized = logic.deserialize(serialized);

            assertNotNull(deserialized);
            assertEquals(1, deserialized.val);
            assertEquals(2, deserialized.left.val);
            assertEquals(3, deserialized.left.left.val);
            assertEquals(4, deserialized.left.left.left.val);
            assertNull(deserialized.right);
        }

        @Test
        void testSingleNode() {
            TreeNode root = new TreeNode(42);
            String serialized = logic.serialize(root);
            TreeNode deserialized = logic.deserialize(serialized);

            assertNotNull(deserialized);
            assertEquals(42, deserialized.val);
            assertNull(deserialized.left);
            assertNull(deserialized.right);
        }

        @Test
        void testRoundTrip() {
            TreeNode original = TreeUtils.buildTree(new Integer[] { 5, 3, 8, 1, 4, 7, 9 });
            TreeNode result = logic.deserialize(logic.serialize(original));

            assertEquals(original.val, result.val);
            assertEquals(original.left.val, result.left.val);
            assertEquals(original.right.val, result.right.val);
        }
    }

    @Nested
    class TreePathKSumTests {

        @BeforeEach
        void setUp() {
            logic = new TreeLogics();
        }

        @Test
        void testBasicKSum() {
            // [10, 5, -3, 3, 2, null, 11], K = 8
            TreeNode root = TreeUtils.buildTree(new Integer[] { 10, 5, -3, 3, 2, null, 11 });
            int result = logic.longestPathWithSumK(root, 8);
            assertEquals(2, result); // Path [5, 3]
        }

        @Test
        void testZeroSum() {
            // [1, -1, 1], K = 0
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, -1, 1 });
            int result = logic.longestPathWithSumK(root, 0);
            assertEquals(2, result); // Path [1, -1]
        }

        @Test
        void testLongerPath() {
            // [5, 4, 8, 11, null, 13, 4], K = 22
            TreeNode root = TreeUtils.buildTree(new Integer[] { 5, 4, 8, 11, null, 13, 4 });
            int result = logic.longestPathWithSumK(root, 22);
            assertEquals(3, result); // Path [5, 4, 11] or [5, 4, 13] -> [5,4,13] = 22
        }

        @Test
        void testNoPathFound() {
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3 });
            int result = logic.longestPathWithSumK(root, 100);
            assertEquals(0, result);
        }

        @Test
        void testNullTree() {
            int result = logic.longestPathWithSumK(null, 5);
            assertEquals(0, result);
        }

        @Test
        void testSingleNodeMatch() {
            TreeNode root = new TreeNode(7);
            int result = logic.longestPathWithSumK(root, 7);
            assertEquals(1, result);
        }
    }

    @Nested
    class BoundaryTraversalTests {

        @BeforeEach
        void setUp() {
            logic = new TreeLogics();
        }

        @Test
        void testRightSkewedTree() {
            // [1, null, 2, null, 3, null, 4]
            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.right = new TreeNode(3);
            root.right.right.right = new TreeNode(4);

            List<Integer> result = logic.boundaryTraversal(root);
            assertEquals(List.of(1, 2, 3, 4), result);
        }

        @Test
        void testSimpleThreeNode() {
            // [1, 2, 3]
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3 });
            List<Integer> result = logic.boundaryTraversal(root);
            assertEquals(List.of(1, 2, 3), result);
        }

        @Test
        void testCompleteTree() {
            // [1, 2, 3, 4, 5, 6, 7]
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
            List<Integer> result = logic.boundaryTraversal(root);
            // Left boundary: 1, 2; Leaves: 4, 5, 6, 7; Right boundary (reversed): 3
            assertEquals(List.of(1, 2, 4, 5, 6, 7, 3), result);
        }

        @Test
        void testNullTree() {
            List<Integer> result = logic.boundaryTraversal(null);
            assertTrue(result.isEmpty());
        }

        @Test
        void testSingleNode() {
            TreeNode root = new TreeNode(1);
            List<Integer> result = logic.boundaryTraversal(root);
            assertEquals(List.of(1), result);
        }

        @Test
        void testLeftSkewedTree() {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(3);

            List<Integer> result = logic.boundaryTraversal(root);
            assertEquals(List.of(1, 2, 3), result);
        }
    }

    @Nested
    class LCAOfSetTests {

        @BeforeEach
        void setUp() {
            logic = new TreeLogics();
        }

        @Test
        void testBasicLCA() {
            // Tree with nodes 1-7
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
            Set<Integer> nodes = new HashSet<>(Arrays.asList(4, 5, 6));

            TreeNode lca = logic.lowestCommonAncestorOfSet(root, nodes);
            assertEquals(1, lca.val); // 1 is LCA of nodes in both subtrees
        }

        @Test
        void testLCAInSameLineage() {
            // Nodes where one is ancestor of others
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 });
            Set<Integer> nodes = new HashSet<>(Arrays.asList(2, 4, 8));

            TreeNode lca = logic.lowestCommonAncestorOfSet(root, nodes);
            assertEquals(2, lca.val);
        }

        @Test
        void testSingleNodeSet() {
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5 });
            Set<Integer> nodes = new HashSet<>(Collections.singletonList(5));

            TreeNode lca = logic.lowestCommonAncestorOfSet(root, nodes);
            assertEquals(5, lca.val);
        }

        @Test
        void testNullTree() {
            TreeNode lca = logic.lowestCommonAncestorOfSet(null, new HashSet<>(Arrays.asList(1, 2)));
            assertNull(lca);
        }

        @Test
        void testEmptySet() {
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3 });
            TreeNode lca = logic.lowestCommonAncestorOfSet(root, new HashSet<>());
            assertNull(lca);
        }

        @Test
        void testTwoSiblings() {
            TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
            Set<Integer> nodes = new HashSet<>(Arrays.asList(4, 5));

            TreeNode lca = logic.lowestCommonAncestorOfSet(root, nodes);
            assertEquals(2, lca.val);
        }
    }
}
