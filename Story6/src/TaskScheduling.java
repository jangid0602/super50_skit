import java.util.*;
/**
 * @Filename- TaskScheduling.java
 * @Description-You are given n tasks and dependency relationships.
 * Each task has a completion time.
 * A task can be executed only after all its prerequisites are completed.
 * Find the minimum total time required to complete all tasks assuming tasks can run in
 * parallel.
 * @Author- Mayank
 */
public class TaskScheduling {
    public static int minTime(int[] time, int[][] edges) {
        int n = time.length;
        if (n == 0) return 0;

        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            inDegree[e[1]]++;
        }

        int[] totalTime = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                totalTime[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                totalTime[v] = Math.max(totalTime[v], totalTime[u] + time[v]);
                if (--inDegree[v] == 0) q.offer(v);
            }
        }

        int max = 0;
        for (int t : totalTime) max = Math.max(max, t);
        return max;
    }

    public static void main(String[] args) {
        Input input = new Input();
        System.out.print("Number of tasks: ");
        int n = input.inputInteger();
        int[] time = new int[n];
        for(int i=0; i<n; i++) {
            System.out.print("Time for task " + i + ": ");
            time[i] = input.inputInteger();
        }
        System.out.print("Number of dependencies: ");
        int d = input.inputInteger();
        int[][] edges = new int[d][2];
        for(int i=0; i<d; i++) {
            edges[i][0] = input.inputInteger(); // dependency
            edges[i][1] = input.inputInteger(); // target
        }
        System.out.println("Min total time: " + minTime(time, edges));
    }
}