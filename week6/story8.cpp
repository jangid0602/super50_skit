/**
 * @filename - story8.cpp
 * @description - Shortest path visiting all nodes
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <limits.h>
#include <algorithm>

using namespace std;

const int INF = 1e8; 

// Function to find the shortest path between all pairs using Floyd-Warshall
vector<vector<int>> computeAllPairsShortestPaths(int numberOfNodes, const vector<vector<int>> &adjacencyList)
{

    vector<vector<int>> distanceMatrix(numberOfNodes, vector<int>(numberOfNodes, INF));

    for (int currentNode = 0; currentNode < numberOfNodes; currentNode++)
    {
        distanceMatrix[currentNode][currentNode] = 0;
        for (int neighbor : adjacencyList[currentNode])
        {
            distanceMatrix[currentNode][neighbor] = 1;
        }
    }

    // Floyd-Warshall Algorithm
    for (int intermediateNode = 0; intermediateNode < numberOfNodes; intermediateNode++)
    {
        for (int sourceNode = 0; sourceNode < numberOfNodes; sourceNode++)
        {
            for (int destinationNode = 0; destinationNode < numberOfNodes; destinationNode++)
            {
                if (distanceMatrix[sourceNode][intermediateNode] != INF && distanceMatrix[intermediateNode][destinationNode] != INF)
                {
                    distanceMatrix[sourceNode][destinationNode] = min(distanceMatrix[sourceNode][destinationNode],
                                                                      distanceMatrix[sourceNode][intermediateNode] + distanceMatrix[intermediateNode][destinationNode]);
                }
            }
        }
    }
    return distanceMatrix;
}

// Function to find the minimum path length to visit all nodes
int findMinimumPathVisitingAllNodes(int numberOfNodes, const vector<vector<int>> &distanceMatrix)
{

    vector<int> nodeSequence(numberOfNodes);
    for (int i = 0; i < numberOfNodes; i++)
        nodeSequence[i] = i;

    int minimumTotalPathLength = INF;

    do
    {
        int currentPathLength = 0;
        bool validPath = true;
        for (int nodeIndex = 0; nodeIndex < numberOfNodes - 1; nodeIndex++)
        {
            int fromNode = nodeSequence[nodeIndex];
            int toNode = nodeSequence[nodeIndex + 1];
            if (distanceMatrix[fromNode][toNode] == INF)
            {
                validPath = false;
                break;
            }
            currentPathLength += distanceMatrix[fromNode][toNode];
        }
        if (validPath)
        {
            minimumTotalPathLength = min(minimumTotalPathLength, currentPathLength);
        }
    } while (next_permutation(nodeSequence.begin(), nodeSequence.end()));

    return minimumTotalPathLength;
}

int main()
{
    int numberOfNodes, numberOfEdges;
    cout << "Enter the number of nodes: ";
    cin >> numberOfNodes;
    cout << "Enter the number of edges: ";
    cin >> numberOfEdges;

    vector<vector<int>> adjacencyList(numberOfNodes);

    cout << "Enter edges (format: u v for an edge between u and v):" << endl;
    for (int i = 0; i < numberOfEdges; i++)
    {
        int sourceNode, destinationNode;
        cout << "Enter edge : " << i + 1 << " : ";
        cin >> sourceNode >> destinationNode;
        adjacencyList[sourceNode].push_back(destinationNode);
        adjacencyList[destinationNode].push_back(sourceNode);
    }

    if (numberOfNodes == 0)
    {
        cout << "Shortest path length: 0" << endl;
        return 0;
    }

    vector<vector<int>> distanceMatrix = computeAllPairsShortestPaths(numberOfNodes, adjacencyList);

    int minimumPathLength = findMinimumPathVisitingAllNodes(numberOfNodes, distanceMatrix);

    cout << "Shortest path length visiting all nodes: " << minimumPathLength << endl;

    return 0;
}