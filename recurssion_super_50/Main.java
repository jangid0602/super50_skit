import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n Menu bar is :");
            System.out.println("1.The Russian Doll Mystery");
            System.out.println("2.The Staircase Architect");
            System.out.println("3.The Digital Ancestry Tree");
            System.out.println("4. The Word Mirror");
            System.out.println("5. The Maze Runner");
            System.out.println("6. The Perfect Team Assembly");
            System.out.println("7. The Secure Vault Code");
            System.out.println("8. The String Tiling Challenge");
            System.out.println("9. The Budget Calculator");
            System.out.println("10. The Project Builder's Blueprint");
            System.out.println("11.Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter size of outermost doll: ");
                    int size = sc.nextInt();

                    System.out.print("Does the smallest doll have the key? (true/false): ");
                    boolean hasKey = sc.nextBoolean();

                    Implementation.Doll doll = Implementation.createDoll(size, hasKey);

                    boolean found = Implementation.findKey(doll);

                    if (found) {
                        System.out.println("Key Found!");
                    } else {
                        System.out.println("Key Not Found!");
                    }
                    break;
                case 2:
                    System.out.println("Enter the no. of steps:");
                    int n2 = sc.nextInt();
                    int ways = Implementation.Staircase(n2);
                    System.out.println("Total ways: " + ways);
                    break;

                case 3:
                    Implementation.Node root = new Implementation.Node(100);
                    root.left = new Implementation.Node(50);
                    root.right = new Implementation.Node(50);
                    root.left.left = new Implementation.Node(40);
                    root.left.right = new Implementation.Node(50);

                    int legacy = Implementation.calculateLegacy(root);
                    System.out.println("Total Legacy: " + legacy);
                    break;
              
                case 4:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter word: ");
                    String word = sc.nextLine();
                    boolean pal = Implementation.isPalindrome(word, 0, word.length() - 1);
                    System.out.println("Palindrome: " + pal);
                    break;

                case 5:
                    System.out.println("Enter the size of the maze :");
                    int n = sc.nextInt();
                    int[][] maze = new int[n][n];
                    System.out.println("Enter the values of maze:(0,1)");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            maze[i][j] = sc.nextInt();
                        }
                    }

                    boolean result = Implementation.Mazesolver(maze);
                    if (result) {
                        System.out.println("Path exist..");
                    } else {
                        System.out.println("Path not exist");
                    }

                    break;

                case 6:
                    System.out.print("Enter team size: ");
                    int t = sc.nextInt();
                    sc.nextLine();

                    String[] team = new String[t];
                    for (int i = 0; i < t; i++) {
                        System.out.print("Enter member name: ");
                        team[i] = sc.nextLine();
                    }

                    Implementation.generateSubsets(team);
                    break;

                case 7:
                    System.out.print("Enter number of elements: ");
                    int k = sc.nextInt();

                    int[] nums = new int[k];
                    for (int i = 0; i < k; i++) {
                        System.out.print("Enter element: ");
                        nums[i] = sc.nextInt();
                    }

                    Implementation.generatePermutations(nums);
                    break;

                case 8:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter string: ");
                    String s = sc.nextLine();
                    System.out.println("Compressed: " + Implementation.compressString(s));
                    break;


                case 9:
                    System.out.print("Enter number of prices: ");
                    int p = sc.nextInt();

                    int[] prices = new int[p];
                    System.out.print("Enter price: ");
                    for (int i = 0; i < p; i++) {

                        prices[i] = sc.nextInt();
                    }

                    System.out.print("Enter target amount: ");
                    int target = sc.nextInt();

                    Implementation.budgetHelper(prices, target);
                    break;

                case 10:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter root task name: ");
                    String rootName = sc.nextLine();

                    Implementation.Task rootTask = new Implementation.Task(rootName);

                    System.out.print("Enter number of subtasks: ");
                    int st = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    for (int i = 0; i < st; i++) {
                        System.out.print("Enter subtask name: ");
                        rootTask.subtasks.add(new Implementation.Task(sc.nextLine()));
                    }

                    Implementation.printTasks(rootTask, 0);
                    break;
                case 11:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice ! choose right choice");
            }
        }
    }
}
