/**
 * @filename - story2.cpp
 * @description - Find the safest path in a city
 * @author - Disha Toshniwal
 */

#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

int findSafestPath(
    int numberOfNodes,
    vector<vector<pair<int, int>>> &adjacencyList,
    int startNode,
    int endNode)
{

    priority_queue<
        pair<int, int>,
        vector<pair<int, int>>,
        greater<pair<int, int>>>
        minHeap;

    vector<int> minimumRisk(numberOfNodes, INT_MAX);

    minimumRisk[startNode] = 0;
    minHeap.push({0, startNode});

    while (!minHeap.empty())
    {
        int currentPathRisk = minHeap.top().first;
        int currentNode = minHeap.top().second;
        minHeap.pop();

        if (currentNode == endNode)
        {
            return currentPathRisk;
        }

        for (auto &neighbor : adjacencyList[currentNode])
        {
            int nextNode = neighbor.first;
            int edgeRisk = neighbor.second;

            int newPathRisk = max(currentPathRisk, edgeRisk);

            if (newPathRisk < minimumRisk[nextNode])
            {
                minimumRisk[nextNode] = newPathRisk;
                minHeap.push({newPathRisk, nextNode});
            }
        }
    }

    return -1;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    vector<vector<pair<int, int>>> adjacencyList(numberOfNodes);

    int numberOfEdges;
    cout << "Enter number of edges:\n";
    cin >> numberOfEdges;

    for (int i = 0; i < numberOfEdges; i++)
    {
        int fromNode, toNode, riskLevel;
        cout << "Enter edge (from to riskLevel): ";
        cin >> fromNode >> toNode >> riskLevel;
        adjacencyList[fromNode].push_back({toNode, riskLevel});
    }

    int startNode, endNode;
    cout << "Enter start node: ";
    cin >> startNode;
    cout << "Enter end node: ";
    cin >> endNode;

    int safestRisk =
        findSafestPath(
            numberOfNodes,
            adjacencyList,
            startNode,
            endNode);

    if (safestRisk == -1)
    {
        cout << "No safe path exists";
    }
    else
    {
        cout << "Minimum possible risk value is "
             << safestRisk;
    }

    return 0;
}
