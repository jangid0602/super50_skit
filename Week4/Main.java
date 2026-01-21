import java.util.Scanner;

/*
 * Week 4 Story – Recursion & Backtracking
 * Filename - Main.java
 * Author -  Rishu Sharma
 * Date - 11-Jan-2026
 * Description:
 * Menu-driven Java program implementing all 10 problems
 */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    handleRussianDoll(scanner);
                    break;

                case 2:
                    handleStaircase(scanner);
                    break;

                case 3:
                    handleDigitalAncestry(scanner);
                    break;

                case 4:
                    handleWordMirror(scanner);
                    break;

                case 5:
                    handleMazeRunner(scanner);
                    break;

                case 6:
                    handleTeamAssembly(scanner);
                    break;

                case 7:
                    handleVaultCode(scanner);
                    break;

                case 8:
                    handleStringTiling(scanner);
                    break;

                case 9:
                    handleBudgetCalculator(scanner);
                    break;

                case 10:
                    handleProjectBlueprint(scanner);
                    break;

                case 0:
                    System.out.println("Program exited successfully.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println();

        } while (choice != 0);

        scanner.close();
    }

    // MENU -------------------------
    private static void printMenu() {
        System.out.println("========= WEEK 4 STORY =========");
        System.out.println("1. Russian Doll Mystery");
        System.out.println("2. Staircase Architect");
        System.out.println("3. Digital Ancestry Tree");
        System.out.println("4. Word Mirror");
        System.out.println("5. Maze Runner");
        System.out.println("6. Perfect Team Assembly");
        System.out.println("7. Secure Vault Code");
        System.out.println("8. String Tiling Challenge");
        System.out.println("9. Budget Calculator");
        System.out.println("10. Project Builder Blueprint");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    // 1. RUSSIAN DOLL --------------------------
    private static void handleRussianDoll(Scanner scanner) {
        System.out.print("Enter doll size: ");
        int size = scanner.nextInt();
        openDoll(size);
    }

    private static void openDoll(int size) {
        if (size == 1) {
            System.out.println("Key Found!");
            return;
        }
        System.out.println("Opening doll size: " + size);
        openDoll(size - 1);
    }

    // 2. STAIRCASE -----------------------------
    private static void handleStaircase(Scanner scanner) {
        System.out.print("Enter number of steps: ");
        int steps = scanner.nextInt();
        System.out.println("Total ways: " + countWays(steps));
    }

    private static int countWays(int steps) {
        if (steps <= 1) {
            return 1;
        }
        return countWays(steps - 1) + countWays(steps - 2);
    }

    // 3. DIGITAL ANCESTRY ----------------------------------
    private static void handleDigitalAncestry(Scanner scanner) {
        System.out.print("Enter parent wealth: ");
        int parent = scanner.nextInt();
        System.out.print("Enter child 1 wealth: ");
        int childOne = scanner.nextInt();
        System.out.print("Enter child 2 wealth: ");
        int childTwo = scanner.nextInt();

        System.out.println("Total Legacy: " + calculateLegacy(parent, childOne, childTwo));
    }

    private static int calculateLegacy(int parent, int childOne, int childTwo) {
        return parent + childOne + childTwo;
    }

    // 4. WORD MIRROR ----------------------------------------
    private static void handleWordMirror(Scanner scanner) {
        System.out.print("Enter word: ");
        String word = scanner.next();
        System.out.println("Is Palindrome: " + isPalindrome(word, 0, word.length() - 1));
    }

    private static boolean isPalindrome(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindrome(text, start + 1, end - 1);
    }

    // 5. MAZE RUNNER -----------------------------------
    private static void handleMazeRunner(Scanner scanner) {
        System.out.print("Enter maze size N: ");
        int size = scanner.nextInt();

        int[][] maze = new int[size][size];
        System.out.println("Enter maze values (0 or 1):");

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                maze[row][col] = scanner.nextInt();
            }
        }

        System.out.println("Path Exists: " + findPath(maze, 0, 0));
    }

    private static boolean findPath(int[][] maze, int row, int col) {
        int size = maze.length;

        if (row >= size || col >= size || maze[row][col] == 0) {
            return false;
        }

        if (row == size - 1 && col == size - 1) {
            return true;
        }

        return findPath(maze, row + 1, col) || findPath(maze, row, col + 1);
    }

    // 6. TEAM ASSEMBLY ----------------------------------
    private static void handleTeamAssembly(Scanner scanner) {
        System.out.print("Enter number of developers: ");
        int count = scanner.nextInt();

        char[] developers = new char[count];
        System.out.println("Enter developer labels (A B C ...):");

        for (int index = 0; index < count; index++) {
            developers[index] = scanner.next().charAt(0);
        }

        generateSubsets(developers, 0, "");
    }

    private static void generateSubsets(char[] developers, int index, String current) {
        if (index == developers.length) {
            System.out.println("[" + current + "]");
            return;
        }

        generateSubsets(developers, index + 1, current);
        generateSubsets(developers, index + 1, current + developers[index]);
    }

    // 7. VAULT CODE ---------------------------------------
    private static void handleVaultCode(Scanner scanner) {
        System.out.print("Enter number of digits: ");
        int count = scanner.nextInt();

        int[] digits = new int[count];
        boolean[] used = new boolean[count];

        System.out.println("Enter digits:");
        for (int i = 0; i < count; i++) {
            digits[i] = scanner.nextInt();
        }

        generatePermutations(digits, used, "", 0);
    }

    private static void generatePermutations(int[] digits, boolean[] used, String code, int depth) {
        if (depth == digits.length) {
            System.out.println(code);
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                generatePermutations(digits, used, code + digits[i], depth + 1);
                used[i] = false;
            }
        }
    }

    // 8. STRING TILING --------------------------------------
    private static void handleStringTiling(Scanner scanner) {
        System.out.print("Enter string: ");
        String text = scanner.next();
        System.out.println("Compressed: " + compressString(text, 0, 1));
    }

    private static String compressString(String text, int index, int count) {
        if (index == text.length() - 1) {
            return count + "" + text.charAt(index);
        }

        if (text.charAt(index) == text.charAt(index + 1)) {
            return compressString(text, index + 1, count + 1);
        }

        return count + "" + text.charAt(index)
                + compressString(text, index + 1, 1);
    }

    // 9. BUDGET CALCULATOR --------------------------------
    private static void handleBudgetCalculator(Scanner scanner) {
        System.out.print("Enter number of items: ");
        int count = scanner.nextInt();

        int[] prices = new int[count];
        System.out.println("Enter prices:");

        for (int i = 0; i < count; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.print("Enter budget: ");
        int budget = scanner.nextInt();

        findCombinations(prices, budget, "", 0);
    }

    private static void findCombinations(int[] prices, int remaining, String result, int start) {
        if (remaining == 0) {
            System.out.println("[" + result + "]");
            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = start; i < prices.length; i++) {
            findCombinations(prices, remaining - prices[i], result + prices[i] + " ", i);
        }
    }

    // 10. PROJECT BLUEPRINT -------------------------------------
    private static void handleProjectBlueprint(Scanner scanner) {
        scanner.nextLine(); // clear buffer
        System.out.print("Enter main task: ");
        String mainTask = scanner.nextLine();

        System.out.print("Enter sub task: ");
        String subTask = scanner.nextLine();

        System.out.print("Enter sub-sub task: ");
        String subSubTask = scanner.nextLine();

        printTasks(mainTask, subTask, subSubTask);
    }

    private static void printTasks(String main, String sub, String subSub) {
        System.out.println(main);
        System.out.println("  " + sub);
        System.out.println("    " + subSub);
    }
}
