
/**
 * Filename - TreeNodeChar.java
 * Description - Data Structure for Tree consisting of alphabets;
 * Author - Nancy Jain
 * Date - 14/01/2026
 */
import java.util.Scanner;

public class TreeNodeChar {
    static Scanner scanner = new Scanner(System.in);
    public Character data;
    public TreeNodeChar left;
    public TreeNodeChar right;

    public TreeNodeChar(Character data){
        this.data = data;
        this.left = null;
        this.right = null;
    } 

    public static TreeNodeChar buildTree() {
        System.out.println("Enter node value:");
        char value = scanner.next().charAt(0);

        TreeNodeChar node = new TreeNodeChar(value);

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
