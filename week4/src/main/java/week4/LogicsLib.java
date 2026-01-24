import java.util.ArrayList;
import java.util.List;

/**
 * This class contains most of the logics required for the stories of Week 4
 *
 * @author Bhavya Jain
 * @date 7 Jan 2025
 */

public class LogicsLib {
    public Key findKey(Doll russianDoll) {
        if (russianDoll == null) {
            throw new IllegalArgumentException("Russian Doll cannot be null");
        }

        russianDoll.open();
        if (russianDoll.hasKey()) {
            return new Key();
        }

        if (russianDoll.getInnerDoll() == null) {
            throw new IllegalStateException("No doll found with a key");
        }

        return findKey(russianDoll.getInnerDoll());
    }

    public int climbStairs(int stairs) {
        if (stairs <= 0)
            throw new IllegalArgumentException("Number of stairs must be greater than 0");
        if (stairs == 1)
            return 1;
        // return climbStairs(stairs-1) + climbStairs(stairs-2) // Fibonacci Style
        // Recursion
        // Optimised using memoization
        int[] steps = new int[stairs + 1];
        steps[0] = steps[1] = 1;
        for (int i = 2; i <= stairs; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[stairs];
    }

    public int calculateLegacy(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null");
        }

        int total = person.getWealth();

        for (Person child : person.getChildren()) {
            total += calculateLegacy(child); // Recursive call on each child
        }

        return total;
    }

    public boolean isMirrorWord(String word) {
        if (word == null)
            throw new IllegalArgumentException("Word cannot be null");
        if (word.isBlank() || word.length() == 1)
            return true;
        return mirrorCheckHelper(word, 0, word.length() - 1);
    }

    private boolean mirrorCheckHelper(String word, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (word.charAt(left) != word.charAt(right)) {
            return false;
        }
        return mirrorCheckHelper(word, left + 1, right - 1);
    }

    public boolean pathExists(int[][] maze) {
        if (maze == null)
            throw new IllegalArgumentException("Maze can not be null");
        int m = maze.length;
        int n = maze[0].length;
        return simulate(maze, 0, 0, m, n);
    }

    private boolean simulate(int[][] grid, int row, int col, int xSize, int ySize) {
        if (row == xSize - 1 && col == ySize - 1) {
            return true;
        }
        boolean right = false, down = false;
        if (row + 1 < xSize && grid[row + 1][col] == 1) {
            down = simulate(grid, row + 1, col, xSize, ySize);
        }
        if (col + 1 < ySize && grid[row][col + 1] == 1) {
            right = simulate(grid, row, col + 1, xSize, ySize);
        }
        return down || right;
    }

    public List<List<String>> assemblePerfectTeam(List<String> devs) {
        if (devs == null)
            throw new IllegalArgumentException("List of devs cannot be null");
        if (devs.isEmpty())
            return List.of(List.of());
        List<List<String>> devTeams = new ArrayList<>();
        int n = devs.size();
        assemble(devTeams, devs, new ArrayList<>(), 0, n);
        return devTeams;
    }

    private void assemble(List<List<String>> teamList, List<String> devs, List<String> team, int ind, int size) {
        if (ind == size) {
            List<String> temp = new ArrayList<>(team);
            teamList.add(temp);
            return;
        }
        team.add(devs.get(ind));
        assemble(teamList, devs, team, ind + 1, size);
        team.removeLast();
        assemble(teamList, devs, team, ind + 1, size);
    }

    public List<Integer> generateVaultCodes(int[] digits) {
        if (digits == null)
            throw new IllegalArgumentException("Digits cannot be null");
        if (digits.length == 0)
            return new ArrayList<>();
        List<Integer> codes = new ArrayList<>();
        boolean[] used = new boolean[digits.length];
        processCodes(digits, new ArrayList<>(), used, codes);
        return codes;
    }

    private void processCodes(int[] digits, List<Integer> current, boolean[] used, List<Integer> result) {
        if (current.size() == digits.length) {
            int code = 0;
            for (int digit : current) {
                code = code * 10 + digit;
            }
            result.add(code);
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(digits[i]);
                processCodes(digits, current, used, result);
                current.removeLast();
                used[i] = false;
            }
        }
    }

    public String tileString(String string) {
        if (string == null)
            throw new IllegalArgumentException("String cannot be null");
        StringBuilder copy = new StringBuilder(string);
        tileRecursive(copy, 0);
        return copy.toString();
    }

    private void tileRecursive(StringBuilder copy, int start) {
        if (start >= copy.length())
            return;
        int i = start;
        while (i < copy.length() && copy.charAt(i) == copy.charAt(start))
            i++;
        String replaceWith = (i - start) + "" + copy.charAt(start);
        copy.replace(start, i, replaceWith);
        tileRecursive(copy, start + replaceWith.length());
    }

    public List<List<Integer>> findCombinations(int[] prices, int budget) {
        if (prices == null) {
            throw new IllegalArgumentException("Prices array cannot be null.");
        }
        if (budget < 0) {
            throw new IllegalArgumentException("Budget cannot be negative.");
        }
        if (prices.length == 0 || budget == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(result, new ArrayList<>(), prices, budget, 0);
        return result;
    }

    private void generateCombinations(List<List<Integer>> result, List<Integer> currentCombination, int[] prices,
            int budget, int start) {
        if (budget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (budget < 0 || start >= prices.length)
            return;
        generateCombinations(result, currentCombination, prices, budget, start + 1);
        currentCombination.add(prices[start]);
        generateCombinations(result, currentCombination, prices, budget - prices[start], start);
        generateCombinations(result, currentCombination, prices, budget - prices[start], start + 1);
        currentCombination.removeLast();
    }

}
