#include<bits/stdc++.h>
using namespace std;


/**
 * @filename   : problem2.cpp
 * @description: //  path from node start to node end such that the path safety is minimized. Return the minimum possible risk value. 
 * @author     : Ehtesham Nawaz
 */

int minRiskPath(int n, vector<vector<int>>& edges, int start, int end) {
    vector<vector<pair<int, int>>> adj(n);
    for (const auto& edge : edges) {
        int u = edge[0], v = edge[1], risk = edge[2];
        adj[u].emplace_back(v, risk);
        adj[v].emplace_back(u, risk); // Undirected graph
    }

    vector<int> dist(n, INT_MAX);
    dist[start] = 0;

    using PII = pair<int, int>;
    priority_queue<PII, vector<PII>, greater<PII>> pq;
    pq.push({0, start});

    while (!pq.empty()) {
        auto [currentRisk, node] = pq.top();
        pq.pop();

        if (currentRisk > dist[node]) continue;

        for (const auto& [nextNode, risk] : adj[node]) {
            int newRisk = max(currentRisk, risk);
            if (newRisk < dist[nextNode]) {
                dist[nextNode] = newRisk;
                pq.push({newRisk, nextNode});
            }
        }
    }

    return dist[end] == INT_MAX ? -1 : dist[end];

}

int main(){

    vector<vector<int>> edges = {
        {0, 1, 4},
        {0, 2, 2},
        {1, 2, 5},
        {1, 3, 10},
        {2, 3, 3}
    };
    int n = 4; // number of nodes
    int start = 0; // start node
    int end = 3; // end node

    int result = minRiskPath(n, edges, start, end);
    cout << "Minimum possible risk value from node " << start << " to node " << end << " is: " << result << endl;

return 0;
}