import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("\n====== WEEK 4 : RECURSION & BACKTRACKING ======");
                System.out.println("1. Russian Doll Mystery (Find Key)");
                System.out.println("2. Staircase Architect");
                System.out.println("3. Digital Ancestry Tree");
                System.out.println("4. Word Mirror (Palindrome)");
                System.out.println("5. Maze Runner");
                System.out.println("6. Perfect Team Assembly (Subsets)");
                System.out.println("7. Secure Vault Code (Permutations)");
                System.out.println("8. String Tiling Challenge (Compression)");
                System.out.println("9. Budget Calculator (Combination Sum)");
                System.out.println("10. Project Builder Blueprint (Tasks)");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1 -> russianDoll();
                    case 2 -> staircase();
                    case 3 -> legacyTree();
                    case 4 -> palindromeCheck();
                    case 5 -> mazeRunner();
                    case 6 -> teamSubsets();
                    case 7 -> vaultPermutations();
                    case 8 -> stringCompression();
                    case 9 -> budgetCalculator();
                    case 10 -> taskHierarchy();
                    case 0 -> {
                        System.out.println("Exiting Program. Thank You!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter numbers only.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /* 1 */
    private static void russianDoll() {
        System.out.print("Enter number of dolls: ");
        int n = sc.nextInt();

        Doll inner = null;
        for (int i = 1; i <= n; i++) {
            boolean hasKey = (i == 1);
            inner = new Doll(i, hasKey, inner);
        }

        boolean result = Recursion.findKey(inner);
        System.out.println(result ? "Key Found!" : "Key Not Found");
    }

    /* 2 */
    private static void staircase() {
        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();
        System.out.println("Total ways: " + Recursion.climbStairs(n));
    }

    /* 3 */
    private static void legacyTree() {
        Recursion.Person root = new Recursion.Person(100);
        root.children.add(new Recursion.Person(50));
        root.children.add(new Recursion.Person(50));

        System.out.println("Total Legacy: " + Recursion.calculateLegacy(root));
    }

    /* 4 */
    private static void palindromeCheck() {
        System.out.print("Enter a word: ");
        String word = sc.nextLine();
        System.out.println("Palindrome: " + Recursion.isPalindrome(word));
    }

    /* 5 */
    private static void mazeRunner() {
        int[][] maze = {{1, 0}, {1, 1}};
        boolean pathExists = Recursion.mazePath(maze, 0, 0);
        System.out.println("Path Exists: " + pathExists);
    }

    /* 6 */
    private static void teamSubsets() {
        System.out.print("Enter number of developers: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<String> devs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter developer name: ");
            devs.add(sc.nextLine());
        }

        List<List<String>> result = new ArrayList<>();
        Recursion.generateSubsets(devs, 0, new ArrayList<>(), result);

        System.out.println("All possible teams:");
        System.out.println(result);
    }

    /* 7 */
    private static void vaultPermutations() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();

        Recursion.permute(nums, new boolean[nums.length],
                new ArrayList<>(), result);

        System.out.println("Vault Codes:");
        System.out.println(result);
    }

    /* 8 */
    private static void stringCompression() {
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        System.out.println("Compressed String: " + Recursion.compressString(s));
    }

    /*  9  */
    private static void budgetCalculator() {
        int[] prices = {2, 3};
        System.out.print("Enter budget: ");
        int budget = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();
        Recursion.combinationSum(prices, budget, 0,
                new ArrayList<>(), result);

        System.out.println("Valid Combinations:");
        System.out.println(result);
    }

    /*  10  */
    private static void taskHierarchy() {
        Recursion.Task main = new Recursion.Task("Fix Bugs");
        Recursion.Task ui = new Recursion.Task("UI Bugs");
        Recursion.Task btn = new Recursion.Task("Button Color");

        ui.subTasks.add(btn);
        main.subTasks.add(ui);

        System.out.println("Task Hierarchy:");
        Recursion.printTasks(main, 0);
    }
}
