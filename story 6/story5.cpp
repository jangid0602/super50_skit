/**
 * @filename - story5.cpp
 * @description - K nearest servers
 * @author - Disha Toshniwal
 */

#include <bits/stdc++.h>
using namespace std;

vector<vector<pair<int, int>>> buildAdjacencyList(
    int numberOfServers,
    vector<vector<int>> &edges)
{
    vector<vector<pair<int, int>>> adjacencyList(numberOfServers);

    for (auto &edge : edges)
    {
        int fromServer = edge[0];
        int toServer = edge[1];
        int latency = edge[2];

        adjacencyList[fromServer].push_back({toServer, latency});
        adjacencyList[toServer].push_back({fromServer, latency});
    }

    return adjacencyList;
}

vector<int> calculateShortestLatency(
    int numberOfServers,
    vector<vector<pair<int, int>>> &adjacencyList,
    int sourceServer)
{
    vector<int> minimumLatency(numberOfServers, INT_MAX);

    priority_queue<
        pair<int, int>,
        vector<pair<int, int>>,
        greater<>>
        minHeap;

    minimumLatency[sourceServer] = 0;
    minHeap.push({0, sourceServer});

    while (!minHeap.empty())
    {
        int currentLatency = minHeap.top().first;
        int currentServer = minHeap.top().second;
        minHeap.pop();

        if (currentLatency > minimumLatency[currentServer])
            continue;

        for (auto &neighbor : adjacencyList[currentServer])
        {
            int nextServer = neighbor.first;
            int edgeLatency = neighbor.second;

            if (minimumLatency[nextServer] >
                currentLatency + edgeLatency)
            {
                minimumLatency[nextServer] =
                    currentLatency + edgeLatency;

                minHeap.push({minimumLatency[nextServer], nextServer});
            }
        }
    }

    return minimumLatency;
}

vector<int> findKNearestServers(
    vector<int> &minimumLatency,
    int kNearest)
{
    vector<pair<int, int>> serversByDistance;

    for (int i = 0; i < minimumLatency.size(); i++)
    {
        if (minimumLatency[i] != INT_MAX)
        {
            serversByDistance.push_back(
                {minimumLatency[i], i});
        }
    }

    sort(serversByDistance.begin(), serversByDistance.end());

    vector<int> result;
    for (int i = 0; i < kNearest && i < serversByDistance.size(); i++)
    {
        result.push_back(serversByDistance[i].second);
    }

    return result;
}

int main()
{
    int numberOfServers, numberOfEdges;
    cout << "Enter number of servers and edges:\n";
    cin >> numberOfServers >> numberOfEdges;

    vector<vector<int>> edges(numberOfEdges, vector<int>(3));
    for (int i = 0; i < numberOfEdges; i++)
    {
        cout << "Enter sourceServer ,destinationServer ,latency:\n";
        cin >> edges[i][0] >> edges[i][1] >> edges[i][2];
    }

    int sourceServer, kNearest;
    cout << "Enter source server and k:\n";
    cin >> sourceServer >> kNearest;

    vector<vector<pair<int, int>>> adjacencyList =
        buildAdjacencyList(numberOfServers, edges);

    vector<int> minimumLatency =
        calculateShortestLatency(
            numberOfServers, adjacencyList, sourceServer);

    vector<int> nearestServers =
        findKNearestServers(minimumLatency, kNearest);

    cout << "K nearest servers:\n";
    for (int server : nearestServers)
    {
        cout << server << " ";
    }

    return 0;
}
