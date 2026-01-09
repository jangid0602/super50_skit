/**
 * Filename- Main.java
 * Description- Recursion & Backtracking (Builder's Mindset).
 * Author - Nancy Jain
 * Date - 07/01/2026
 */
import java.util.*;
import tasks.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;
        int task_choice;
        do{
            System.out.println("1. The Russian Doll Mystery\r\n"+
            "2. The Staircase Architect\r\n"+
            "3. The Digital Ancestry Tree\r\n"+
            "4. The Word Mirror\r\n"+
            "5. The Maze Runner\r\n"+
            "6. The Perfect Team Assembly\r\n"+ 
            "7. The Secure Vault Code\r\n"+
            "8. The String Tiling Challenge\r\n"+
            "9. The Budget Calculator\r\n"+
            "10. The Project Builder's Blueprint\r\n"+
            "11. Quit\r\n");
            System.out.print("Enter your choice\n");
            task_choice = readInt(scanner);

            switch(task_choice){
                case 1:
                    // int[] sizes = {5,4,3,2,1};
                    // boolean[] open = {true,false,true,false,true};

                    System.out.println("Enter number of dolls.");
                    int dollNumber = readInt(scanner);
                    int[] sizes = new int[dollNumber];
                    boolean[] open = new boolean[dollNumber];
                    System.out.println("Enter sizes and open status (true/false):");
                    for(int i=0;i<dollNumber;i++){
                    System.out.print("Doll " + (i + 1) + " size: ");
                    sizes[i] = readInt(scanner);
                    System.out.print("Doll " + (i + 1) + " open (true/false): ");
                    open[i] = readBoolean(scanner);
                    }

                    int check = DollMystery.solve(sizes,open);
                    if(check!=0){
                        System.out.println("Key Found!");
                    }else {
                        System.out.println("Key not Found!");
                    }
                    System.out.println();
                    break;
                case 2:
                    //int stairCount = 3;

                    System.out.println("Enter number of stairs:");
                    int stairCount = readInt(scanner);

                    System.out.println("The total number of distinct ways he can reach the top is :" + Staircase.Architect(stairCount));
                    System.out.println();
                    break;
                case 3:
                    // tasks.TreeNode root = new tasks.TreeNode(100);
                    // root.left = new tasks.TreeNode(50);
                    // root.right = new tasks.TreeNode(50);

                    tasks.TreeNode root = TreeNode.buildTree();

                    int totalWealth = Ancestry.wealth(root);
                    System.out.println("The Total Legacy :"+ totalWealth);
                    System.out.println();
                    break;
                case 4:
                    //String word = "racecar";

                    System.out.println("Enter Word");
                    String word = scanner.nextLine();

                    boolean isWordMirror = WordMirror.palindrome(word);
                    if(isWordMirror){
                        System.out.println("The word \"" + word + "\" is a mirror word!");
                    }else {
                       System.out.println("The word \"" + word + "\" is a not mirror word!"); 
                    }
                    System.out.println();
                    break;
                case 5:
                    // int[][] maze = {
                    //     {1, 0, 0, 0},
                    //     {1, 1, 0, 1},
                    //     {0, 1, 0, 0},
                    //     {1, 1, 1, 1}
                    // };

                    System.out.println("Enter number of rows in maze:");
                    int rows = readInt(scanner);
                    System.out.println("Enter number of columns in maze:");
                    int columns = readInt(scanner);
                    int[][] maze = new int[rows][columns];
                    System.out.println("Enter values in 0 & 1 only");
                    for(int i=0;i<rows ;i++){
                        for(int j = 0; j < columns ; j++){
                            maze[i][j] = readInt(scanner);
                        }
                    }
                    
                    if (MazeRunner.path(maze)) {
                        System.out.println("Path exists!");
                    } else {
                        System.out.println("No path exists!");
                    }
                    System.out.println();
                    break;
                case 6:
                    //String[] members = {"DevA" , "DevB"};

                    System.out.println("Enter number of members:");
                    int countMembers = readInt(scanner);
                    String[] members = new String[countMembers];
                    System.out.println("Enter team members name:");
                    for(int i=0; i<countMembers ;i++){
                        members[i] = scanner.nextLine();
                    }

                    System.out.println("The  possible combination of team members that can be formed are :");
                    System.out.print(TeamAssembly.Team(members));

                    break;
                case 7:
                    System.out.println("All possible unique codes that can be formed are :");
                    System.out.println(VaultCode.generateCodes());
                    System.out.println();
                    break;
                case 8:
                    //String toCompress = "AAB";

                    System.out.println("Enter String to compress");
                    String toCompress = scanner.nextLine();
                    
                    String output = StringTiling.compress(toCompress);
                    System.out.println( "Compressed String :" + output);
                    System.out.println();
                    break;
                case 9:
                    // int [] Prices = {2,3};
                    // int target = 5;

                    System.out.println("Enter number of Prices:");
                    int number = readInt(scanner);
                    System.out.println("Enter Prices:");
                    int[] Prices = new int[number];
                    for(int i = 0 ; i < number ; i++){
                        Prices[i] = readInt(scanner);
                    }
                    System.out.println("Enter target sum : ");
                    int target = readInt(scanner);

                    System.out.println("Combinations of items that sum up to total budget are :" + tasks.BudgetCalculator.budget(Prices , target));
                    System.out.println();
                    break;
                case 10:
                    
                    TaskNode task = TaskManagement.buildTask(scanner);

                    System.out.println("The Task Heirarchy is as follows:");
                    TaskManagement.print(task);
                    System.out.println();
                    break;
                case 11:
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
