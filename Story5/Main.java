/**
 * Filename- Main.java
 * Description- Trees.
 * Author - Nancy Jain
 * Date - 14/01/2026
 */
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;
        int task_choice;
        do{
            System.out.println("1. The Palindromic Path Finder\r\n"+
            "2. Binary Tree Vertical Silhouette\r\n"+
            "3. The Distant Cousins\r\n"+
            "4. Minimum Camera Coverage (Greedy)\r\r\n"+
            "5. Serializer and Deserializer\r\n"+
            "6. Tree Path Maximum K-Sum\r\n"+ 
            "7. Boundary Traversal\r\n"+
            "8. Lowest Common Ancestor (LCA) of a Set\r\n"+
            "9. Quit\r\n");
            System.out.print("Enter your choice\n");
            task_choice = readInt(scanner);

            switch(task_choice){
                case 1:
                    TreeNodeChar root = TreeNodeChar.buildTree();
                    System.out.println(PalindromicPath.path(root)+ "\n");
                    break;

                case 2:
                    TreeNodeChar rootTask2 = TreeNodeChar.buildTree();
                    System.out.println(VerticalSilhouette.assign(rootTask2)+ "\n");
                    break;

                case 3:

                    TreeNode rootTask3 = TreeNode.buildTree();
                    System.out.print("Enter X: ");
                    int x = scanner.nextInt();
                    System.out.println(DistantCousins.findCousins(rootTask3, x)+ "\n");
                    break;

                case 4:

                    TreeNode rootTask4 = TreeNode.buildTree();
                    CameraCoverage cc = new CameraCoverage();
                    System.out.println(cc.minCameraCover(rootTask4)+ "\n");
                    break;

                case 5:

                    TreeNodeChar rootTask5 = TreeNodeChar.buildTree();
                    String s = SerializerDeserializer.serialize(rootTask5);
                    System.out.println("Serialized: " + s);
                    TreeNodeChar newRoot = SerializerDeserializer.deserialize(s);
                    System.out.println("Serialized Again: " +
                    SerializerDeserializer.serialize(newRoot)+ "\n");
                    break;

                case 6:

                    TreeNode rootTask6 = TreeNode.buildTree();
                    System.out.print("Enter K: ");
                    int k = scanner.nextInt();
                    KSumPath ksp = new KSumPath();
                    System.out.println(ksp.longestKSumPath(rootTask6, k)+ "\n");
                    break;

                case 7:

                    TreeNodeChar rootTask7 = TreeNodeChar.buildTree();
                    System.out.println(BoundaryTraversal.boundaryTraversal(rootTask7)+ "\n");
                    break;

                case 8:

                    TreeNode rootTask8 = TreeNode.buildTree();

                    System.out.print("Enter number of nodes in set: ");
                    int m = scanner.nextInt();

                    Set<Integer> set = new HashSet<>();
                    System.out.println("Enter set values:");
                    for (int i = 0; i < m; i++) {
                        set.add(scanner.nextInt());
                    }

                    TreeNode lca = LCASet.findLCA(rootTask8, set);
                    System.out.println("LCA: " + lca.data + "\n");
                    break;

                case 9:
                    System.out.println("Do you want to exit? Enter 1 to exit!");
                    int confirmQuit = readInt(scanner);
                    if(confirmQuit == 1){
                        System.out.println("Exiting...");
                        running = false;
                    }
                    break;
                default:
                    System.out.println("Wrong Choice! Please enter again.");
                    System.out.println();
                    break;
            }
        }while(running);
    }
    private static int readInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine(); // consume rest of line
                return val;
            } else {
                String bad = scanner.nextLine(); // consume the invalid token/line
                System.out.println("Invalid entry: \"" + bad + "\" is not an integer."); 
                System.out.println("Please enter an integer value.");
            }
        }
    }
}
