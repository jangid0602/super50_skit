import java.util.*;
public class GraphsSolutions {
    class Pair{
        int u;
        int cost;
        Pair(int u,int cost){
            this.u=u;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        int m = flights.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            list.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        q.add(new Pair(src,0));
        int steps=0;
        int costVal = 0;
        while(!q.isEmpty() && steps<=k){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair poppedPair = q.poll();
                int u=poppedPair.u;
                int cost=poppedPair.cost;

                for(Pair p : list.get(u)){
                    int v=p.u;
                    int price=p.cost;

                    if(cost+price<distance[v]){
                        distance[v]=cost+price;
                        q.add(new Pair(v,cost+price));
                    }
                }
            }
            steps++;
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    public int findMinimumRisk(int n, int[][] edges, int start, int end) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start]=0;
        int m = edges.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            list.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            list.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        q.add(new Pair(start,0));

        while(!q.isEmpty()){

                Pair poppedPair = q.poll();
                int u=poppedPair.u;
                int currRisk=poppedPair.cost;
                if (u == end) return currRisk;
                for(Pair p : list.get(u)){
                    int v=p.u;
                    int edgeRisk=p.cost;
                    int maxRisk = Math.max(currRisk,edgeRisk);
                    if(maxRisk<distance[v]){
                        distance[v]=maxRisk;
                        q.add(new Pair(v,maxRisk));
                    }
                }

        }
        return distance[end] == Integer.MAX_VALUE ? -1 : distance[end];
    }

    public int[] shortestDistance(int[][] matrix, int src) {
        int n = matrix.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            if (u == -1) break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && matrix[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + matrix[u][v] < dist[v]) {
                    dist[v] = dist[u] + matrix[u][v];
                }
            }
        }

        return dist;
    }
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            int[] indegree = new int[V];

            for (int i = 0; i < V; i++) {
                for (int v : adj.get(i)) {
                    indegree[v]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0)
                    q.add(i);
            }

            int count = 0;

            while (!q.isEmpty()) {
                int u = q.poll();
                count++;

                for (int v : adj.get(u)) {
                    indegree[v]--;
                    if (indegree[v] == 0)
                        q.add(v);
                }
            }

            return count != V;
        }

        public int shortestPathLength(int[][] graph) {
            int n = graph.length;
            int all = (1 << n) - 1;

            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[n][1 << n];

            for (int i = 0; i < n; i++) {
                int mask = 1 << i;
                q.add(new int[]{i, mask});
                visited[i][mask] = true;
            }

            int steps = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    int u = cur[0];
                    int mask = cur[1];

                    if (mask == all) return steps;

                    for (int v : graph[u]) {
                        int newMask = mask | (1 << v);
                        if (!visited[v][newMask]) {
                            visited[v][newMask] = true;
                            q.add(new int[]{v, newMask});
                        }
                    }
                }
                steps++;
            }
            return -1;
        }


}