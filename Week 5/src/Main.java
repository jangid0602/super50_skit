import java.util.*;

/**
 * Main class for Week 5 exercises with a menu-driven interface to run all
 * tree-based problems.
 *
 * @author Bhavya Jain
 * @date 20 Jan 2026
 */
public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final TreeLogics logic = new TreeLogics();

    public static void main(String[] args) {
        Main app = new Main();
        while (true) {
            System.out.println("--- WEEK 5 - TREE PROBLEMS MENU ---");
            System.out.println("1. Palindromic Path Finder");
            System.out.println("2. Binary Tree Vertical Silhouette");
            System.out.println("3. The Distant Cousins");
            System.out.println("4. Minimum Camera Coverage");
            System.out.println("5. Serializer and Deserializer");
            System.out.println("6. Tree Path Maximum K-Sum");
            System.out.println("7. Boundary Traversal");
            System.out.println("8. LCA of a Set");
            System.out.println("0. Exit");
            System.out.println("---");

            System.out.print("Enter your choice: ");
            while (!app.scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer.");
                app.scanner.next();
                System.out.print("Enter your choice: ");
            }
            int choice = app.scanner.nextInt();

            String result = switch (choice) {
                case 1 -> app.runPalindromicPathFinder();
                case 2 -> app.runVerticalSilhouette();
                case 3 -> app.runDistantCousins();
                case 4 -> app.runMinCameraCoverage();
                case 5 -> app.runSerializerDeserializer();
                case 6 -> app.runTreePathKSum();
                case 7 -> app.runBoundaryTraversal();
                case 8 -> app.runLCAOfSet();
                case 0 -> null;
                default -> "Invalid choice. Please try again.";
            };

            if (choice == 0) {
                System.out.println("Goodbye!");
                return;
            }

            System.out.println(result);
            System.out.println();
        }
    }

    private String runPalindromicPathFinder() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Palindromic Path Finder ---\n");

        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('a');
        int count = logic.countAllPalindromicDownwardPaths(root);
        sb.append("Tree: root='a', left='b', right='a'\n");
        sb.append("Number of palindromic paths: ").append(count).append("\n");

        TreeNode skewed = new TreeNode('a');
        skewed.left = new TreeNode('a');
        skewed.left.left = new TreeNode('a');
        skewed.left.left.left = new TreeNode('a');
        int skewedCount = logic.countAllPalindromicDownwardPaths(skewed);
        sb.append("Skewed tree: a -> a -> a -> a\n");
        sb.append("Number of palindromic paths: ").append(skewedCount).append("\n");
        sb.append("---");
        return sb.toString();
    }

    private String runVerticalSilhouette() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Binary Tree Vertical Silhouette ---\n");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        List<List<Integer>> result = logic.verticalSilhouette(root);
        sb.append("Tree: [3, 9, 20, null, null, 15, 7]\n");
        sb.append("Vertical Silhouette: ").append(result).append("\n");

        TreeNode perfect = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        List<List<Integer>> perfectResult = logic.verticalSilhouette(perfect);
        sb.append("Tree: [1, 2, 3, 4, 5, 6, 7]\n");
        sb.append("Vertical Silhouette: ").append(perfectResult).append("\n");
        sb.append("---");
        return sb.toString();
    }

    private String runDistantCousins() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- The Distant Cousins ---\n");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, null, 4, null, 5 });
        List<Integer> cousins = logic.findCousins(root, 4);
        sb.append("Tree: [1, 2, 3, null, 4, null, 5], X=4\n");
        sb.append("Cousins of node 4: ").append(cousins).append("\n");

        TreeNode root2 = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, null, null, 5 });
        List<Integer> cousins2 = logic.findCousins(root2, 4);
        sb.append("Tree: [1, 2, 3, 4, null, null, 5], X=4\n");
        sb.append("Cousins of node 4: ").append(cousins2).append("\n");
        sb.append("---");
        return sb.toString();
    }

    private String runMinCameraCoverage() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Minimum Camera Coverage ---\n");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 0, 0, null, 0, 0 });
        int cameras = logic.minCameraCoverage(root);
        sb.append("Tree: [0, 0, null, 0, 0]\n");
        sb.append("Minimum cameras needed: ").append(cameras).append("\n");

        TreeNode single = new TreeNode(0);
        int singleCameras = logic.minCameraCoverage(single);
        sb.append("Single node tree: [0]\n");
        sb.append("Minimum cameras needed: ").append(singleCameras).append("\n");

        TreeNode chain = new TreeNode(0);
        chain.left = new TreeNode(0);
        chain.left.left = new TreeNode(0);
        chain.left.left.left = new TreeNode(0);
        int chainCameras = logic.minCameraCoverage(chain);
        sb.append("Linear chain: 4 nodes\n");
        sb.append("Minimum cameras needed: ").append(chainCameras).append("\n");
        sb.append("---");
        return sb.toString();
    }

    private String runSerializerDeserializer() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Serializer and Deserializer ---\n");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, null, null, 4, 5 });
        String serialized = logic.serialize(root);
        sb.append("Tree: [1, 2, 3, null, null, 4, 5]\n");
        sb.append("Serialized: ").append(serialized).append("\n");

        TreeNode deserialized = logic.deserialize(serialized);
        sb.append("Deserialized root value: ").append(deserialized.val).append("\n");
        sb.append("Left child: ").append(deserialized.left.val).append("\n");
        sb.append("Right child: ").append(deserialized.right.val).append("\n");
        sb.append("Re-serialized: ").append(logic.serialize(deserialized)).append("\n");
        sb.append("Empty tree serialization: ").append(logic.serialize(null)).append("\n");
        sb.append("---");
        return sb.toString();
    }

    private String runTreePathKSum() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Tree Path Maximum K-Sum ---\n");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 10, 5, -3, 3, 2, null, 11 });
        int length = logic.longestPathWithSumK(root, 8);
        sb.append("Tree: [10, 5, -3, 3, 2, null, 11], K=8\n");
        sb.append("Longest path length with sum 8: ").append(length).append("\n");

        TreeNode root2 = TreeUtils.buildTree(new Integer[] { 1, -1, 1 });
        int length2 = logic.longestPathWithSumK(root2, 0);
        sb.append("Tree: [1, -1, 1], K=0\n");
        sb.append("Longest path length with sum 0: ").append(length2).append("\n");

        TreeNode root3 = TreeUtils.buildTree(new Integer[] { 5, 4, 8, 11, null, 13, 4 });
        int length3 = logic.longestPathWithSumK(root3, 22);
        sb.append("Tree: [5, 4, 8, 11, null, 13, 4], K=22\n");
        sb.append("Longest path length with sum 22: ").append(length3).append("\n");
        sb.append("---");
        return sb.toString();
    }

    private String runBoundaryTraversal() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Boundary Traversal ---\n");

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        List<Integer> boundary = logic.boundaryTraversal(root);
        sb.append("Right-skewed tree: [1, null, 2, null, 3, null, 4]\n");
        sb.append("Boundary: ").append(boundary).append("\n");

        TreeNode simple = TreeUtils.buildTree(new Integer[] { 1, 2, 3 });
        List<Integer> simpleBoundary = logic.boundaryTraversal(simple);
        sb.append("Tree: [1, 2, 3]\n");
        sb.append("Boundary: ").append(simpleBoundary).append("\n");

        TreeNode complete = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        List<Integer> completeBoundary = logic.boundaryTraversal(complete);
        sb.append("Tree: [1, 2, 3, 4, 5, 6, 7]\n");
        sb.append("Boundary: ").append(completeBoundary).append("\n");
        sb.append("---");
        return sb.toString();
    }

    private String runLCAOfSet() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- LCA of a Set ---\n");

        TreeNode root = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        Set<Integer> nodes = new HashSet<>(Arrays.asList(4, 5, 6));
        TreeNode lca = logic.lowestCommonAncestorOfSet(root, nodes);
        sb.append("Tree: [1, 2, 3, 4, 5, 6, 7], Set: {4, 5, 6}\n");
        sb.append("LCA: ").append(lca != null ? lca.val : "null").append("\n");

        TreeNode root2 = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        Set<Integer> nodes2 = new HashSet<>(Arrays.asList(2, 4, 8));
        TreeNode lca2 = logic.lowestCommonAncestorOfSet(root2, nodes2);
        sb.append("Tree: [1, 2, 3, 4, 5, 6, 7, 8], Set: {2, 4, 8}\n");
        sb.append("LCA: ").append(lca2 != null ? lca2.val : "null").append("\n");

        Set<Integer> singleSet = new HashSet<>(Collections.singletonList(5));
        TreeNode lca3 = logic.lowestCommonAncestorOfSet(root, singleSet);
        sb.append("Set: {5}\n");
        sb.append("LCA: ").append(lca3 != null ? lca3.val : "null").append("\n");
        sb.append("---");
        return sb.toString();
    }
}
