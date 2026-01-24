/**
 * @filename: Task5.cpp
 * @description:  Find K Nearest Servers
 * @author: Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <algorithm>
using namespace std;

class NearestServerFinder
{
public:
    vector<int> findKNearestServers(
        int totalServers,
        vector<vector<int>> &edges,
        int sourceServer,
        int k)
    {
        // Step 1: Create adjacency list
        vector<vector<pair<int, int>>> adjacencyList(totalServers);

        for (int i = 0; i < edges.size(); i++)
        {
            int serverA = edges[i][0];
            int serverB = edges[i][1];
            int latency = edges[i][2];

            adjacencyList[serverA].push_back({serverB, latency});
            adjacencyList[serverB].push_back({serverA, latency});
        }

        // Step 2: Dijkstra to find shortest distance
        vector<int> distance(totalServers, INT_MAX);
        distance[sourceServer] = 0;

        priority_queue<
            pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>>
            minHeap;

        minHeap.push({0, sourceServer});

        while (!minHeap.empty())
        {
            int currentDistance = minHeap.top().first;
            int currentServer = minHeap.top().second;
            minHeap.pop();

            for (auto neighbour : adjacencyList[currentServer])
            {
                int nextServer = neighbour.first;
                int edgeLatency = neighbour.second;

                if (currentDistance + edgeLatency < distance[nextServer])
                {
                    distance[nextServer] =
                        currentDistance + edgeLatency;
                    minHeap.push(
                        {distance[nextServer], nextServer});
                }
            }
        }

        // Step 3: Collect all reachable servers
        vector<pair<int, int>> serverDistanceList;
        for (int i = 0; i < totalServers; i++)
        {
            if (distance[i] != INT_MAX)
                serverDistanceList.push_back({distance[i], i});
        }

        // Step 4: Sort by distance
        sort(serverDistanceList.begin(),
             serverDistanceList.end());

        // Step 5: Pick first k servers
        vector<int> result;
        for (int i = 0;
             i < serverDistanceList.size() && i < k;
             i++)
        {
            result.push_back(serverDistanceList[i].second);
        }

        return result;
    }
};

int main()
{
    int totalEdges;
    cout << "Enter number of edges: ";
    cin >> totalEdges;

    vector<vector<int>> edges(totalEdges, vector<int>(3));
    cout << "Enter edges (server1 server2 latency):\n";
    for (int i = 0; i < totalEdges; i++)
        cin >> edges[i][0] >> edges[i][1] >> edges[i][2];

    int sourceServer, k;
    cout << "Enter source server and k: ";
    cin >> sourceServer >> k;

    int totalServers = sourceServer + 1;
    for (auto e : edges)
        totalServers =
            max(totalServers, max(e[0], e[1]) + 1);

    NearestServerFinder finder;
    vector<int> answer =
        finder.findKNearestServers(
            totalServers, edges, sourceServer, k);

    cout << "K Nearest Servers: ";
    for (int server : answer)
        cout << server << " ";

    return 0;
}