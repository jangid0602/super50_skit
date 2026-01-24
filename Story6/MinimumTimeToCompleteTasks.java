import java.util.*;

/**
 * @Filename- MinimumTimeToCompleteTasks.java
 * @Description- This is to find the minimum total time required to complete all tasks assuming tasks can run in parallel
 * @Author- Aman Jeet Singh
 */
public class MinimumTimeToCompleteTasks {

    public static int minimumTime(int n, int[] time, int[][] edges) {
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n];

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[from].add(to);
            inDegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] finishTime = new int[n];

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                finishTime[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : adjacencyList[current]) {
                finishTime[next] = Math.max(finishTime[next], finishTime[current] + time[next]);

                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        int totalTime = 0;
        for (int t : finishTime) {
            totalTime = Math.max(totalTime, t);
        }

        return totalTime;
    }

    public static void main(String[] args) {
        int n = InputUtil.getInt("Enter number of tasks: ");

        int[] time = new int[n];
        System.out.println("Enter time required for each task:");
        for (int i = 0; i < n; i++) {
            time[i] = InputUtil.getInt("Time for task " + i + ": ");
        }

        int m = InputUtil.getInt("Enter number of dependency edges: ");

        int[][] edges = new int[m][2];
        if (m > 0) {
            System.out.println("Enter dependencies (u v) meaning u must finish before v:");
            for (int i = 0; i < m; i++) {
                edges[i][0] = InputUtil.getInt("u: ");
                edges[i][1] = InputUtil.getInt("v: ");
            }
        }

        int result = minimumTime(n, time, edges);
        System.out.println("Minimum total time to complete all tasks: " + result);
    }
}
