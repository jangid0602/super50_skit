/**
 * @filename: Task6.cpp
 * @description: Detect Cycle in Directed Graph Using BFS
 * @author: Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class CycleDetector
{
public:
    bool hasCycle(
        int totalNodes,
        vector<vector<int>> &edges)
    {
        // Step 1: Build adjacency list
        vector<vector<int>> adjacencyList(totalNodes);
        vector<int> inDegree(totalNodes, 0);

        for (int i = 0; i < edges.size(); i++)
        {
            int fromNode = edges[i][0];
            int toNode = edges[i][1];

            adjacencyList[fromNode].push_back(toNode);
            inDegree[toNode]++;
        }

        // Step 2: Push nodes with in-degree 0 into queue
        queue<int> nodeQueue;
        for (int i = 0; i < totalNodes; i++)
        {
            if (inDegree[i] == 0)
                nodeQueue.push(i);
        }

        int processedNodes = 0;

        // Step 3: BFS traversal
        while (!nodeQueue.empty())
        {
            int currentNode = nodeQueue.front();
            nodeQueue.pop();
            processedNodes++;

            for (int neighbour : adjacencyList[currentNode])
            {
                inDegree[neighbour]--;

                if (inDegree[neighbour] == 0)
                    nodeQueue.push(neighbour);
            }
        }

        // Step 4: Check for cycle
        if (processedNodes < totalNodes)
            return true;   // cycle exists

        return false;      // no cycle
    }
};

int main()
{
    int totalEdges;
    cout << "Enter number of edges: ";
    cin >> totalEdges;

    vector<vector<int>> edges(totalEdges, vector<int>(2));
    cout << "Enter directed edges (from to):\n";
    for (int i = 0; i < totalEdges; i++)
        cin >> edges[i][0] >> edges[i][1];

    int totalNodes = 0;
    for (auto e : edges)
        totalNodes = max(totalNodes, max(e[0], e[1]) + 1);

    CycleDetector detector;
    bool result = detector.hasCycle(totalNodes, edges);

    if (result)
        cout << "true";
    else
        cout << "false";

    return 0;
}