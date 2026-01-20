import java.util.*;

/**
 * Main class for Week 5 exercises with a menu-driven interface to run all
 * tree-based problems.
 *
 * @author Bhavya Jain
 * @date 20 Jan 2026
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final TreeLogics logic = new TreeLogics();

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> runPalindromicPathFinder();
                case 2 -> runVerticalSilhouette();
                case 3 -> runDistantCousins();
                case 4 -> runMinCameraCoverage();
                case 5 -> runSerializerDeserializer();
                case 6 -> runTreePathKSum();
                case 7 -> runBoundaryTraversal();
                case 8 -> runLCAOfSet();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("\n" + "=".repeat(60) + "\n");
        }
    }

    private static void displayMenu() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════╗
                ║              WEEK 5 - TREE PROBLEMS MENU                   ║
                ╠════════════════════════════════════════════════════════════╣
                ║  1. Palindromic Path Finder                                ║
                ║  2. Binary Tree Vertical Silhouette                        ║
                ║  3. The Distant Cousins                                    ║
                ║  4. Minimum Camera Coverage                                ║
                ║  5. Serializer and Deserializer                            ║
                ║  6. Tree Path Maximum K-Sum                                ║
                ║  7. Boundary Traversal                                     ║
                ║  8. LCA of a Set                                           ║
                ║  0. Exit                                                   ║
                ╚════════════════════════════════════════════════════════════╝
                """);
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    private static void runPalindromicPathFinder() {
        System.out.println("\n--- Palindromic Path Finder ---");
        System.out.println("Using example tree: root='a', left='b', right='a'");

        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('a');

        int count = logic.countAllPalindromicDownwardPaths(root);
        System.out.println("Number of palindromic paths: " + count);

        System.out.println("\nUsing skewed tree: a -> a -> a -> a (all 'a')");
        TreeNode skewed = new TreeNode('a');
        skewed.left = new TreeNode('a');
        skewed.left.left = new TreeNode('a');
        skewed.left.left.left = new TreeNode('a');

        int skewedCount = logic.countAllPalindromicDownwardPaths(skewed);
        System.out.println("Number of palindromic paths in skewed tree: " + skewedCount);
    }

    private static void runVerticalSilhouette() {
        System.out.println("\n--- Binary Tree Vertical Silhouette ---");
        System.out.println("Using tree: [3, 9, 20, null, null, 15, 7]");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        List<List<Integer>> result = logic.verticalSilhouette(root);

        System.out.println("Vertical Silhouette: " + result);

        System.out.println("\nUsing perfect binary tree: [1, 2, 3, 4, 5, 6, 7]");
        TreeNode perfect = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        List<List<Integer>> perfectResult = logic.verticalSilhouette(perfect);
        System.out.println("Vertical Silhouette: " + perfectResult);
    }

    private static void runDistantCousins() {
        System.out.println("\n--- The Distant Cousins ---");
        System.out.println("Using tree: [1, 2, 3, null, 4, null, 5], X=4");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, null, 4, null, 5 });
        List<Integer> cousins = logic.findCousins(root, 4);

        System.out.println("Cousins of node 4: " + cousins);

        System.out.println("\nUsing tree: [1, 2, 3, 4, null, null, 5], X=4");
        TreeNode root2 = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, null, null, 5 });
        List<Integer> cousins2 = logic.findCousins(root2, 4);
        System.out.println("Cousins of node 4: " + cousins2);
    }

    private static void runMinCameraCoverage() {
        System.out.println("\n--- Minimum Camera Coverage ---");
        System.out.println("Using tree: [0, 0, null, 0, 0]");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 0, 0, null, 0, 0 });
        int cameras = logic.minCameraCoverage(root);
        System.out.println("Minimum cameras needed: " + cameras);

        System.out.println("\nUsing single node tree: [0]");
        TreeNode single = new TreeNode(0);
        int singleCameras = logic.minCameraCoverage(single);
        System.out.println("Minimum cameras needed: " + singleCameras);

        System.out.println("\nUsing linear chain: 4 nodes");
        TreeNode chain = new TreeNode(0);
        chain.left = new TreeNode(0);
        chain.left.left = new TreeNode(0);
        chain.left.left.left = new TreeNode(0);
        int chainCameras = logic.minCameraCoverage(chain);
        System.out.println("Minimum cameras needed: " + chainCameras);
    }

    private static void runSerializerDeserializer() {
        System.out.println("\n--- Serializer and Deserializer ---");
        System.out.println("Using tree: [1, 2, 3, null, null, 4, 5]");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, null, null, 4, 5 });
        String serialized = logic.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = logic.deserialize(serialized);
        System.out.println("Deserialized root value: " + deserialized.val);
        System.out.println("Left child: " + deserialized.left.val);
        System.out.println("Right child: " + deserialized.right.val);

        System.out.println("\nRe-serializing deserialized tree: " + logic.serialize(deserialized));

        System.out.println("\nEmpty tree serialization: " + logic.serialize(null));
    }

    private static void runTreePathKSum() {
        System.out.println("\n--- Tree Path Maximum K-Sum ---");
        System.out.println("Using tree: [10, 5, -3, 3, 2, null, 11], K=8");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 10, 5, -3, 3, 2, null, 11 });
        int length = logic.longestPathWithSumK(root, 8);
        System.out.println("Longest path length with sum 8: " + length);

        System.out.println("\nUsing tree: [1, -1, 1], K=0");
        TreeNode root2 = TreeUtils.buildTree(new Integer[] { 1, -1, 1 });
        int length2 = logic.longestPathWithSumK(root2, 0);
        System.out.println("Longest path length with sum 0: " + length2);

        System.out.println("\nUsing tree: [5, 4, 8, 11, null, 13, 4], K=22");
        TreeNode root3 = TreeUtils.buildTree(new Integer[] { 5, 4, 8, 11, null, 13, 4 });
        int length3 = logic.longestPathWithSumK(root3, 22);
        System.out.println("Longest path length with sum 22: " + length3);
    }

    private static void runBoundaryTraversal() {
        System.out.println("\n--- Boundary Traversal ---");
        System.out.println("Using right-skewed tree: [1, null, 2, null, 3, null, 4]");

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        List<Integer> boundary = logic.boundaryTraversal(root);
        System.out.println("Boundary: " + boundary);

        System.out.println("\nUsing simple tree: [1, 2, 3]");
        TreeNode simple = TreeUtils.buildTree(new Integer[] { 1, 2, 3 });
        List<Integer> simpleBoundary = logic.boundaryTraversal(simple);
        System.out.println("Boundary: " + simpleBoundary);

        System.out.println("\nUsing complete tree: [1, 2, 3, 4, 5, 6, 7]");
        TreeNode complete = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        List<Integer> completeBoundary = logic.boundaryTraversal(complete);
        System.out.println("Boundary: " + completeBoundary);
    }

    private static void runLCAOfSet() {
        System.out.println("\n--- LCA of a Set ---");
        System.out.println("Using tree: [1, 2, 3, 4, 5, 6, 7], Set: {4, 5, 6}");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        Set<Integer> nodes = new HashSet<>(Arrays.asList(4, 5, 6));

        TreeNode lca = logic.lowestCommonAncestorOfSet(root, nodes);
        System.out.println("LCA of {4, 5, 6}: " + (lca != null ? lca.val : "null"));

        System.out.println("\nUsing tree: [1, 2, 3, 4, 5, 6, 7], Set: {2, 4, 8} (8 is child of 4)");
        TreeNode root2 = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        Set<Integer> nodes2 = new HashSet<>(Arrays.asList(2, 4, 8));
        TreeNode lca2 = logic.lowestCommonAncestorOfSet(root2, nodes2);
        System.out.println("LCA of {2, 4, 8}: " + (lca2 != null ? lca2.val : "null"));

        System.out.println("\nSingle node set: {5}");
        Set<Integer> singleSet = new HashSet<>(Collections.singletonList(5));
        TreeNode lca3 = logic.lowestCommonAncestorOfSet(root, singleSet);
        System.out.println("LCA of {5}: " + (lca3 != null ? lca3.val : "null"));
    }
}
