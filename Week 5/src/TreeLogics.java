import java.util.*;

/**
 * This class contains all the logic implementations for Week 5 tree-based
 * problems.
 * Includes solutions for palindromic paths, vertical silhouette, cousins,
 * cameras,
 * serialization, k-sum paths, boundary traversal, and LCA of sets.
 *
 * @author Bhavya Jain
 * @date 20 Jan 2026
 */

public class TreeLogics {

    // --- Q1: Palindromic Path Finder ---

    private int palindromicPathCount;

    public int countPalindromicPaths(TreeNode root) {
        if (root == null)
            return 0;
        palindromicPathCount = 0;
        dfsCountPalindromes(root, 0);
        return palindromicPathCount;
    }

    private void dfsCountPalindromes(TreeNode node, int pathMask) {
        if (node == null)
            return;

        // Toggle the bit for current character (using XOR)
        pathMask ^= (1 << (node.charVal - 'a'));

        // Count paths ending at this node that can form palindrome
        // A path can form palindrome if at most one character has odd frequency
        // This means pathMask should have at most one bit set
        if (isPalindromePossible(pathMask)) {
            palindromicPathCount++;
        }

        dfsCountPalindromes(node.left, pathMask);
        dfsCountPalindromes(node.right, pathMask);
    }

    private boolean isPalindromePossible(int mask) {
        // Check if at most one bit is set (mask is power of 2 or 0)
        return (mask & (mask - 1)) == 0;
    }

    public int countAllPalindromicDownwardPaths(TreeNode root) {
        if (root == null)
            return 0;
        int[] count = new int[1];
        countFromNode(root, count);
        return count[0];
    }

    private void countFromNode(TreeNode node, int[] count) {
        if (node == null)
            return;
        countPathsStartingHere(node, 0, count);
        countFromNode(node.left, count);
        countFromNode(node.right, count);
    }

    private void countPathsStartingHere(TreeNode node, int mask, int[] count) {
        if (node == null)
            return;
        mask ^= (1 << (node.charVal - 'a'));
        if (isPalindromePossible(mask))
            count[0]++;
        countPathsStartingHere(node.left, mask, count);
        countPathsStartingHere(node.right, mask, count);
    }

    // --- Q2: Vertical Silhouette ---

    public List<List<Integer>> verticalSilhouette(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        TreeMap<Integer, List<int[]>> columnMap = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[] { root, 0, 0 }); // node, HD, level

        while (!queue.isEmpty()) {
            Object[] data = queue.poll();
            TreeNode node = (TreeNode) data[0];
            int hd = (int) data[1];
            int level = (int) data[2];

            columnMap.computeIfAbsent(hd, k -> new ArrayList<>()).add(new int[] { level, node.val });

            if (node.left != null) {
                queue.offer(new Object[] { node.left, hd - 1, level + 1 });
            }
            if (node.right != null) {
                queue.offer(new Object[] { node.right, hd + 1, level + 1 });
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int hd : columnMap.keySet()) {
            List<int[]> nodes = columnMap.get(hd);
            nodes.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            List<Integer> column = new ArrayList<>();
            for (int[] pair : nodes) {
                column.add(pair[1]);
            }
            result.add(column);
        }

        return result;
    }

    // --- Q3: Distant Cousins ---

    public List<Integer> findCousins(TreeNode root, int x) {
        if (root == null)
            return new ArrayList<>();
        if (root.val == x)
            return new ArrayList<>();

        Map<Integer, Integer> depthMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();

        buildDepthAndParentMaps(root, null, 0, depthMap, parentMap);

        if (!depthMap.containsKey(x))
            return new ArrayList<>();

        int targetDepth = depthMap.get(x);
        int targetParent = parentMap.get(x);

        List<Integer> cousins = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : depthMap.entrySet()) {
            int nodeVal = entry.getKey();
            int depth = entry.getValue();
            if (depth == targetDepth && parentMap.get(nodeVal) != targetParent && nodeVal != x) {
                cousins.add(nodeVal);
            }
        }

