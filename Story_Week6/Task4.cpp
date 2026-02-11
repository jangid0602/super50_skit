/**
 * @filename: Task4.cpp
 * @description:  Dijkstra Using Adjacency Matrix
 * @author: Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class DijkstraSolver
{
public:
    vector<int> shortestDistanceFromSource(
        vector<vector<int>> &matrix,
        int source)
    {
        int totalVertices = matrix.size();

        vector<int> distance(totalVertices, INT_MAX);
        vector<bool> visited(totalVertices, false);

        distance[source] = 0;

        // Repeat for all vertices
        for (int count = 0; count < totalVertices - 1; count++)
        {
            int currentVertex = -1;
            int minimumDistance = INT_MAX;

            // Step 1: Pick unvisited vertex with smallest distance
            for (int i = 0; i < totalVertices; i++)
            {
                if (!visited[i] && distance[i] < minimumDistance)
                {
                    minimumDistance = distance[i];
                    currentVertex = i;
                }
            }

            if (currentVertex == -1)
                break;

            visited[currentVertex] = true;

            // Step 2: Update neighbours
            for (int neighbour = 0; neighbour < totalVertices; neighbour++)
            {
                int edgeWeight = matrix[currentVertex][neighbour];

                if (!visited[neighbour] &&
                    edgeWeight != 0 &&
                    distance[currentVertex] != INT_MAX &&
                    distance[currentVertex] + edgeWeight < distance[neighbour])
                {
                    distance[neighbour] =
                        distance[currentVertex] + edgeWeight;
                }
            }
        }

        return distance;
    }
};

int main()
{
    int totalVertices;
    cout << "Enter number of vertices: ";
    cin >> totalVertices;

    vector<vector<int>> matrix(totalVertices,
                               vector<int>(totalVertices));

    cout << "Enter adjacency matrix:\n";
    for (int i = 0; i < totalVertices; i++)
        for (int j = 0; j < totalVertices; j++)
            cin >> matrix[i][j];

    int source;
    cout << "Enter source vertex: ";
    cin >> source;

    DijkstraSolver solver;
    vector<int> result =
        solver.shortestDistanceFromSource(matrix, source);

    cout << "Shortest distances:\n";
    for (int i = 0; i < result.size(); i++)
    {
        if (result[i] == INT_MAX)
            cout << "∞ ";
        else
            cout << result[i] << " ";
    }

    return 0;
}