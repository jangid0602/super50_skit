/**
 * @filename - story6.cpp
 * @description - Detect cycle in directed graph using BFS
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

bool hasCycle(int nodes, vector<vector<int>>& graph) {
    vector<int> indegree(nodes, 0);
    
    // Calculate indegree for each node
    for (int i = 0; i < nodes; i++) {
        for (int neighbor : graph[i]) {
            indegree[neighbor]++;
        }
    }
    
    // Add all nodes with indegree 0 to queue
    queue<int> q;
    for (int i = 0; i < nodes; i++) {
        if (indegree[i] == 0) {
            q.push(i);
        }
    }
    
    int count = 0;
    while (!q.empty()) {
        int node = q.front();
        q.pop();
        count++;
        
        for (int neighbor : graph[node]) {
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                q.push(neighbor);
            }
        }
    }
    
    return count != nodes;
}

int main() {
    int n, m;
    cout << "Enter number of nodes: ";
    cin >> n;
    cout << "Enter number of edges: ";
    cin >> m;
    
    vector<vector<int>> graph(n);
    
    cout << "Enter edges (u v):" << endl;
    for (int i = 0; i < m; i++) {
        cout<<"Enter edge "<<i+1<<" : ";
        int node1, node2;
        cin >> node1 >> node2;
        graph[node1].push_back(node2);
    }
    
    if (hasCycle(n, graph)) {
        cout << "Cycle detected" << endl;
    } else {
        cout << "No cycle" << endl;
    }
    
    return 0;
}