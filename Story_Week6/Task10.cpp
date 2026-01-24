/**
 * @filename: Task10.cpp
 * @description: Strongly Connected Components Count
 * @author: Ayushi Shukla
 */


#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class StronglyConnectedComponents
{
private:
    void dfsFillOrder(
        int node,
        vector<vector<int>> &graph,
        vector<bool> &visited,
        stack<int> &nodeStack)
    {
        visited[node] = true;

        for (int neighbour : graph[node])
        {
            if (!visited[neighbour])
                dfsFillOrder(neighbour, graph, visited, nodeStack);
        }

        nodeStack.push(node);
    }

    void dfsOnReversedGraph(
        int node,
        vector<vector<int>> &reversedGraph,
        vector<bool> &visited)
    {
        visited[node] = true;

        for (int neighbour : reversedGraph[node])
        {
            if (!visited[neighbour])
                dfsOnReversedGraph(neighbour, reversedGraph, visited);
        }
    }

public:
    int countSCCs(int totalNodes, vector<vector<int>> &edges)
    {
        vector<vector<int>> graph(totalNodes);
        vector<vector<int>> reversedGraph(totalNodes);

        // Build graph and reversed graph
        for (auto e : edges)
        {
            graph[e[0]].push_back(e[1]);
            reversedGraph[e[1]].push_back(e[0]);
        }

        // Step 1: Fill stack by finish time
        vector<bool> visited(totalNodes, false);
        stack<int> nodeStack;

        for (int i = 0; i < totalNodes; i++)
        {
            if (!visited[i])
                dfsFillOrder(i, graph, visited, nodeStack);
        }

        // Step 2: DFS on reversed graph
        for (int i = 0; i < totalNodes; i++)
            visited[i] = false;

        int sccCount = 0;

        while (!nodeStack.empty())
        {
            int node = nodeStack.top();
            nodeStack.pop();

            if (!visited[node])
            {
                dfsOnReversedGraph(node, reversedGraph, visited);
                sccCount++;
            }
        }

        return sccCount;
    }
};

int main()
{
    int totalEdges;
    cout << "Enter number of edges: ";
    cin >> totalEdges;

    vector<vector<int>> edges(totalEdges, vector<int>(2));
    cout << "Enter edges (from to):\n";
    for (int i = 0; i < totalEdges; i++)
        cin >> edges[i][0] >> edges[i][1];

    int totalNodes = 0;
    for (auto e : edges)
        totalNodes = max(totalNodes, max(e[0], e[1]) + 1);

    StronglyConnectedComponents scc;
    cout << "Number of SCCs: "
         << scc.countSCCs(totalNodes, edges);

    return 0;
}