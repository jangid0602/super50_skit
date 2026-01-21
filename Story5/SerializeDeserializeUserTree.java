import java.util.*;


/**
 * @Filename-SerializeDeserializeUserTree.java
 * @Description- Serializes a binary tree to a string representation and deserializes it back.
 *               Uses level-order traversal with comma-separated values. Null nodes are
 *               represented as "null" in the serialized string, enabling complete tree reconstruction.
 * @Author-Aman Jeet Singh
 */




class Codec {

    /**
     * Serializes a binary tree to a comma-separated string using level-order traversal
     * @param rootNode Root node of the binary tree
     * @return Serialized string representation of the tree
     */
    public String serialize(TreeNode rootNode) {
        if (rootNode == null) return "";

        StringBuilder serializedString = new StringBuilder();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            if (currentNode == null) {
                serializedString.append("null,");
                continue;
            }
            serializedString.append(currentNode.val).append(",");
            nodeQueue.add(currentNode.left);
            nodeQueue.add(currentNode.right);
        }
        return serializedString.toString();
    }

    /**
     * Deserializes a comma-separated string back into a binary tree
     * @param serializedData String representation of the tree
     * @return Root node of the reconstructed binary tree
     */
    public TreeNode deserialize(String serializedData) {
        if (serializedData.isEmpty()) return null;

        String[] nodeValues = serializedData.split(",");
        TreeNode rootNode = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);

        int valueIndex = 1;
        while (!nodeQueue.isEmpty() && valueIndex < nodeValues.length) {
            TreeNode currentNode = nodeQueue.poll();

            if (!nodeValues[valueIndex].equals("null")) {
                currentNode.left = new TreeNode(Integer.parseInt(nodeValues[valueIndex]));
                nodeQueue.add(currentNode.left);
            }
            valueIndex++;

            if (valueIndex < nodeValues.length && !nodeValues[valueIndex].equals("null")) {
                currentNode.right = new TreeNode(Integer.parseInt(nodeValues[valueIndex]));
                nodeQueue.add(currentNode.right);
            }
            valueIndex++;
        }
        return rootNode;
    }
}

public class SerializeDeserializeUserTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode rootNode = TreeBuilder.buildTree(scanner);

        Codec treeCodec = new Codec();
        String serializedTree = treeCodec.serialize(rootNode);
        System.out.println("Serialized tree: " + serializedTree);
        TreeNode deserializedRoot = treeCodec.deserialize(serializedTree);
        System.out.println("Deserialized and re-serialized: " + treeCodec.serialize(deserializedRoot));

        scanner.close();
    }
}
