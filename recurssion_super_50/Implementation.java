import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Implementation {

    // question 1

    // Doll structure
    static class Doll {
        int size;
        boolean hasKey;
        Doll inner;

        Doll(int size, boolean hasKey) {
            this.size = size;
            this.hasKey = hasKey;
            this.inner = null;
        }
    }

    // Create nested dolls
    public static Doll createDoll(int size, boolean hasKey) {
        if (size == 1) {
            return new Doll(1, hasKey); // smallest doll
        }

        Doll outer = new Doll(size, false);
        outer.inner = createDoll(size - 1, hasKey);
        return outer;
    }

    // Recursive function to find the key
    public static boolean findKey(Doll doll) {

        // base case
        if (doll.size == 1) {
            return doll.hasKey;
        }

        // recursive call on inner doll
        return findKey(doll.inner);
    }


    // question 2

    public static int Staircase(int n){
        if(n == 0) return 1;
        if(n < 1) return 0;
        int takeone = Staircase(n-1);
        int taketwo = Staircase(n-2);
        return takeone+taketwo;
    }

    // question 3
        static class Node {
        int wealth;
        Node left, right;

        Node(int wealth) {
            this.wealth = wealth;
            left = right = null;
        }
    }

    public static int calculateLegacy(Node root) {
        if (root == null) return 0;

        return root.wealth
                + calculateLegacy(root.left)
                + calculateLegacy(root.right);
    }

    // ---------- QUESTION 4 ----------

    public static boolean isPalindrome(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return isPalindrome(s, l + 1, r - 1);
    }

    // question 5

    //think in reverse manner end to start
    private static final int[] up = {-1,0};
    private static final int[] left = {0,-1};

    public static boolean Mazesolver(int[][] maze){
        int n = maze.length;
        // if end cell is blocked we unable to reach at the end so directly return false
        if(maze[n-1][n-1] == 0 ) return false;
        boolean[][] visited = new boolean[n][n];
        return dfsmaze(n-1,n-1,maze,visited);
    }

    private static boolean dfsmaze(int x,int y,int[][] maze,boolean[][] visited){
        if(x == 0 && y == 0) return true;   // base case 

        visited[x][y] = true;
         
        for(int k = 0;k<2;k++){
            int dx = x + up[k];
            int dy = y + left[k];

        if(dx >= 0 && dy >= 0 && maze[dx][dy] == 1 && !visited[dx][dy]){
            if(dfsmaze(dx, dy, maze,visited))
                return true;
        }
        }
        return false ;

    
    }

    // ---------- QUESTION 6 ----------
    public static void generateSubsets(String[] arr) {
        backtrackSubsets(arr, 0, new ArrayList<>());
    }

    private static void backtrackSubsets(String[] arr, int idx, List<String> curr) {
        System.out.println(curr);
        for (int i = idx; i < arr.length; i++) {
            curr.add(arr[i]);
            backtrackSubsets(arr, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    // ---------- QUESTION 7 ----------
    public static void generatePermutations(int[] nums) {
        permute(nums, 0);
    }

    private static void permute(int[] arr, int idx) {
        if (idx == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            permute(arr, idx + 1);
            swap(arr, i, idx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // ---------- QUESTION 8 ----------
    public static String compressString(String s) {
        if (s.length() == 0) return "";
        return compressHelper(s, 0, 1);
    }

    private static String compressHelper(String s, int idx, int count) {
        if (idx == s.length() - 1)
            return count + "" + s.charAt(idx);

        if (s.charAt(idx) == s.charAt(idx + 1))
            return compressHelper(s, idx + 1, count + 1);
        else
            return count + "" + s.charAt(idx) + compressHelper(s, idx + 1, 1);
    }

    // ---------- QUESTION 9 ----------
    public static void budgetHelper(int[] prices, int target) {
        budgetBacktrack(prices, target, 0, new ArrayList<>());
    }

    private static void budgetBacktrack(int[] prices, int target, int idx, List<Integer> curr) {
        if (target == 0) {
            System.out.println(curr);
            return;
        }
        if (target < 0 || idx == prices.length) return;

        curr.add(prices[idx]);
        budgetBacktrack(prices, target - prices[idx], idx, curr);
        curr.remove(curr.size() - 1);

        budgetBacktrack(prices, target, idx + 1, curr);
    }

    // ---------- QUESTION 10 ----------
    static class Task {
        String name;
        List<Task> subtasks = new ArrayList<>();
        Task(String n) { name = n; }
    }

    public static void printTasks(Task task, int level) {
        for (int i = 0; i < level; i++) System.out.print("  ");
        System.out.println(task.name);
        for (Task t : task.subtasks)
            printTasks(t, level + 1);
    }
}


