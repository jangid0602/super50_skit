// @filename - Method.java
// @description - Contains questions Methods(solutions) from topic Priority Queues (Heaps), Graphs - Adjacency Matrix/List and Traversals of Week 6 Story
// @author - Divyansh Tak

import java.util.*;

public class Method {

    //Minimum Time to Complete All Tasks
    static int minTimeTasks(int time[], int edges[][], int n) {

        int indegree[] = new int[n];
        int dp[] = new int[n];

        for(int i = 0;i < n;i++){

            dp[i] = time[i];
        }

        for(int i = 0;i < edges.length;i++){

            indegree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < n;i++) {

            if(indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {

            int u = q.poll();

            for(int i = 0;i < edges.length;i++) {

                if(edges[i][0] == u) {

                    int v = edges[i][1];

                    if(dp[u] + time[v] > dp[v])
                        dp[v] = dp[u] + time[v];

                    indegree[v]--;

                    if(indegree[v] == 0)
                        q.add(v);

                }
            }
        }

        int ans = 0;
        for(int i = 0;i < n;i++){

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    //Dijkstra Using Adjacency Matrix
    static int[] dijkstraMatrix(int graph[][], int src) {

        int n = graph.length;
        int dist[] = new int[n];
        boolean vis[] = new boolean[n];

        for(int i = 0;i < n;i++){

            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        for (int cnt = 0;cnt < n - 1;cnt++) {

            int u = -1, min = Integer.MAX_VALUE;

            for(int i = 0;i < n;i++) {

                if(!vis[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            if(u == -1)
                break;

            vis[u] = true;

            for(int v = 0;v < n;v++) {

                if(!vis[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {

                    if(dist[u] + graph[u][v] < dist[v])
                        dist[v] = dist[u] + graph[u][v];

                }
            }
        }

        return dist;
    }

    //Detect Cycle in Directed Graph 
    static boolean hasCycle(int n, int edges[][]) {

        int indegree[] = new int[n];

        for(int i = 0;i < edges.length;i++){

            indegree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < n;i++) {

            if (indegree[i] == 0)
                q.add(i);
        }

        int count = 0;

        while(!q.isEmpty()) {

            int u = q.poll();
            count++;

            for(int i = 0;i < edges.length;i++) {

                if(edges[i][0] == u) {

                    int v = edges[i][1];
                    indegree[v]--;

                    if(indegree[v] == 0)
                        q.add(v);

                }
            }
        }

        return count != n;
    }

    //Minimum Cost Path in Weighted Grid
    static int minCostGrid(int grid[][]) {

        int n = grid.length;
        int m = grid[0].length;

        int dist[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];

        for(int i = 0;i < n;i++){

            for (int j = 0; j < m; j++){

                dist[i][j] = Integer.MAX_VALUE;

            }

        }

        dist[0][0] = grid[0][0];

        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};

        for (int cnt = 0; cnt < n * m; cnt++) {

            int x = -1, y = -1, min = Integer.MAX_VALUE;

            for(int i = 0;i < n;i++) {

                for(int j = 0;j < m;j++) {

                    if(!vis[i][j] && dist[i][j] < min) {
                        min = dist[i][j];
                        x = i;
                        y = j;
                    }

                }
            }

            if (x == -1)
                break;

            vis[x][y] = true;

            for (int d = 0;d < 4;d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !vis[nx][ny]) {

                    if (dist[x][y] + grid[nx][ny] < dist[nx][ny])
                        dist[nx][ny] = dist[x][y] + grid[nx][ny];
                }
            }
        }

        return dist[n - 1][m - 1];
    }

    //Strongly Connected Components Count
    static int countSCC(int n, int edges[][]) {

        ArrayList<ArrayList<Integer>> list= new ArrayList<>();
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();

        for(int i = 0;i < n;i++) {
            list.add(new ArrayList<>());
            list1.add(new ArrayList<>());
        }

        for(int i = 0;i < edges.length;i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list1.get(edges[i][1]).add(edges[i][0]);
        }

        boolean vis[] = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i < n;i++){

            if (!vis[i]){
                dfs1(i, list, vis, st);
            }

        }

        for(int i = 0;i < n;i++){

            vis[i] = false;
        }

        int count = 0;
        while(!st.isEmpty()) {

            int v = st.pop();

            if (!vis[v]) {
                dfs2(v, list1, vis);
                count++;
            }

        }

        return count;
    }

    static void dfs1(int u, ArrayList<ArrayList<Integer>> list,boolean vis[], Stack<Integer> st) {

        vis[u] = true;

        for(int i = 0;i < list.get(u).size();i++) {

            int v = list.get(u).get(i);

            if(!vis[v]){
                dfs1(v, list, vis, st);
            }
        }

        st.push(u);
    }

    static void dfs2(int u, ArrayList<ArrayList<Integer>> list1, boolean vis[]) {

        vis[u] = true;

        for(int i = 0;i < list1.get(u).size();i++) {

            int v = list1.get(u).get(i);
            if (!vis[v]){
                dfs2(v,list1, vis);
            }
        }
    }
}


