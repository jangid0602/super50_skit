/*
 @filename - Main.java
 @description - Main Menu function
 @author - Kalp Mundra
 */

package Assignment_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== TREE ALGORITHMS MENU ==========");
            System.out.println("1. Palindromic Path");
            System.out.println("2. Vertical Silhouette (Vertical Traversal)");
            System.out.println("3. Distant Cousins");
            System.out.println("4. Minimum Camera Coverage");
            System.out.println("5. Serialize & Deserialize Binary Tree");
            System.out.println("6. Tree Path Maximum K-Sum");
            System.out.println("7. Boundary Traversal");
            System.out.println("8. LCA of a Set of Nodes");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    new Palindromic_path();
                    break;

                case 2:
                    new Horizontal_distance();
                    break;

                case 3:
                    new Distant_Cousins();
                    break;

                case 4:
                    new Minimum_Camera_Coverage();
                    break;

                case 5:
                    new Serialize_Deserialize_Tree();
                    break;

                case 6:
                    new Tree_Path_K_Sum();
                    break;

                case 7:
                    new Boundary_Traversal();
                    break;

                case 8:
                    new LCA_Of_Set();
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
