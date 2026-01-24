/**
 * @filename: Task8.cpp
 * @description: Shortest Path Visiting All Nodes
 * @author: Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class AllNodesPathFinder
{
public:
    int shortestPathLength(vector<vector<int>> &graph)
    {
        int totalNodes = graph.size();

        // Special case: only one node
        if (totalNodes == 1)
            return 0;

        int allVisitedMask = (1 << totalNodes) - 1;

        queue<pair<int, int>> bfsQueue;
        vector<vector<bool>> visited(
            totalNodes, vector<bool>(1 << totalNodes, false));

        // Step 1: Start BFS from every node
        for (int node = 0; node < totalNodes; node++)
        {
            int mask = (1 << node);
            bfsQueue.push({node, mask});
            visited[node][mask] = true;
        }

        int pathLength = 0;

        // Step 2: BFS traversal
        while (!bfsQueue.empty())
        {
            int levelSize = bfsQueue.size();

            while (levelSize--)
            {
                int currentNode = bfsQueue.front().first;
                int currentMask = bfsQueue.front().second;
                bfsQueue.pop();

                // If all nodes visited
                if (currentMask == allVisitedMask)
                    return pathLength;

                for (int neighbour : graph[currentNode])
                {
                    int nextMask =
                        currentMask | (1 << neighbour);

                    if (!visited[neighbour][nextMask])
                    {
                        visited[neighbour][nextMask] = true;
                        bfsQueue.push({neighbour, nextMask});
                    }
                }
            }

            pathLength++;
        }

        return -1; // should not reach here
    }
};

int main()
{
    int totalEdges;
    cout << "Enter number of edges: ";
    cin >> totalEdges;

    vector<vector<int>> edges(totalEdges, vector<int>(2));
    cout << "Enter edges:\n";
    for (int i = 0; i < totalEdges; i++)
        cin >> edges[i][0] >> edges[i][1];

    int totalNodes = 0;
    for (auto e : edges)
        totalNodes = max(totalNodes, max(e[0], e[1]) + 1);

    vector<vector<int>> graph(totalNodes);
    for (auto e : edges)
    {
        graph[e[0]].push_back(e[1]);
        graph[e[1]].push_back(e[0]);
    }

    AllNodesPathFinder finder;
    cout << "Shortest Path Length: "
         << finder.shortestPathLength(graph);

    return 0;
}
