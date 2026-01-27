#include <bits/stdc++.h>
using namespace std;

/**
 * @filename   : problem5.cpp
 * @description: Find k nearest servers from source s using Dijkstra
 * Example:
 * edges = [[0,1,2],[0,2,4],[1,2,1]], s = 0, k = 2 → [0,1]
 *  *  @author     : Ehtesham Nawaz
 */

vector<int> kNearestServer(int n, vector<vector<int>>& edges, int s, int k) {
    using PII = pair<int, int>; // {distance, node}

    vector<vector<pair<int, int>>> adj(n);
    for (auto &edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }

    vector<int> dist(n, INT_MAX);
    priority_queue<PII, vector<PII>, greater<PII>> pq;

    dist[s] = 0;
    pq.push({0, s});

    // Dijkstra
    while (!pq.empty()) {
        auto [currDist, node] = pq.top();
        pq.pop();

        if (currDist > dist[node]) continue;

        for (auto [nbr, weight] : adj[node]) {
            if (currDist + weight < dist[nbr]) {
                dist[nbr] = currDist + weight;
                pq.push({dist[nbr], nbr});
            }
        }
    }

   
    vector<pair<int, int>> serverDistances;
    for (int i = 0; i < n; i++) {
        serverDistances.push_back({dist[i], i});
    }

    sort(serverDistances.begin(), serverDistances.end());

    vector<int> result;
    for (int i = 0; i < k && i < n; i++) {
        result.push_back(serverDistances[i].second);
    }

    return result;
}

int main() {
    vector<vector<int>> edges = {{0,1,2},{0,2,4},{1,2,1}};
    int n = 3, s = 0, k = 2;

    vector<int> ans = kNearestServer(n, edges, s, k);
    for (int x : ans) cout << x << " ";
}
