/**
 * Filename - TreeNode.java
 * Description - Data Structure for Tree;
 * Author - Nancy Jain
 * Date - 14/01/2026
 */
import java.util.Scanner;

public class TreeNode {
    static Scanner scanner = new Scanner(System.in);
    public int data;
    public TreeNode left;
    public TreeNode right;
    public Integer val;
    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    } 

    public static TreeNode buildTree() {
        System.out.println("Enter node value:");
        int value = readInt(scanner);

        TreeNode node = new TreeNode(value);

        System.out.println("Does node " + value + " have a LEFT child? (true/false)");
        if (readBoolean(scanner)) {
            node.left = buildTree();
        }
        System.out.println("Does node " + value + " have a RIGHT child? (true/false)");
        if (readBoolean(scanner)) {
            node.right = buildTree();
        }
        
        return node;
    }

    //integer only
    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer:");
            scanner.nextLine();
        }
        int val = scanner.nextInt();
        scanner.nextLine();
        return val;
    }

    private static boolean readBoolean(Scanner scanner){
        while(true){
            if(scanner.hasNextBoolean()){
                boolean key = scanner.nextBoolean();
                scanner.nextLine();
                return key;
            } else {
                String bad = scanner.nextLine(); // consume the invalid token/line
                System.out.println("Invalid entry: \"" + bad + "\" is not a boolean."); 
                System.out.println("Please enter a true or false.");
            }
        }
    }
}
