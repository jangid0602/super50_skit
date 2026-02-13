/**
 * @filename - story10.cpp
 * @description - Strongly Connected Component Count (SCCC)
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;

class SccAnalyzer
{
public:
    void getFinishOrder(int current, vector<bool> &visited, stack<int> &nodes, const vector<vector<int>> &adjacencyList)
    {
        visited[current] = true;
        for (int nextNode : adjacencyList[current])
        {
            if (!visited[nextNode])
                getFinishOrder(nextNode, visited, nodes, adjacencyList);
        }
        nodes.push(current);
    }

    void traverseComponent(int current, vector<bool> &visited, const vector<vector<int>> &reverseAdjecency)
    {
        visited[current] = true;
        for (int nextNode : reverseAdjecency[current])
        {
            if (!visited[nextNode])
                traverseComponent(nextNode, visited, reverseAdjecency);
        }
    }

    int countSccs(int totalNodes, const vector<vector<int>> &adjacencyList)
    {
        stack<int> nodes;
        vector<bool> visited(totalNodes, false);

        for (int i = 0; i < totalNodes; i++)
        {
            if (!visited[i])
                getFinishOrder(i, visited, nodes, adjacencyList);
        }

        vector<vector<int>> reverseAdjecency(totalNodes);
        for (int u = 0; u < totalNodes; u++)
        {
            for (int v : adjacencyList[u])
                reverseAdjecency[v].push_back(u);
        }

        fill(visited.begin(), visited.end(), false);
        int sccCount = 0;

        while (!nodes.empty())
        {
            int curr = nodes.top();
            nodes.pop();

            if (!visited[curr])
            {
                traverseComponent(curr, visited, reverseAdjecency);
                sccCount++;
            }
        }
        return sccCount;
    }
};

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
    }

    SccAnalyzer analyzer;
    cout << analyzer.countSccs(numberOfNodes, adjacencyList) << endl;

    return 0;
}