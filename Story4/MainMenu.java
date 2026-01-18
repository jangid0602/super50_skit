import java.util.*;

/**
 * @Filename-MainMenu.java
 * @Description- This is the entry point of our code 
 * @Author-Arman Agrawal
 */

public class MainMenu {

    public static void main(String[] args) {

        InputUtils input = new InputUtils();

        while (true) {
            System.out.println("\n===== WEEK 4 MENU =====");
            System.out.println("1. Russian Doll Mystery");
            System.out.println("2. Staircase Architect");
            System.out.println("3. Digital Ancestry Tree");
            System.out.println("4. Word Mirror");
            System.out.println("5. Maze Runner");
            System.out.println("6. Perfect Team Assembly");
            System.out.println("7. Secure Vault Code");
            System.out.println("8. String Compression");
            System.out.println("9. Budget Calculator");

            System.out.println("0. Exit");

            int choice = input.readInt("Choose option: ");

            switch (choice) {

               
                case 1 -> {
                    int totalDolls = input.readInt("Enter number of dolls: ");

                    Doll inner = null;

                    for (int i = totalDolls; i >= 1; i--) {
                        boolean hasKey =
                                input.readBoolean("Does doll " + i + " have key?");
                        inner = new Doll(hasKey, inner);
                    }

                    boolean result = RussianDoll.findKey(inner);
                    System.out.println(result ? "Key Found!" : "Key Not Found");
                }

                case 2 -> {
                    int steps = input.readInt("Enter number of steps: ");
                    System.out.println(
                            "Total Ways: " +
                                    StaircaseArchitect.countWays(steps));
                }

                case 3 -> {
                    System.out.println("\n=== DIGITAL ANCESTRY TREE INPUT ===");

                    Person root =
                            DigitalAncestry.buildFamilyTree(input);

                    int totalLegacy =
                            DigitalAncestry.calculateLegacy(root);

                    System.out.println("\nTotal Legacy: " + totalLegacy);
                }


                case 4 -> {
                    String word = input.readString("Enter word: ");
                    System.out.println(
                            WordMirror.isPalindrome(
                                    word, 0, word.length() - 1));
                }

                case 5 -> {
                    int n = input.readInt("Enter maze size: ");
                    int[][] maze = input.readMatrix(n);

                    System.out.println(
                            MazeRunner.isPathExists(maze, 0, 0));
                }

                case 6 -> {
                    int n = input.readInt("Number of developers: ");
                    String[] devs = input.readStringArray(n);

                    List<List<String>> teams = new ArrayList<>();
                    TeamAssembly.generateTeams(
                            devs, 0, new ArrayList<>(), teams);

                    System.out.println("All possible teams:");
                    System.out.println(teams);
                }

                case 7 -> {
                    int[] digits = input.readIntArray(3);

                    List<List<Integer>> codes = new ArrayList<>();
                    SecureVault.generateCodes(
                            digits,
                            new boolean[digits.length],
                            new ArrayList<>(),
                            codes);

                    System.out.println("Possible Codes:");
                    System.out.println(codes);
                }

                case 8 -> {
                    String text = input.readString("Enter string: ");
                    System.out.println(
                            StringCompression.compress(text, 0));
                }

                case 9 -> {
                    int n = input.readInt("Number of items: ");
                    int[] prices = input.readIntArray(n);
                    int budget = input.readInt("Enter budget: ");

                    List<List<Integer>> result = new ArrayList<>();
                    BudgetCalculator.findCombinations(
                            prices, budget, 0,
                            new ArrayList<>(), result);

                    System.out.println("Valid combinations:");
                    System.out.println(result);
                }

                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default ->
                        System.out.println("Invalid choice");
            }
        }
    }
}
