/**
 * @filename: Task7.cpp
 * @description: Path with Maximum Average Weight
 * @author: Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class MaximumAveragePathFinder
{
public:
    bool isPathPossible(
        int totalNodes,
        vector<vector<int>> &edges,
        int src,
        int dst,
        double average)
    {
        vector<double> distance(totalNodes, -1e9);
        distance[src] = 0;

        // Bellman-Ford relaxation
        for (int i = 0; i < totalNodes - 1; i++)
        {
            for (auto &edge : edges)
            {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];

                double modifiedWeight = weight - average;

                if (distance[from] > -1e8 &&
                    distance[from] + modifiedWeight > distance[to])
                {
                    distance[to] = distance[from] + modifiedWeight;
                }
            }
        }

        return distance[dst] >= 0;
    }

    double findMaximumAverage(
        int totalNodes,
        vector<vector<int>> &edges,
        int src,
        int dst)
    {
        // Check reachability first
        vector<int> reachable(totalNodes, 0);
        reachable[src] = 1;

        for (int i = 0; i < totalNodes; i++)
        {
            for (auto &e : edges)
                if (reachable[e[0]])
                    reachable[e[1]] = 1;
        }

        if (!reachable[dst])
            return -1;

        double low = -10000, high = 10000;
        double answer = -1;

        // Binary search on average
        for (int i = 0; i < 60; i++)
        {
            double mid = (low + high) / 2;

            if (isPathPossible(totalNodes, edges, src, dst, mid))
            {
                answer = mid;
                low = mid;
            }
            else
            {
                high = mid;
            }
        }

        return answer;
    }
};

int main()
{
    int totalEdges;
    cout << "Enter number of edges: ";
    cin >> totalEdges;

    vector<vector<int>> edges(totalEdges, vector<int>(3));
    cout << "Enter edges (from to weight):\n";
    for (int i = 0; i < totalEdges; i++)
        cin >> edges[i][0] >> edges[i][1] >> edges[i][2];

    int src, dst;
    cout << "Enter source and destination: ";
    cin >> src >> dst;

    int totalNodes = 0;
    for (auto e : edges)
        totalNodes = max(totalNodes, max(e[0], e[1]) + 1);

    MaximumAveragePathFinder finder;
    double result = finder.findMaximumAverage(
        totalNodes, edges, src, dst);

    if (result == -1)
        cout << -1;
    else
        cout << result;

    return 0;
}