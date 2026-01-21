import java.util.*;

/*
   1. Russian Doll Mystery
    */
class Doll {
    int size;
    boolean hasKey;
    Doll inner;

    Doll(int size, boolean hasKey, Doll inner) {
        this.size = size;
        this.hasKey = hasKey;
        this.inner = inner;
    }
}

public class Recursion {

    public static boolean findKey(Doll doll) {
        if (doll == null) return false;

        if (doll.inner == null) {
            return doll.hasKey;
        }
        return findKey(doll.inner);
    }

    /*
       2. Staircase Architect
        */
    public static int climbStairs(int n) {
        if (n <= 1) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /*
       3. Digital Ancestry Tree
        */
    static class Person {
        int wealth;
        List<Person> children;

        Person(int wealth) {
            this.wealth = wealth;
            this.children = new ArrayList<>();
        }
    }

    public static int calculateLegacy(Person person) {
        if (person == null) return 0;

        int total = person.wealth;
        for (Person child : person.children) {
            total += calculateLegacy(child);
        }
        return total;
    }

    /*
       4. Word Mirror
        */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindrome(s.substring(1, s.length() - 1));
    }

    /*
       5. Maze Runner
        */
    public static boolean mazePath(int[][] maze, int i, int j) {
        int n = maze.length;

        if (i < 0 || j < 0 || i >= n || j >= n || maze[i][j] == 0)
            return false;

        if (i == n - 1 && j == n - 1)
            return true;

        maze[i][j] = 0; // mark visited

        return mazePath(maze, i + 1, j) || mazePath(maze, i, j + 1);
    }

    /*
       6. Perfect Team Assembly
        */
    public static void generateSubsets(List<String> devs, int index,
                                       List<String> current,
                                       List<List<String>> result) {
        if (index == devs.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        generateSubsets(devs, index + 1, current, result);

        current.add(devs.get(index));
        generateSubsets(devs, index + 1, current, result);
        current.remove(current.size() - 1);
    }

    /*
       7. Secure Vault Code
        */
    public static void permute(int[] nums, boolean[] used,
                               List<Integer> current,
                               List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);

                permute(nums, used, current, result);

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    /*
       8. String Tiling Challenge
        */
    public static String compressString(String s) {
        if (s.length() == 0) return "";

        char ch = s.charAt(0);
        int count = 1;

        int i = 1;
        while (i < s.length() && s.charAt(i) == ch) {
            count++;
            i++;
        }

        return count + "" + ch + compressString(s.substring(i));
    }

    /*
       9. Budget Calculator
       */
    public static void combinationSum(int[] prices, int target, int index,
                                      List<Integer> current,
                                      List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index == prices.length) return;

        current.add(prices[index]);
        combinationSum(prices, target - prices[index], index, current, result);
        current.remove(current.size() - 1);

        combinationSum(prices, target, index + 1, current, result);
    }

    /*
       10. Project Builder Blueprint
       */
    static class Task {
        String name;
        List<Task> subTasks = new ArrayList<>();

        Task(String name) {
            this.name = name;
        }
    }

    public static void printTasks(Task task, int level) {
        if (task == null) return;

        System.out.println("  ".repeat(level) + task.name);
        for (Task sub : task.subTasks) {
            printTasks(sub, level + 1);
        }
    }
}