        Collections.sort(cousins);
        return cousins;
    }

    private void buildDepthAndParentMaps(TreeNode node, TreeNode parent, int depth,
            Map<Integer, Integer> depthMap, Map<Integer, Integer> parentMap) {
        if (node == null)
            return;
        depthMap.put(node.val, depth);
        parentMap.put(node.val, parent != null ? parent.val : -1);
        buildDepthAndParentMaps(node.left, node, depth + 1, depthMap, parentMap);
        buildDepthAndParentMaps(node.right, node, depth + 1, depthMap, parentMap);
    }

    // --- Q4: Minimum Camera Coverage ---

    private int cameraCount;
    private static final int NOT_MONITORED = 0;
    private static final int HAS_CAMERA = 1;
    private static final int MONITORED = 2;

    public int minCameraCoverage(TreeNode root) {
        if (root == null)
            return 0;
        cameraCount = 0;
        int rootState = dfsCamera(root);
        if (rootState == NOT_MONITORED)
            cameraCount++;
        return cameraCount;
    }

    private int dfsCamera(TreeNode node) {
        if (node == null)
            return MONITORED;

        int leftState = dfsCamera(node.left);
        int rightState = dfsCamera(node.right);

        // If any child is not monitored, we need a camera here
        if (leftState == NOT_MONITORED || rightState == NOT_MONITORED) {
            cameraCount++;
            return HAS_CAMERA;
        }

        // If any child has a camera, this node is monitored
        if (leftState == HAS_CAMERA || rightState == HAS_CAMERA) {
            return MONITORED;
        }

        // Both children are monitored but don't have cameras
        return NOT_MONITORED;
    }

    // --- Q5: Serializer and Deserializer ---

    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.equals("null") || data.isEmpty())
            return null;
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        if (nodes.isEmpty())
            return null;
        String val = nodes.poll();
        if (val.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }

    // --- Q6: Tree Path Maximum K-Sum ---

    private int maxKSumLength;

    public int longestPathWithSumK(TreeNode root, int k) {
        if (root == null)
            return 0;
        maxKSumLength = 0;
        findKSumPaths(root, k);
        return maxKSumLength;
    }

    private void findKSumPaths(TreeNode node, int k) {
        if (node == null)
            return;
        findPathFromNode(node, k, 0, 0);
        findKSumPaths(node.left, k);
        findKSumPaths(node.right, k);
    }

    private void findPathFromNode(TreeNode node, int k, int currentSum, int length) {
        if (node == null)
            return;
        currentSum += node.val;
        length++;
        if (currentSum == k) {
            maxKSumLength = Math.max(maxKSumLength, length);
        }
        findPathFromNode(node.left, k, currentSum, length);
        findPathFromNode(node.right, k, currentSum, length);
    }

    // --- Q7: Boundary Traversal ---

    public List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        if (!isLeaf(root)) {
            result.add(root.val);
        }

        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root.right, result);

        return result;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result) {
        TreeNode current = node;
        while (current != null) {
            if (!isLeaf(current)) {
                result.add(current.val);
            }
            current = (current.left != null) ? current.left : current.right;
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(TreeNode node, List<Integer> result) {
        List<Integer> rightNodes = new ArrayList<>();
        TreeNode current = node;
        while (current != null) {
            if (!isLeaf(current)) {
                rightNodes.add(current.val);
            }
            current = (current.right != null) ? current.right : current.left;
        }
        Collections.reverse(rightNodes);
        result.addAll(rightNodes);
    }

    // --- Q8: LCA of a Set ---

    public TreeNode lowestCommonAncestorOfSet(TreeNode root, Set<Integer> nodes) {
        if (root == null || nodes == null || nodes.isEmpty())
            return null;
        if (nodes.size() == 1) {
            int target = nodes.iterator().next();
            return findNode(root, target);
        }
        return lcaHelper(root, nodes);
    }

    private TreeNode findNode(TreeNode root, int target) {
        if (root == null)
            return null;
        if (root.val == target)
            return root;
        TreeNode left = findNode(root.left, target);
        if (left != null)
            return left;
        return findNode(root.right, target);
    }

    private TreeNode lcaHelper(TreeNode node, Set<Integer> nodes) {
        if (node == null)
            return null;
        if (nodes.contains(node.val))
            return node;

        TreeNode leftLCA = lcaHelper(node.left, nodes);
        TreeNode rightLCA = lcaHelper(node.right, nodes);

        // If both subtrees return non-null, this node is the LCA
        if (leftLCA != null && rightLCA != null)
            return node;

        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
