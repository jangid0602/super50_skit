import java.util.*;


/**
 * @Filename-SerializeDeserializeUserTree.java
 * @Description- This is To convert a tree to serializer and then deserialize it
 * @Author-Arman Agrawal
 */




class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("null,");
                continue;
            }
            sb.append(curr.val).append(",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            if (!arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && !arr[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

public class SerializeDeserializeUserTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = TreeBuilder.buildTree(sc);

        Codec codec = new Codec();
        String s = codec.serialize(root);
        System.out.println(s);
        TreeNode r = codec.deserialize(s);
        System.out.println(codec.serialize(r));

        sc.close();
    }
}
